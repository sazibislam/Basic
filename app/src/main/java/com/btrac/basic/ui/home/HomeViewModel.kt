package com.btrac.basic.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.remote.response.DummyResponse2.Result
import com.btrac.basic.domain.repository.HomeRepository
import com.btrac.basic.utils.AppConstants.APP_ERROR_MESSAGE
import com.btrac.basic.utils.AppConstants.APP_SUCCESS_MESSAGE
import com.btrac.basic.utils.networking.State
import kotlinx.coroutines.launch

class HomeViewModel(
  private val repository: HomeRepository,
  private val sessionPrefs: Prefs
) : ViewModel() {

  val homeDataList = MutableLiveData<List<Result>?>()
  val userDataList = MutableLiveData<State<List<Result>>>()

  init {
    // getHomeData()
    getUserdata()
  }

  private fun getUserdata() {
    viewModelScope.launch {

      repository.getUserListData().collect {
        when (it) {
          is ResponseResource.Error -> {
            Log.d("HomeViewModel", "Some error happened ${it.errorMessage}")
          }
          is ResponseResource.Success -> {
            userDataList.postValue(
              State.success(
                msg = APP_SUCCESS_MESSAGE,
                data = null /*add your data*/
              )
            )
            Log.d("HomeViewModel", "${it.data}")
          }
        }
      }
    }
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