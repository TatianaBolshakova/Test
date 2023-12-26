package com.example.mytestwork.presentation.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.usecase.GetCompanyDataUseCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel  @Inject constructor(

private val getCompanyDataUseCase: GetCompanyDataUseCase
): ViewModel(){

    private val _companyData = MutableStateFlow <List<CompanyData>>(emptyList())
    val companyData = _companyData.asStateFlow()

    fun loadCompanyData() {
        viewModelScope.launch(Dispatchers.IO){
            kotlin.runCatching {
                getCompanyDataUseCase.getCompanyData()
            }.fold(
                onSuccess = {
                    _companyData.value = it
                },
                onFailure = { Log.d("DepartmentSelectionViewModel", it.message ?: "")}
            )
        }
    }

}