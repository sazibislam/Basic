package com.btrac.basic.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.response.DummyResponse
import com.btrac.basic.domain.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(
  private val repository: HomeRepository,
  private val sessionPrefs: Prefs
) : ViewModel() {

  val homeDataList = MutableLiveData<DummyResponse?>()

  // init {
  //   getHomeData()
  // }

  fun getHomeData() {
    viewModelScope.launch {

      repository.getHomeData().collect {
        when (it) {
          is ResponseResource.Error -> {
            Log.d("HomeViewModel", "Some error happened")
          }
          is ResponseResource.Success -> {
            homeDataList.postValue(it.data)
            Log.d("HomeViewModel", "${it.data.size}")
          }
        }
      }
    }
  }
}