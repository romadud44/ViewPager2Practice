package com.example.viewpager2practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.viewpager2practice.databinding.FragmentSignUpBinding
import kotlin.concurrent.fixedRateTimer


class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginSignUpBTN.setOnClickListener{
            val userNameSignUp = binding.userNameSignUpET.text.toString()
            val passwordSignUp = binding.passwordSignUpET.text.toString()
            if (passwordSignUp.isEmpty() || userNameSignUp.isEmpty()) {
                Toast.makeText(context, "Данные не введены", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val bundle = Bundle()
            val signInFragment = SignInFragment()
            bundle.putString("name", userNameSignUp)
            bundle.putString("password", passwordSignUp)
            signInFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.containerID, signInFragment)?.commit()
            Toast.makeText(context, "Регистрация прошла успешно!", Toast.LENGTH_LONG).show()
        }
    }



}