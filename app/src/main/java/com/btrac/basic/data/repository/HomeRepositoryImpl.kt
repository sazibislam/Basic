package com.btrac.basic.data.repository

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.remote.response.DummyResponse2
import com.btrac.basic.data.remote.response.DummyUserResponse
import com.btrac.basic.data.remote.source.HomeRemote
import com.btrac.basic.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
  private val remote: HomeRemote,
  private val sessionPrefs: Prefs
) : HomeRepository {

  override suspend fun getHomeData(): Flow<ResponseResource<DummyResponse2>> =
    flow {
      val responseResource = when (val response = remote.getHomeList()) {
        is ResponseResource.Error -> ResponseResource.error(response.errorMessage)
        is ResponseResource.Success -> ResponseResource.success(response.data)
      }
      emit(responseResource)
    }

  override suspend fun getUserListData(): Flow<ResponseResource<ArrayList<DummyUserResponse>>> =
    flow {
      val responseResource = when (val response = remote.getUserList()) {
        is ResponseResource.Error -> ResponseResource.error(response.errorMessage)
        is ResponseResource.Success -> ResponseResource.success(response.data)
      }
      emit(responseResource)
    }
}