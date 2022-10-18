package com.example.practiceshared

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.textView)
        val txt = findViewById<EditText>(R.id.txt)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)

        //retrieve data
        val prefs = getSharedPreferences("temp", MODE_PRIVATE)
        textView.text = prefs.getString("name", "")
        toggleButton.isChecked = prefs.getBoolean("toggleButton", false)


        btnSave.setOnClickListener {
            //create preference
            val prefs = getSharedPreferences("temp", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("name", txt.text.toString())
            editor.putBoolean("toggleButton", toggleButton.isChecked)

            editor.apply()
            textView.text = txt.text
            Toast.makeText(this, "Saved ${textView.text} and ${toggleButton.isChecked}", Toast.LENGTH_LONG).show()
        }
    }
}
