package com.yeuristic.message

interface MessageRouteDelegate {
    fun getSmsRoute(): List<String>
    fun getEmailRoute(): List<String>
    fun getPushNotificationRoute(): List<String>
}