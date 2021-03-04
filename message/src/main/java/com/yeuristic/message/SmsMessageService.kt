package com.yeuristic.message

import timber.log.Timber

class SmsMessageService: MessageService {
    override fun sendMessage(receiverId: String, message: Message) {
        Timber.d("To: %s --- Message: %s", receiverId, message.toString())
    }
}