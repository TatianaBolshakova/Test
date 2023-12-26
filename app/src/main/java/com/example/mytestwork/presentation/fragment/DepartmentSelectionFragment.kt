package com.example.mytestwork.presentation.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mytestwork.R
import com.example.mytestwork.adapter.CompanyDataAdapter
import com.example.mytestwork.data.constant.Constants
import com.example.mytestwork.data.shared.Shared
import com.example.mytestwork.databinding.FragmentDepartmentSelectionBinding
import com.example.mytestwork.di.DaggerAppComponent
import com.example.mytestwork.domain.model.SecondItem
import com.example.mytestwork.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class DepartmentSelectionFragment : Fragment() {

    private var _binding: FragmentDepartmentSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels {
        DaggerAppComponent.create().mainViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDepartmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        Shared.sitePref= this.activity?.getSharedPreferences(Constants.NAME_SITE_PREF, Context.MODE_PRIVATE)
    }

    private fun setRecyclerView() {
        viewModel.loadCompanyData()
        val companyAdapter = CompanyDataAdapter {item-> onItemClick(item)}
                binding.recyclerSite.adapter = companyAdapter
        viewModel.companyData.onEach { companyAdapter.setData(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)


    }

    private fun onItemClick(item: SecondItem) {
        Shared.saveSite(item.title.toString())
        findNavController().navigate(R.id.CreatingDowntimeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
