package com.yeuristic.message

class MessageSender {
    private val map: MutableMap<String, Option> = mutableMapOf()

    private val smsMessageService: SmsMessageService = SmsMessageService()
    private val emailMessageService: EmailMessageService = EmailMessageService()
    private val pnMessageService: PushNotificationMessageService = PushNotificationMessageService()

    init {
        initSms()
        initEmail()
        initPn()
    }

    private fun initSms() {
        for (delegate in MessageDIManager.get().getMessageDelegates()) {
            for (smsReceiverId in delegate.getSmsRoute()) {
                addRoute(smsReceiverId, MessageProvider.SMS)
            }
        }
    }

    private fun initEmail() {
        for (delegate in MessageDIManager.get().getMessageDelegates()) {
            for (smsReceiverId in delegate.getEmailRoute()) {
                addRoute(smsReceiverId, MessageProvider.EMAIL)
            }
        }
    }

    private fun initPn() {
        for (delegate in MessageDIManager.get().getMessageDelegates()) {
            for (smsReceiverId in delegate.getPushNotificationRoute()) {
                addRoute(smsReceiverId, MessageProvider.PN)
            }
        }
    }

    private fun addRoute(receiverId: String, messageProvider: String, enabled: Boolean = true) {
        val option = map[receiverId] ?: Option()
        option.target[messageProvider] = enabled
        map[receiverId] = option
    }

    fun sendMessage(receiverId: String, message: Message) {
        val targets = map[receiverId]?.target?.filter { it.value }?.map { it.key } ?: emptyList()
        for (target in targets) {
            when (target) {
                MessageProvider.SMS -> smsMessageService.sendMessage(receiverId, message)
                MessageProvider.EMAIL -> emailMessageService.sendMessage(receiverId, message)
                MessageProvider.PN -> pnMessageService.sendMessage(receiverId, message)
            }
        }
    }

    fun disableRoute(receiverIds: List<String>, messageProvider: String) {
        for (receiverId in receiverIds) {
            addRoute(receiverId, messageProvider, false)
        }
    }

    class Option (
        val target: MutableMap<String, Boolean> = mutableMapOf()
    )
}