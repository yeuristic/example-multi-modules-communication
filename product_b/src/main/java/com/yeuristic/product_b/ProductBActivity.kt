package com.yeuristic.product_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeuristic.product_b.databinding.ActivityProductBBinding

class ProductBActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityProductBBinding
    private lateinit var presenter: ProductBPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ProductBPresenter()
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