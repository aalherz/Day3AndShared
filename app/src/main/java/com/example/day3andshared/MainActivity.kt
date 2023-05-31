package com.example.day3andshared

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
   lateinit var nameEt:EditText;
   lateinit var ageEt:EditText;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEt = findViewById(R.id.nameET)
        ageEt = findViewById(R.id.ageEt)
    }

    override fun onPause() {
        super.onPause()
        var sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString("name", nameEt.text.toString().trim())
        editor.putString("age", ageEt.text.toString().trim())
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        var sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        nameEt.setText(sharedPreferences.getString("name","not found"))
        ageEt.setText(sharedPreferences.getString("age","not found"))
    }
}