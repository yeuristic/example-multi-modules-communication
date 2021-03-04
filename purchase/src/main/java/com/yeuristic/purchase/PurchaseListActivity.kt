package com.yeuristic.purchase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeuristic.purchase.databinding.ActivityPurchaseBinding

class PurchaseListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPurchaseBinding
    private lateinit var presenter: PurchaseListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = PurchaseListPresenter()
        initView()
    }

    private fun initView() {
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = PurchaseListAdapter(presenter.getData())
        }
    }
}