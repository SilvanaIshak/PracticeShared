package com.example.practiceshared

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var textView = findViewById<TextView>(R.id.textView)
        var txt = findViewById<EditText>(R.id.txt)
        var btnSave = findViewById<Button>(R.id.btnSave)
        var toggleButton = findViewById<ToggleButton>(R.id.toggleButton)

        //retrieve data
        var prefs = getSharedPreferences("temp", MODE_PRIVATE)
        textView.text = prefs.getString("name", "")
        toggleButton.isChecked = prefs.getBoolean("toggleButton", false)


        btnSave.setOnClickListener {
            //create preference
            var prefs = getSharedPreferences("temp", MODE_PRIVATE)
            var editor = prefs.edit()
            editor.putString("name", txt.text.toString())
            editor.putBoolean("toggleButton", toggleButton.isChecked)

            editor.apply()
            textView.text = txt.text
            Toast.makeText(this, "Saved ${textView.text} and ${toggleButton.isChecked}", Toast.LENGTH_LONG).show()
        }
    }
}
