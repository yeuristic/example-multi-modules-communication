package com.yeuristic.product_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeuristic.product_a.databinding.ActivityProductADetailBinding

const val PURCHASE_ID_KEY = "PURCHASE_ID_KEY"
class ProductADetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityProductADetailBinding
    private lateinit var presenter: ProductADetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductADetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val purchaseId = intent.getStringExtra(PURCHASE_ID_KEY) ?: ""
        binding.textViewPurchaseId.text = purchaseId
        presenter = ProductADetailPresenter()
        initListener()
    }

    private fun initListener() {
        binding.buttonSendMessage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.buttonSendMessage -> presenter.sendMessage()
        }
    }
}