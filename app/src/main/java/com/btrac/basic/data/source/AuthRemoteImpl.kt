package com.btrac.basic.data.source

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class AuthRemoteImpl(private val client: HttpClient) : AuthRemote {

/*    override suspend fun signup(request: SignupRequestDto): ResponseResource<SignupResponseDto> =
        try {
            val response = client.post(ENDPOINT_SIGNUP) {
                setBody(request)
            }.body<SignupResponseDto>()
            when (response.data) {
                null -> ResponseResource.error(response)
                else -> ResponseResource.success(response)
            }
        } catch (e: Exception) {
            ResponseResource.error(
                SignupResponseDto
                    (error = SignupResponseDto.Error("Oops, something bad happened :("))
            )
        }

    override suspend fun login(request: LoginRequestDto): ResponseResource<LoginResponseDto> = try {
        val response = client.post(ENDPOINT_LOGIN) { setBody(request) }.body<LoginResponseDto>()
        when (response.data) {
            null -> ResponseResource.error(response)
            else -> ResponseResource.success(response)
        }
    } catch (e: Exception) {
        ResponseResource.error(
            LoginResponseDto
                (error = LoginResponseDto.Error("Oops, something bad happened :("))
        )
    }*/
}