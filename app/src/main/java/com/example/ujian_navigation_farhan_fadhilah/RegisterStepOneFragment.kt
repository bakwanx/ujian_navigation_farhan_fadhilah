package com.example.ujian_navigation_farhan_fadhilah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentLoginBinding
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentRegisterStepOneBinding


class RegisterStepOneFragment : Fragment() {

    private var _binding: FragmentRegisterStepOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterStepOneBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnPreview.setOnClickListener {view->
                //validasi form bertujuan menghindari form kosong
                if(edtFullname.text.toString().isEmpty() || edtGraduateYear.text.toString().isEmpty()){
                    Toast.makeText(this@RegisterStepOneFragment.context,"Kolom nama atau umur tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }else{
                    //mengirim data inputan form dengan bundle
                    val mBundle = Bundle()
                    mBundle.putString(EXTRA_NAME, edtFullname.text.toString())
                    mBundle.putInt(EXTRA_GRADUATE_YEAR, Integer.parseInt(edtGraduateYear.text.toString()))
                    //berpindah fragment dengan membawa data bundle
                    view.findNavController().navigate(R.id.action_registerStepOneFragment_to_resultRegisterStepOneFragment2, mBundle)
                }
            }
        }
    }

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_GRADUATE_YEAR = "extra_graduate_year"
    }


}