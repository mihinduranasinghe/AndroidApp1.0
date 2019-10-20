package com.mihinduranasinghe.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        btnSubmit.setOnClickListener(){
            Log.i("MainActivity","Button Was Clicked");
            Toast.makeText(this,"Button was clicked", Toast.LENGTH_SHORT ).show();

        }
        */
        btnSubmit.setOnClickListener(){
            val userName: String = txtUserName.text.toString()

            //Navigating to second layout window activity
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("user_name",userName)//Passing the message
            startActivity(intent)

            /*
            * There are two types of intent
            * ---------------------------------
            * explicit intent - when you know the target of intent(what we learn)
            * implicit intent -  when you exactly don't know the intent
            */

/*
            btnShareToOtherApps.setOnClickListener{ //Share To Other Applications

                    val message: String=etUserMessage.text.toString()
                    val intent = Intent()
                    intent.action=Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type="text/plain"

                    startActivity(Intent.createChooser(intent, "Please select app: "))


            }

 */

            btnRecycle.setOnClickListener(){
                val intentcards = Intent(this,HobbiesActivity::class.java)
                startActivity(intentcards)
            }


        }






    }

}
