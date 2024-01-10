package com.example.mytestwork.domain.usecase


import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.repository.Repository
import javax.inject.Inject

class GetCompanyDataUseCase @Inject constructor (val repository: Repository) {
     fun getCompanyData(): List<CompanyData>{
        return repository.getCompanyData()}

}