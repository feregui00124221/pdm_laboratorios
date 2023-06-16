package com.example.laboratorio11

import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.service.AuthService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var authService: AuthService

    @Before//Antes de cada prueba
    fun setup() {

        mockWebServer = MockWebServer()//Instancia de mockwebserver

        //Instancia de retrofit
        authService = Retrofit.Builder()//constructor de retrofit
            .baseUrl(mockWebServer.url("/"))//url base del servicio de pruebas
            .addConverterFactory(GsonConverterFactory.create())//conversor de json a objetos
            .build()//construir retrofit
            .create(AuthService::class.java)//crear instancia del servicio
    }

    @Test//Prueba unitaria
    fun loginTest() = runTest{
        val mockResponse = MockResponse()//Instancia de mockresponse
            .setResponseCode(200)//codigo de respuesta
            .setBody("""{"msg": "Login succesful", "token":"testToken"}""")//respuesta del servidor

        mockWebServer.enqueue(mockResponse)//encolar respuesta

        val response = authService.login(LoginRequest("admin", "admin"))//llamada al servicio

        mockWebServer.takeRequest()//tomar la peticion

        Assert.assertEquals("Login succesful", response.message)//verificar que la respuesta fue exitosa
        Assert.assertEquals("testToken", response.token)//verificar que el token es el correcto
    }

    @Test//Prueba unitaria
    fun unsuccesfulLogin() = runTest{
        val mockResponse = MockResponse()//Instancia de mockresponse
            .setBody("""{"msg": "Check credentials"}""")//respuesta del servidor

        mockWebServer.enqueue(mockResponse)//encolar respuesta

        val response = authService.login(LoginRequest("admin", "admin"))//llamada al servicio

        mockWebServer.takeRequest()//tomar la peticion

        Assert.assertEquals("Check credentials", response.message)//verificar que la respuesta fue fallida
    }

    @After//Despues de cada prueba
    fun tearDown(){
        mockWebServer.shutdown()//detener el servidor
    }
}