package com.mihinduranasinghe.myfirstapplication

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.showToast(message:String, duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
    // we can call show toast from anywarr within the activity using this extension
    //but this cannot be called by adapter class because it is not an object so that we need to change this as context.showToast because context is the super class of activty and also we can use context object.showToast in adapter class ass well
}