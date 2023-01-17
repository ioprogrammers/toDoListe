package com.sebastian.sliwinski.todoapp.ui.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sebastian.sliwinski.todoapp.databinding.FragmentTodolistBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class ToDoListFragment : Fragment() {

    private var _binding: FragmentTodolistBinding? = null
    private val binding: FragmentTodolistBinding
        get() = _binding!!
    private val viewModel: ToDoListViewModel by viewModels()
    private val adapter: ToDoListAdapter by lazy {
        ToDoListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodolistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter

        binding.addNewBtn.setOnClickListener {
            viewModel.addNewPressed()
        }
        lifecycleScope.launch {
            viewModel.nav.collect {
                findNavController().navigate(it)
            }
        }
        viewModel.items.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}