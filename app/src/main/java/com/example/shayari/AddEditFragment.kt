package com.example.shayari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shayari.databinding.FragmentAddEditBinding
import java.util.Date

class AddEditFragment : Fragment() {
    private var _binding:FragmentAddEditBinding?=null
    private val binding get() = _binding!!

    private lateinit var dataViewModal:DataViewModal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataViewModal= ViewModelProvider(this)[DataViewModal::class.java]



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding=FragmentAddEditBinding.inflate(inflater,container,false)


        //setup toolbar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            R.id.save -> {
              //  saveShayari()

                // Handle save button click
                // Perform your save logic here
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
//    private fun saveShayari() {
//        val shayariText = binding.ShayariInput.text.toString().trim()
//        if (shayariText.isNotEmpty()) {
//            val shayari = DataEntity(1,shayariText, Date())
//            context?.let { dataViewModal.insert(it,shayari) }
//            activity?.onBackPressed()
//        } else {
//            // Show a message if the EditText is empty
//            // For example, using a Toast
//            Toast.makeText(requireContext(), "Shayari cannot be empty", Toast.LENGTH_SHORT).show()
//        }
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }


}