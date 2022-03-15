package com.example.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.guess.databinding.FragmentGuessBinding


class GuessFragment : Fragment() {
    lateinit var binding : FragmentGuessBinding

    val viewModel by viewModels<GuessViewModel>()
    companion object {
        val TAG = GuessFragment::class.java.simpleName
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuessBinding.inflate(inflater)

//        val view = inflater.inflate(R.layout.fragment_test, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // super....通常是呼叫初始值
        super.onViewCreated(view, savedInstanceState)

        binding.bGuess.setOnClickListener {
            val num = binding.edNumber.text.toString().toInt()
            viewModel.guess(num)
        }
        viewModel.counter.observe(viewLifecycleOwner) {
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(viewLifecycleOwner) { state ->
            val message = when(state) {
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "START"
                else -> getString(R.string.sometine_wrong)
            }
            // 用 Alt+Enter 可以快速將字串萃取到 Xml檔
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { d, w ->
                    if (state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }
    }
}