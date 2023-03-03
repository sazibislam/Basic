package com.btrac.basic.utils.networking

import com.btrac.basic.utils.networking.Status.ERROR
import com.btrac.basic.utils.networking.Status.LOADING
import com.btrac.basic.utils.networking.Status.SUCCESS

data class State<out T>(
  val status: Status,
  val data: T?,
  val message: String?
) {

  companion object {

    fun <T> success(msg: String?, data: T?): State<T> = State(SUCCESS, data, msg)
    fun <T> loading(data: T?): State<T> = State(LOADING, data, null)
    fun <T> error(msg: String, data: T?): State<T> = State(ERROR, data, msg)
  }
}