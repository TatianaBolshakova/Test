package com.example.mytestwork.domain.usecase


import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.repository.RepositoryImpl
import javax.inject.Inject

class GetCompanyDataUseCase @Inject constructor (val repository: RepositoryImpl) {
     fun getCompanyData(): List<CompanyData>{
        return repository.getCompanyData()}

}