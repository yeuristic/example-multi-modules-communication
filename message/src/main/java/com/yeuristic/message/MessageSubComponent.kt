package com.yeuristic.message

interface MessageSubComponent {
    fun getMessageDelegates(): Set<MessageRouteDelegate>
}