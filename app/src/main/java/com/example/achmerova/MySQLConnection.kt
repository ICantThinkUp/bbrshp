package com.example.achmerova

import java.sql.*
import java.util.*

class MySQLConnection {
    companion object {
        private var conn : Connection? = null
    }

    fun startConnection() : Connection? {
        val connectionProps = Properties()
        //var conn: Connection? = null

        connectionProps.put("username", "arapovao_lrkfy")
        connectionProps.put("password", "GWMYkXYF6X")

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()

            /* MySQLConnection.conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "SSQL-12R2WEB02.client.parking.ru" +
                        "/" + "", "arapovao_lrkfy", "GWMYkXYF6X")

             */

            val driver = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "SSQL-12R2WEB02.client.parking.ru" +
                        "/" + "", "arapovao_lrkfy", "GWMYkXYF6X")

            println("CONNNNNNNNNNNNNNECTION DOOOOOOOOOOOOOOOOOOOOOOONE")

        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return MySQLConnection.conn

    }

    fun executeQuery(q: String) : ResultSet? {
        var stmnt : Statement? = null
        var resultset: ResultSet? = null
        val query: String = q

        try {
            stmnt = MySQLConnection.conn?.createStatement()
            resultset = stmnt?.executeQuery(query)
            print("RESULT SETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTt")
            print(stmnt?.resultSet)
/*

            if (stmnt?.execute(query)) {
                resultset = stmnt?.resultSet
            }

 */
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }

        return resultset
    }
}