package com.yeuristic.product_b

import com.yeuristic.message.Message
import com.yeuristic.message.MessageSender

class ProductBPresenter {
    fun sendMessage() {
        MessageSender().sendMessage(ProductBMessageReceiver.PRODUCT_B, Message("title", "body"))
    }
}