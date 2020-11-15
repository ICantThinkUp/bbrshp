package com.example.achmerova

import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class DatabaseAdapter(private val windowName : String) : DatabaseInterface {

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun read() : Any {
        val sourceOfRecords : URL = createURL("R", windowName)
        return getRecords(sourceOfRecords)
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    private fun createURL(shortDatabaseMethod : String, windowName : String) : URL {
        return URL("http://vho_arapovao_117967.vh.parking.ru/" +
                "?api=$shortDatabaseMethod&window=$windowName")
    }

    private fun getRecords(source: URL) {
        thread {
            val connectionToRecordsSource : HttpURLConnection =
                    source.openConnection() as HttpURLConnection

            val rawRecords = getRawRecords(connectionToRecordsSource)
            val preparedData = getPreparedRecords(rawRecords)

            
            // pattern bridge
        }
    }

    private fun getRawRecords(connectionToRecordsSource: HttpURLConnection) : ArrayList<String> {
        var rawRecords : ArrayList<String> = ArrayList()

        with(connectionToRecordsSource) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    rawRecords.add(line)
                }
            }
        }

        return rawRecords
    }

    private fun getPreparedRecords(rawRecords : ArrayList<String>) : ArrayList<Any> {
        var preparedData : ArrayList<Any> = ArrayList()

        for (i in rawRecords) {
            println("PREPARED ITEM")
            println(i)
        }

        return preparedData;
    }
}

/*
class DatabaseAdapter(sourceAPI: String, parametersForSQLQuery: String = "") {
    val source
    : URL = URL("http://vho_arapovao_117967.vh.parking.ru/"
            + source
           API)
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