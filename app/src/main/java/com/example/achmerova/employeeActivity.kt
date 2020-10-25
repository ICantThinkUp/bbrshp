package com.example.achmerova

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class employeeActivity : AppCompatActivity() {

    private val databaseAdapter : DatabaseInterface =
            DatabaseAdapter("employee")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
    }

    override fun onResume() {
        super.onResume()

        databaseAdapter.read()

    }
}