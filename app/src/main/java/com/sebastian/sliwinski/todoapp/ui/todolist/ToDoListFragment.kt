package com.sebastian.sliwinski.todoapp.ui.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sebastian.sliwinski.todoapp.databinding.FragmentTodolistBinding

class ToDoListFragment : Fragment() {

    private var _binding: FragmentTodolistBinding? = null
    private val binding: FragmentTodolistBinding
        get() = _binding!!
    private val viewModel: ToDoListViewModel by viewModels()

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
        binding.addNewBtn.setOnClickListener {
            viewModel.addNewPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}