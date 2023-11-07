package com.example.roomdata_insert_update_delete

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdata_insert_update_delete.data.User
import com.example.roomdata_insert_update_delete.data.UserViewModel
import com.example.roomdata_insert_update_delete.databinding.FragmentInsertBinding

class InsertFragment : Fragment() {

    private lateinit var binding: FragmentInsertBinding
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInsertBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel ::class.java)
        binding.buttonSend.setOnClickListener {
            insertDataToDataBase()
        }
    }
    private fun insertDataToDataBase() {
        val name = binding.etName.text.toString()
        val mail = binding.etEmail.text.toString()
        val pass = binding.etPassword.text

        if (inputCheck(name, mail, pass)) {

            val user = User(0, name, mail, Integer.parseInt(pass.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Insert is Done , you are welcome", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_insertFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "please fill out of all field", Toast.LENGTH_SHORT)
                .show()
        }

    }
    private fun inputCheck(name: String, mail: String, pass: Editable?): Boolean {
            return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(mail) && pass!!.isEmpty())

    }

}
