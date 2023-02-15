package com.btrac.basic.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.response.DummyResponse2
import com.btrac.basic.domain.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(
  private val repository: HomeRepository,
  private val sessionPrefs: Prefs
) : ViewModel() {

  val homeDataList = MutableLiveData<List<DummyResponse2.Result>?>()

  init {
    getHomeData()
  }

  private fun getHomeData() {
    viewModelScope.launch {

      repository.getHomeData().collect {
        when (it) {
          is ResponseResource.Error -> {
            Log.d("HomeViewModel", "Some error happened ${it.errorMessage}")
          }
          is ResponseResource.Success -> {
            homeDataList.postValue(it.data.results)
            Log.d("HomeViewModel", "${it.data}")
          }
        }
      }
    }
  }
}