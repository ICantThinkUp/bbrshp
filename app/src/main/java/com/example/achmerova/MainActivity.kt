package com.example.achmerova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeNavButton = findViewById<Button>(R.id.employeeNavButton)
        val customersNavButton = findViewById<Button>(R.id.customersNavButton)
        val servicesNavButton = findViewById<Button>(R.id.servicesNavButton)
        val historyNavButton = findViewById<Button>(R.id.historyNavButton)

        val navButtons : Map<Button, Class<*>> = mapOf(
                employeeNavButton to employeeActivity::class.java,
                customersNavButton to CustomerActivity::class.java,
                servicesNavButton to ServiceActivity::class.java,
                historyNavButton to HistoryActivity::class.java
        )

        for ((button, activity) in navButtons) {
            bindListener(button, activity)
        }

    }

    private fun bindListener(button: Button, activity: Class<*>) {
        button.setOnClickListener {
            click(activity)
        }
    }

    private fun click(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}