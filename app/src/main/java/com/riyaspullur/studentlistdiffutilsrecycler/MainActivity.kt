package com.riyaspullur.studentlistdiffutilsrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.riyaspullur.studentlistdiffutilsrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var datalist=ArrayList<User>()
        datalist.add(User(1,"Riyas","Pullur"))

        binding.recyclerRvId.layoutManager=LinearLayoutManager(this)
        binding.recyclerRvId.addItemDecoration(DividerItemDecoration(this,1))
        binding.recyclerRvId.adapter=CardAdapterMain(datalist)




        binding.addBtnId.setOnClickListener {
            if (binding.idinsertEditId.text.isNotEmpty() && binding.nameinsertEditId.text.isNotEmpty() && binding.placeinsertEditId.text.isNotEmpty()){

                datalist.add(User(binding.idinsertEditId.text.toString().toInt(),binding.nameinsertEditId.text.toString(),binding.placeinsertEditId.text.toString()))
                binding.idinsertEditId.text.clear()
                binding.nameinsertEditId.text.clear()
                binding.placeinsertEditId.text.clear()

                binding.recyclerRvId.adapter=CardAdapterMain(datalist)

                Toast.makeText(this,"Added...!!",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Enter data",Toast.LENGTH_SHORT).show()
            }
        }
    }
}