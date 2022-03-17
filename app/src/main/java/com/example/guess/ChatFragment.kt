package com.example.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.guess.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    companion object {
        val TAG = ChatFragment::class.java.simpleName
    }
    lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLeave.setOnClickListener {
            val parentActivity = requireActivity() as MainActivity
            parentActivity.supportFragmentManager.beginTransaction().run {
                replace(R.id.main_container, parentActivity.mainFragments[0]).commit()
            }
            parentActivity.supportFragmentManager.beginTransaction().run {
                replace(R.id.chat_container, parentActivity.chatFragments[0]).commit()
            }
//            findNavController().navigate(R.id.action_chat_to_guess)
        }

    }
}