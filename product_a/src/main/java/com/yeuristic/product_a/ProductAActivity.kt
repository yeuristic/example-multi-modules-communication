package com.yeuristic.product_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeuristic.product_a.databinding.ActivityProductABinding

class ProductAActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityProductABinding
    lateinit var presenter: ProductAPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductABinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ProductAPresenter()
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