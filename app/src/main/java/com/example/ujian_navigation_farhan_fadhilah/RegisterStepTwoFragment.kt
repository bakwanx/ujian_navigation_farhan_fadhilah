package com.example.ujian_navigation_farhan_fadhilah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentRegisterStepTwoBinding

class RegisterStepTwoFragment : Fragment() {

    private var _binding: FragmentRegisterStepTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterStepTwoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnPreview.setOnClickListener {
                //menerima data bundle dari fragment result
                val dataName = arguments?.getString(ResultRegisterStepOneFragment.EXTRA_NAME)
                val graduateYears = arguments?.getInt(ResultRegisterStepOneFragment.EXTRA_GRADUATE_YEAR)
                var dataAge = edtAge.text.toString()
                var school = edtSchool.text.toString()
                var university = edtUniversity.text.toString()
                var major = edtMajor.text.toString()

                //validasi form bertujuan menghindari form kosong
                if(dataAge.isEmpty() || school.isEmpty() || university.isEmpty() || major.isEmpty()){
                    Toast.makeText(this@RegisterStepTwoFragment.context,"Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }else{
                    //mengirim data inputan form dengan bundle
                    val mBundle = Bundle()
                    mBundle.putString(EXTRA_NAME, dataName)
                    if (graduateYears != null) {
                        mBundle.putInt(EXTRA_GRADUATE_YEAR, graduateYears)
                    }
                    mBundle.putInt(EXTRA_AGE, Integer.parseInt(edtAge.text.toString()))
                    mBundle.putString(EXTRA_SCHOOL, school)
                    mBundle.putString(EXTRA_UNIVERSITY, university)
                    mBundle.putString(EXTRA_MAJOR, major)
                    //berpindah fragment dengan membawa data bundle
                    view.findNavController().navigate(R.id.action_registerStepTwoFragment2_to_resultRegisterStepOneFragment2, mBundle)
                }
            }

        }
    }

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_AGE = "extra_age"
        val EXTRA_GRADUATE_YEAR = "extra_graduate_year"
        val EXTRA_SCHOOL = "extra_school"
        val EXTRA_UNIVERSITY = "extra_university"
        val EXTRA_MAJOR = "extra_major"
    }


}