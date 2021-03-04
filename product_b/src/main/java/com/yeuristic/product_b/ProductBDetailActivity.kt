package com.yeuristic.product_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeuristic.product_b.databinding.ActivityProductBDetailBinding

const val PURCHASE_ID_KEY = "PURCHASE_ID_KEY"
class ProductBDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityProductBDetailBinding
    private lateinit var presenter: ProductBDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val purchaseId = intent.getStringExtra(PURCHASE_ID_KEY) ?: ""
        binding.textViewPurchaseId.text = purchaseId
        presenter = ProductBDetailPresenter()
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