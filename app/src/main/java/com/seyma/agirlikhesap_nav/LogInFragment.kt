package com.seyma.agirlikhesap_nav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentLogInBinding

@Suppress("UNREACHABLE_CODE")
class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentLogInBinding.inflate(inflater, container, false)


     binding.btnGiris.setOnClickListener {

    val intent = Intent(requireContext(), NotificationActivity::class.java)
    startActivity(intent)

}
        return binding.root
    }

}