package com.example.shayari

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayari.databinding.ActivityMainBinding
import com.example.shayari.databinding.DialogBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

  //  private var shayariList=ArrayList<DataEntity>()

    private var dataViewModal: DataViewModal? = null
    private var adapter: RvAdapter = RvAdapter(this, mutableListOf())













    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataViewModal= ViewModelProvider(this)[DataViewModal::class.java]
        dataViewModal?.getAllShayari(this)?.observe(this){

            adapter.addShayari(it as List<DataEntity>)
        }

       // shayariList.addAll(obj.data)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter







        binding.fab.setOnClickListener {

            //on clicking dialog box will open

            openDialogBox()


            //when we have to load fragment and want to write the shayari there
//            binding.clL.visibility= View.GONE
//
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.frame_container, AddEditFragment())
//            fragmentTransaction.commit()
        }
    }
    private fun openDialogBox(){
        val dialogBinding = DialogBinding.inflate(LayoutInflater.from(this))
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogBinding.root)


        val alertDialog = dialogBuilder.create()
        alertDialog.show()



        dialogBinding.buttonSubmit.setOnClickListener {
            val shayariText = dialogBinding.editText.text.toString().trim()
            if (shayariText.isNotEmpty()) {
                val shayari = DataEntity(shayari = shayariText)
                dataViewModal?.insert(this,shayari)
                alertDialog.dismiss()
            }



        }

    }




}