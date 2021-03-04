package com.yeuristic.message

interface MessageService {
    fun sendMessage(receiverId: String, message: Message)
}