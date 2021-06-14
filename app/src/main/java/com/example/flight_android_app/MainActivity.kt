package com.example.flight_android_app

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var ip: EditText? = null;
    var port :EditText? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ip = findViewById(R.id.textField);
        port = findViewById(R.id.IP);
    }

}