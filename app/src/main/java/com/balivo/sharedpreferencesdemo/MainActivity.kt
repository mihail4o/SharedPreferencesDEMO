package com.balivo.sharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var age : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.edit1)
        age = findViewById(R.id.edit2)
    }

    override fun onResume() {
        super.onResume()
        val sh1 = getSharedPreferences("MyOwnShared", Context.MODE_PRIVATE)
        val str1 = sh1.getString("name", "")
        val int1 = sh1.getInt("age",0)

        name.setText(str1)
        age.setText(int1.toString())
    }

    override fun onPause() {
        super.onPause()

        val sh = getSharedPreferences("MyOwnShared", Context.MODE_PRIVATE)
        val myEdit = sh.edit()
        myEdit.putString("name", name.text.toString())
        myEdit.putInt("age", age.text.toString().toInt())
        myEdit.commit()
    }
}
