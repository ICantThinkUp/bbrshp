package com.example.achmerova

import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets.UTF_8
import kotlin.concurrent.thread


class HTTPConnection {

    fun createPOST(query : String) {
        val url : URL = URL("http://vho_arapovao_117967.vh.parking.ru/?window=employee")
        thread {

            val postData : ByteArray = query.toByteArray(UTF_8)
            val sizeOfData = postData.size.toString()

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "POST"
                doOutput = true
                setRequestProperty("charset", "utf-8")
                setRequestProperty("Content-lenght", postData.size.toString())

                outputStream.buffered().use {
                    it.write(postData)
                    it.flush()
                }

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        println(line)
                    }
                }
            }
        }

    }

}