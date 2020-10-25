package com.example.achmerova

import java.net.URL

class DatabaseAdapter(private val windowName : String) : DatabaseInterface {

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun read() {
        val server : URL = createURL("R", windowName)
        // не знаю как назвать переменную с урлом
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

}

fun createURL(shortDatabaseMethod : String, windowName : String) : URL {
    return URL("http://vho_arapovao_117967.vh.parking.ru/" +
            "?api=$shortDatabaseMethod&window=$windowName")
}

fun

/*
class DatabaseAdapter(serverAPI: String, parametersForSQLQuery: String = "") {
    val server : URL = URL("http://vho_arapovao_117967.vh.parking.ru/"
            + serverAPI)
    val postData : ByteArray = parametersForSQLQuery.toByteArray(UTF_8)
    val sizeOfData = postData.size.toString()

    init {
        thread {


            with(fullwindowName.openConnection() as HttpURLConnection) {
                requestMethod = "POST"
                doOutput = true
                setRequestProperty("charset", "utf-8")
                setRequestProperty("Content-lenght", sizeOfData)

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
 */