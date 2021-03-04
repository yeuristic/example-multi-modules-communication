package com.yeuristic.multimoduleapplication

import android.app.Application
import com.yeuristic.message.MessageDIManager
import com.yeuristic.message.MessageRouteDelegate
import com.yeuristic.message.MessageSubComponent
import com.yeuristic.product_a.ProductAMessageReceiver.PRODUCT_A
import com.yeuristic.product_a.ProductAMessageReceiver.PRODUCT_A_DETAIL
import com.yeuristic.product_b.ProductBMessageReceiver.PRODUCT_B
import com.yeuristic.product_b.ProductBMessageReceiver.PRODUCT_B_DETAIL
import timber.log.Timber

class MApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val messageSubComponent = object : MessageSubComponent {
            override fun getMessageDelegates(): Set<MessageRouteDelegate> {
                return setOf(
                    ProductAMessageRouteDelegate,
                    ProductBMessageRouteDelegate
                )
            }

        }
        MessageDIManager.init(messageSubComponent)
    }

    object ProductAMessageRouteDelegate: MessageRouteDelegate {
        override fun getSmsRoute(): List<String> {
            return listOf(
                PRODUCT_A,
                PRODUCT_A_DETAIL
            )
        }

        override fun getEmailRoute(): List<String> {
            return listOf(PRODUCT_A_DETAIL)
        }

        override fun getPushNotificationRoute(): List<String> {
            return listOf(
                PRODUCT_A,
                PRODUCT_A_DETAIL
            )
        }

    }

    object ProductBMessageRouteDelegate: MessageRouteDelegate {
        override fun getSmsRoute(): List<String> {
            return emptyList()
        }

        override fun getEmailRoute(): List<String> {
            return listOf(PRODUCT_B_DETAIL)
        }

        override fun getPushNotificationRoute(): List<String> {
            return listOf(
                PRODUCT_B,
                PRODUCT_B_DETAIL
            )
        }

    }
}