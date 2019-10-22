package com.mihinduranasinghe.myfirstapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mihinduranasinghe.myfirstapplication.Constants
import com.mihinduranasinghe.myfirstapplication.R
import com.mihinduranasinghe.myfirstapplication.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG: String = SecondActivity::class.java.simpleName//when you write any Log statement we can use TAG

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //self call ?. (null pointer safety)
        //safe call with let?.let{}
        val bundle: Bundle? = intent.extras //Recieving user name from mainactivity

        bundle?.let{
            val usName = bundle.getString(Constants.USER_MSG_KEY)
            //Toast.makeText(this, usName, Toast.LENGTH_SHORT).show()
            showToast(usName)
            txtUserNameDisplay.text = usName;
        }

        /*
             val usName = bundle!!.getString("user_name")
            //Toast.makeText(this, usName, Toast.LENGTH_SHORT).show()
            showToast(usName)
            txtUserNameDisplay.text = usName;
         */


    }
}