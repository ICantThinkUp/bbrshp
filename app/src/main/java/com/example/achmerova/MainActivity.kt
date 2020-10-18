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


        employeeNavButton.setOnClickListener {
            var resultOfGet : String


//            val con = HTTPConnection().createPOST("BUDDY YOU COOL!!!!!!")
//
//            val intent : Intent = Intent(this, employeeActivity::class.java).apply {
//                putExtra("DATASET_EMPLOYEE", resultOfGet)
//            }
//            startActivity(intent)



            pushEmployeeNavButton(employeeActivity::class.java)

            // обратиться к бд в инициализации активити
        }
    }

    private fun pushEmployeeNavButton(activity: Class<*>) {


        val intent = Intent(this, activity)

        startActivity(intent)
    }

}