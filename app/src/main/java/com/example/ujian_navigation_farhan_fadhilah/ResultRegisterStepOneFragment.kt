package com.example.ujian_navigation_farhan_fadhilah

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentLoginBinding
import com.example.ujian_navigation_farhan_fadhilah.databinding.FragmentResultRegisterStepOneBinding

class ResultRegisterStepOneFragment : Fragment() {

    private var _binding: FragmentResultRegisterStepOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultRegisterStepOneBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            //menerima data bundle dari fragment registrasi tahap 1
            val dataName = arguments?.getString(RegisterStepOneFragment.EXTRA_NAME)
            val dataGraduateYear = arguments?.getInt(RegisterStepOneFragment.EXTRA_GRADUATE_YEAR)
            //menerima data bundle dari fragment registrasi tahap 2
            val dataAge = arguments?.getInt(RegisterStepTwoFragment.EXTRA_AGE)
            val dataSchoolName = arguments?.getString(RegisterStepTwoFragment.EXTRA_SCHOOL)
            val dataUniversity = arguments?.getString(RegisterStepTwoFragment.EXTRA_UNIVERSITY)
            val dataMajor = arguments?.getString(RegisterStepTwoFragment.EXTRA_MAJOR)

            tvName.text = "Nama : $dataName"
            tvGraduateYear.text = "Lulus tahun : $dataGraduateYear"

            //validasi bahwa data yang berasal dari registrasi 2 ada atau tidak, hal ini bertujuan untuk membedakan data yang masuk dari registrasi tahap 1 dan tahap 2
            if(dataSchoolName != null){
                if (dataAge != null){
                    //logic untuk mengklasifikasikan umur ganjil atau genap
                    if(dataAge % 2 == 0){
                        tvAge.text = "Usia anda genap"
                    }else{
                        tvAge.text = "Usia anda ganjil"
                    }
                }

                tvSchool.text = "Nama sekolah : $dataSchoolName"
                tvUniversity.text = "Universitas : $dataUniversity"
                tvMajor.text = "jurusan : $dataMajor"
            }else{
                //jika data null atau berasal dari registrasi tahap 1, maka textview yang tidak terpakai di hilangkan
                tvAge.visibility = View.GONE
                tvSchool.visibility = View.GONE
                tvUniversity.visibility = View.GONE
                tvMajor.visibility = View.GONE
            }

            btnNext.setOnClickListener{ view->
                //mengirim data dengan bundle
                val mBundle = Bundle()
                mBundle.putString(EXTRA_NAME, dataName)
                if (dataGraduateYear != null) {
                    mBundle.putInt(EXTRA_GRADUATE_YEAR, dataGraduateYear)
                }
                view.findNavController().navigate(R.id.action_resultRegisterStepOneFragment2_to_registerStepTwoFragment2, mBundle)


            }
        }
    }


    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_GRADUATE_YEAR = "extra_graduate_year"
    }

}