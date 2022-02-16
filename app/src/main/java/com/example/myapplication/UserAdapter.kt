package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var binding: ItemUserBinding
    private val listContainer = mutableListOf<User>()


    inner class ViewHolder(binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       binding = ItemUserBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = listContainer[position]
        binding.apply {
            tvUser.text = user.name
            tvEmail.text = user.email
        }
    }

    override fun getItemCount(): Int {
        return listContainer.size
    }
    fun populateData (Users: List<User>) {
        listContainer.clear()
        listContainer.addAll(Users)
        notifyDataSetChanged()
    }
}