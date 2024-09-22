package ru.mirea.prac2.ui.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.mirea.prac2.R
import ru.mirea.prac2.data.model.Counter
import ru.mirea.prac2.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val view = binding.root

        counterViewModel = ViewModelProvider(requireActivity()).get(CounterViewModel::class.java)

        // Подписываемся на изменения в данных
        counterViewModel.counter.observe(viewLifecycleOwner, Observer { counter ->
            updateUI(counter)
        })
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(counter: Counter)
    {
        binding.TvCounter.setText(counter.getCount().toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextFragmentWithTransition.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, FirstFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.nextFragmentWithNavigationApi.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        binding.btMultiplyByTwo.setOnClickListener {
            counterViewModel.multiplyByTwo()
        }
    }
}