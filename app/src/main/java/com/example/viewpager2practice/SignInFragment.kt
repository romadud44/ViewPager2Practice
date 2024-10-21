package com.example.viewpager2practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.viewpager2practice.databinding.FragmentSignInBinding
import com.example.viewpager2practice.databinding.FragmentSignUpBinding

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        val password = arguments?.getString("password")
        binding.loginSignUpBTN.setOnClickListener{
            if(name != binding.userNameSignInET.text.toString() ||
                password != binding.passwordSignInET.text.toString()) {
                Toast.makeText(context, "Введены неверно пароль или логин!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                fragmentManager?.beginTransaction()?.replace(R.id.containerID, MainFragment())?.commit()
            }
        }
    }
}