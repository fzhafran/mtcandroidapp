package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager!!.
        beginTransaction().
        add(R.id.fragment_container_view,menu(),"menu").commit()

        val ScannerBtn = findViewById(R.id.ScannerBtn) as Button

        ScannerBtn.setOnClickListener {
            val intent = Intent(this, qrcodescan::class.java)
            startActivity(intent)
        }
    }
    companion object {
        private const val CAMERA_REQ = 101
    }
}