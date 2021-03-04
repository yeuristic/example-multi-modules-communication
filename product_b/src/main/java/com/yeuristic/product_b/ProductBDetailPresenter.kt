package com.yeuristic.product_b

import com.yeuristic.message.Message
import com.yeuristic.message.MessageSender

class ProductBDetailPresenter {
    fun sendMessage() {
        MessageSender().sendMessage(ProductBMessageReceiver.PRODUCT_B_DETAIL, Message("title", "body"))
    }
}