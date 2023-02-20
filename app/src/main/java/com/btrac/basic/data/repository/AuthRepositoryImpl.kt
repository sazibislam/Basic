package com.btrac.basic.data.repository

import com.btrac.basic.data.remote.source.AuthRemote
import com.btrac.basic.domain.repository.AuthRepository

class AuthRepositoryImpl(private val remote: AuthRemote) : AuthRepository {

  // override suspend fun signup(requestDto: SignupRequestDto): Flow<ResponseResource<SignupResponseDto>> =
  //     flow {
  //         when (val response = remote.signup(requestDto)) {
  //             is ResponseResource.Error -> emit(ResponseResource.error(response.errorMessage))
  //             is ResponseResource.Success -> emit(ResponseResource.success(response.data))
  //         }
  //     }

  // override suspend fun login(request: LoginRequestDto): Flow<ResponseResource<LoginResponseDto>> =
  //     flow {
  //         when (val response = remote.login(request)) {
  //             is ResponseResource.Error -> emit(ResponseResource.error(response.errorMessage))
  //             is ResponseResource.Success -> emit(ResponseResource.success(response.data))
  //         }
  //     }

}