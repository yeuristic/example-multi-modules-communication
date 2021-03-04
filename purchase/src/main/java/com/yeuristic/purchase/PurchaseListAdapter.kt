package com.yeuristic.purchase

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PurchaseListAdapter(
    private val data: List<BasePurchaseData>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = data.size
}