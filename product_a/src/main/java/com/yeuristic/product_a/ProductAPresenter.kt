package com.yeuristic.product_a

import com.yeuristic.message.Message
import com.yeuristic.message.MessageSender

class ProductAPresenter {
    fun sendMessage() {
        MessageSender().sendMessage(ProductAMessageReceiver.PRODUCT_A, Message("title", "body"))
    }
}