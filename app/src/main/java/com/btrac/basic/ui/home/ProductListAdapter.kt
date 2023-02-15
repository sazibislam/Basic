package com.btrac.basic.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.btrac.basic.data.response.DummyResponse2
import com.btrac.basic.databinding.RowViewProductBinding
import com.btrac.basic.ui.BaseViewHolder

class ProductListAdapter(private val data: MutableList<DummyResponse2.Result> = ArrayList()) :
  RecyclerView.Adapter<BaseViewHolder>() {

  override fun getItemCount() = data.size

  override fun onBindViewHolder(
    holder: BaseViewHolder,
    position: Int
  ) = holder.onBind(position)

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder = ViewHolder(
    RowViewProductBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
  )

  internal fun addDataToList(data: List<DummyResponse2.Result>) {
    this.data.clear()
    this.data.addAll(data)
    notifyDataSetChanged()
  }

  inner class ViewHolder(private val binding: RowViewProductBinding) :
    BaseViewHolder(binding.root) {

    override fun clear() {
      binding.apply {
        tvTitle.text = ""
      }
    }

    override fun onBind(position: Int) {

      val model = data[position]
      binding.apply {
        tvTitle.text = model.category

      }
    }
  }
}