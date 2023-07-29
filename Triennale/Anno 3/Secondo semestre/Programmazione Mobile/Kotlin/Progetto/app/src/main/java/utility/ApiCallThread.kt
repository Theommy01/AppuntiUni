package utility

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class ApiCallThread {
    fun main(url: String): String {
        // scope della coroutine
        val scope = CoroutineScope(Dispatchers.Default)

        // definisco i dati in input
        val urlInput = url

        // definisco la coroutine
        val apiCallCoroutine = scope.async {
            // compongo la richiesta API
            val client = OkHttpClient()
            val request = Request.Builder().url(urlInput).build()

            // eseguo la chiamata API
            Log.i("SkiTracker API Call", "URL richiesta API: $urlInput")
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    return@async response.body!!.string()
                } else {
                    throw ApiCallException(response.code)
                }
            }
        }

        // mi metto in attesa della fine della coroutine
        val apiCallResult = runBlocking {
            apiCallCoroutine.await()
        }

        // ritorno il risultato
        return apiCallResult
    }

    fun callWithXmlArgument(xmlContent: String, url: String): String {
        // scope della coroutine
        val scope = CoroutineScope(Dispatchers.Default)

        // definisco la coroutine
        val apiCallCoroutine = scope.async {
            // corpo della richiesta
            val mediaType = "text/xml".toMediaTypeOrNull()
            val requestBody = xmlContent.toRequestBody(mediaType)

            // compongo la richiesta API
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("content-type", "text/xml")
                .build()

            // eseguo la chiamata API
            Log.i("SkiTracker API Call w/XML", "URL richiesta API: $url")
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    return@async response.body!!.string()
                } else {
                    throw ApiCallException(response.code)
                }
            }
        }

        // mi metto in attesa della fine della coroutine
        val apiCallResult = runBlocking {
            apiCallCoroutine.await()
        }

        // ritorno il risultato
        return apiCallResult
    }
}