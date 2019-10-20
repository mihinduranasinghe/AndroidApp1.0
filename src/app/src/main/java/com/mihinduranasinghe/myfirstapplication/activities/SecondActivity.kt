package com.mihinduranasinghe.myfirstapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mihinduranasinghe.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras //Recieving user name from mainactivity
        val usName = bundle!!.getString("user_name")
        Toast.makeText(this, usName, Toast.LENGTH_SHORT).show()
        txtUserNameDisplay.text = usName;


    }
}