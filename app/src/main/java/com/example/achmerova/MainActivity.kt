package com.example.achmerova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeNavButton = findViewById<Button>(R.id.employeeNavButton)
        val customersNavButton = findViewById<Button>(R.id.customersNavButton)
        val servicesNavButton = findViewById<Button>(R.id.servicesNavButton)
        val historyNavButton = findViewById<Button>(R.id.historyNavButton)

        employeeNavButton.setOnClickListener {
            pushEmployeeNavButton()
        }
    }

    private fun pushEmployeeNavButton() {
        var datalist: Array<String>

        val conn = MySQLConnection()
        conn.startConnection()
        val result : ResultSet? = conn.executeQuery("SELECT * FROM employee")
        print("MySQLConnection.conn!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11")
        print(result)
        //datalist

        val intent = Intent(this, employeeActivity::class.java)
        intent.putExtra("DATALIST", 1)

        startActivity(intent)
    }

}