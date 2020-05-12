## The current situation

[Initial blog post](https://proandroiddev.com/dagger-component-dependencies-for-library-development-e2df7ce68233)

The goal is to pass objects *down* from one Dagger component to another.

Given `app` Gradle module which depends on `comment` Gradle module, each with their own Dagger `Component`. Can `app` supply an object which `comment` needs to build *its* object graph?

In this case `app` is creating `FirebaseAnalytics` which satisfies `comment`'s need for a `HostAnalytics` implementation.

## The problem
This all works fine. But what if `comment` module also supplys objects needed **up** in the `app` module? In this example see `SomeManager`.

`SomeManager` is created and provided in `comment` module (see `ComnentModule`)
and needed in `app` module (see `MainActivity`).  

I would *think* that I would need to have `AppComponent` depend on `CommentComponent`:

```
@Component(
    modules = [KittnModule::class],
    dependencies = [CommentComponent::class]
)
interface AppComponent : HostComponent {
```

And then pass `CommentComponent` to `AppComponent`'s builder. But that creates a sort of circular dependency. See `KittnApplication`:

```
appComponent = DaggerAppComponent.builder()
    // How can I set commentComponent if I can't create it 
    // until AFTER creating appcomponent??
    .commentComponent(???)
    .build()

CommentrInitializr.init(appComponent)
commentComponent = CommentrInitializr.getCommentComponent()
```


## Craziness

What's crazy is that if I remove the component dependency:

```
@Component(
    modules = [KittnModule::class]
   // dependencies = [CommentComponent::class] // REMOVE THIS
)
interface AppComponent : HostComponent {
```

```
appComponent = DaggerAppComponent.builder()
    // .commentComponent(???) REMOVE THIS
    .build()

CommentrInitializr.init(appComponent)
commentComponent = CommentrInitializr.getCommentComponent()
```

Then everything builds fine!!! Somehow `MainActivity` is correctly getting an instance of `SomeManager`!!! How is this possible?