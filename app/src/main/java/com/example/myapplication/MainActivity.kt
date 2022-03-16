package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager!!.
        beginTransaction().
        add(R.id.fragment_container_view,menu(),"menu").commit()

        val ScannerBtn = findViewById(R.id.ScannerBtn) as Button
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {} // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {
                val buttoncolor : Int = Color.parseColor("#5b5b5b")
                val textcolor : Int = Color.parseColor("#FFFFFF")
                ScannerBtn.setBackgroundColor(buttoncolor)
                ScannerBtn.setTextColor(textcolor)
//                ScannerBtn.setIconTintResource
            } // Night mode is active, we're using dark theme
        }

        ScannerBtn.setOnClickListener {
            val intent = Intent(this, qrcodescan::class.java)
            startActivity(intent)
        }
    }
    companion object {
        private const val CAMERA_REQ = 101
    }
}