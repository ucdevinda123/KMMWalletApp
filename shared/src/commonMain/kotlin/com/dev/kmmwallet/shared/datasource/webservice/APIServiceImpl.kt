package com.dev.kmmwallet.shared.datasource.webservice

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.GetUserResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class APIServiceImpl : APIService {

    // val MAIN_URL = "http://192.168.0.166:4001"
    val MAIN_URL = "https://rocky-sea-95452.herokuapp.com"

    val client = HttpClient {
        install(JsonFeature) {
            serializer =
                KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })
        }

        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value
                when (statusCode) {
                    in 300..399 -> throw RedirectResponseException(response)
                    in 400..499 -> throw ClientRequestException(response)
                    in 500..599 -> throw ServerResponseException(response)
                }
            }
        }
    }

    override suspend fun authenticateUser(user: User): AuthResponse {
        val authEndpoint = "$MAIN_URL/users/authenticate"
        return client.post(authEndpoint) {
            header("Content-Type", "application/json")
            body = user
        }
    }

    override suspend fun signUpUser(user: UserRegistration): UserRegistrationResponse {
        val authEndpoint = "$MAIN_URL/users/register"
        return client.post(authEndpoint) {
            header("Content-Type", "application/json")
            body = user
        }
    }

    //Demonstration purpose only never use ID :)
    override suspend fun getUserById(id: String, token: String): GetUserResponse {
        return client.get {
            url("$MAIN_URL/users/$id")
            header("Authorization", "Bearer $token")
        }
    }

    //Demonstration purpose only never use ID :)
    override suspend fun updateUserProfile(
        id: String,
        token: String,
        userProfile: UserProfile
    ): BaseResponse {
        return client.put {
            url("$MAIN_URL/users/$id")
            header("Content-Type", "application/json")
            header("Authorization", "Bearer $token")
            body = userProfile
        }
    }
}