package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.Room.User

class RecyclerViewAdapter(private val employeeList: List<User>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_adapter,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.firstName.text = employeeList[position].firstName
        holder.lastName.text = employeeList[position].lastName
        holder.phoneNumber.text = employeeList[position].phoneNumber.toString()
    }


    override fun getItemCount(): Int {
        return employeeList.count()
    }

    class RecyclerViewHolder(itemView : View) : ViewHolder(itemView){
        val firstName : TextView = itemView.findViewById(R.id.firstNameRV)
        val lastName : TextView = itemView.findViewById(R.id.lastNameRV)
        val phoneNumber : TextView = itemView.findViewById(R.id.phoneNoRV)

    }




}
