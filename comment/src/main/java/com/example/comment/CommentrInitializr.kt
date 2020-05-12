package com.example.comment

object CommentrInitializr {

    private var commentComponent: CommentComponent? = null

    fun init(hostComponent: HostComponent) {
        commentComponent = DaggerCommentComponent.builder()
            .hostComponent(hostComponent)
            .build()
    }

    fun getCommentComponent(): CommentComponent {
        // assume init'd before getting
        return commentComponent!!
    }
}