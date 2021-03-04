package com.yeuristic.multimoduleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeuristic.multimoduleapplication.databinding.ActivityMainBinding
import com.yeuristic.product_a.ProductAActivity
import com.yeuristic.product_b.ProductBActivity
import com.yeuristic.purchase.PurchaseListActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.buttonProductA.setOnClickListener(this)
        binding.buttonProductB.setOnClickListener(this)
        binding.buttonPurchase.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.buttonProductA -> startActivity(Intent(this, ProductAActivity::class.java))
            binding.buttonProductB -> startActivity(Intent(this, ProductBActivity::class.java))
            binding.buttonPurchase -> startActivity(Intent(this, PurchaseListActivity::class.java))
        }
    }
}