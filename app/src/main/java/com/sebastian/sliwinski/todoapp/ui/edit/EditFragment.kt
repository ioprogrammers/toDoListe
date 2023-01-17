package com.sebastian.sliwinski.todoapp.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs


import com.sebastian.sliwinski.todoapp.databinding.FragmentEditBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {

    private var _binding: FragmentEditBinding? = null
    private val binding: FragmentEditBinding
        get() = _binding!!

    private val viewModel: EditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            viewModel.saveButtonPressed(binding.editEt.text.toString())
        }
        val args : EditFragmentArgs by navArgs()
        val id = args.id
        viewModel.setId(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}