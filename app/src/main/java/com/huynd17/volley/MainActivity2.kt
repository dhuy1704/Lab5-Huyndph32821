package com.huynd17.volley

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnGet = findViewById<Button>(R.id.btnGetData);
        var tvKQ = findViewById<TextView>(R.id.tvKQ);
        var fn1 = VolleyFn1();
        btnGet!!.setOnClickListener {
            fn1.getAllData(context, tvKQ!!)
        }
    }
}