package com.yeuristic.product_a

import com.yeuristic.message.Message
import com.yeuristic.message.MessageSender

class ProductADetailPresenter {
    fun sendMessage() {
        MessageSender().sendMessage(ProductAMessageReceiver.PRODUCT_A_DETAIL, Message("title", "body"))
    }
}