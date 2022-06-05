package com.riyaspullur.studentlistdiffutilsrecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riyaspullur.studentlistdiffutilsrecycler.databinding.CardListBinding

class CardAdapterMain(var list:List<User>):ListAdapter<User,MyViewHolder>(UserDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      var bindingD=CardListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(bindingD)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialize(list[position])

        holder.itemView.setOnClickListener {
            Log.d("ddddddd","ddddd")
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MyViewHolder (view:CardListBinding):RecyclerView.ViewHolder(view.root){

    var userId=view.idcardId
    var username = view.nameCardId
   var userPlace=view.placeCardId

    fun initialize(item: User){
       userId.text=item.id.toString()
        username.text=item.name
        userPlace.text=item.place


    }


}
interface OnUserItemClickListner{
    fun onItemClick(item: User, position: Int)
}

class UserDiffUtil: DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }


}
