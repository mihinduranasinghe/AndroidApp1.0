package com.mihinduranasinghe.myfirstapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mihinduranasinghe.myfirstapplication.models.Hobby
import com.mihinduranasinghe.myfirstapplication.R
import com.mihinduranasinghe.myfirstapplication.activities.MainActivity
import com.mihinduranasinghe.myfirstapplication.showToast
import kotlinx.android.synthetic.main.recycler_item.view.*


class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object{
        val TAG: String = HobbiesAdapter::class.java.simpleName //when you write any Log statement we can use TAG

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null;
        var currentPosition: Int = 0;


        init {
            itemView.setOnClickListener {
              //  Toast.makeText(context, currentHobby!!.title + " clicked !", Toast.LENGTH_SHORT).show()
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " clicked !" )
                    // itemName clicked will be display once you click an item
                }
            }

              currentHobby?.let { //Avoiding null pointer exception

                     itemView.imgShare.setOnClickListener {
                      //Share the card to other APPLICATIONS
                      val message: String = "My Hobby Is: " + currentHobby!!.title
                      val intent = Intent()
                      intent.action = Intent.ACTION_SEND
                      intent.putExtra(Intent.EXTRA_TEXT, message)
                      intent.type = "text/plain"

                      context.startActivity(Intent.createChooser(intent, "Please select app: "))
                     }
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby!!.title

                this.currentHobby = hobby
                this.currentPosition = pos


            }

        }

    }
}