package com.btrac.basic.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder(itemView: View) : ViewHolder(itemView) {

  private var currentPosition: Int = 0

  abstract fun clear()

  open fun onBind(position: Int) {
    currentPosition = position
  }
}
