package com.example.achmerova

import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class DatabaseAdapter(private val windowName : String) : DatabaseInterface {

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun read() : Any {
        val databaseServer : URL = createURL("R", windowName)
        return getData(databaseServer)
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

fun getData(server : URL) : Any {
    thread {
        val serverConnection : HttpURLConnection =
                server.openConnection() as HttpURLConnection
        val rawData = receiveData(serverConnection)
        return@thread prepareData(rawData)
        // pattern bridge
    }
}

fun receiveData(connection: HttpURLConnection) : ArrayList<String> {
    var rawData : ArrayList<String> = ArrayList()

    with(connection) {
        requestMethod = "GET"
        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                rawData.add(line)
                println(line)
            }
        }
    }

    return rawData
}

fun prepareData(rawData : ArrayList<String>) : Any {
    return item_customer("1", "1", "1", "1")
}

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