package com.example.ujian_navigation_farhan_fadhilah

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val username = "farhan"
    private val password = "123"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener { view->
                //pengecekan apakah inputan sesuai dengan username dan pass
                if(edtUsername.text.toString().equals(username) && edtPasswordLogin.text.toString().equals(password)){
                    view.findNavController().navigate(R.id.action_loginFragment_to_registerStepOneFragment)
                }else{
                    Toast.makeText(context,"Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}