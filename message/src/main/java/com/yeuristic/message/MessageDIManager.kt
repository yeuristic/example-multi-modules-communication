package com.yeuristic.message

object MessageDIManager {
    private lateinit var messageSubComponent: MessageSubComponent
    fun init(messageSubComponent: MessageSubComponent) {
        this.messageSubComponent = messageSubComponent
    }
    fun get(): MessageSubComponent = messageSubComponent
}