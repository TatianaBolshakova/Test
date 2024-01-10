package com.example.mytestwork.data.repository

import com.example.mytestwork.data.storage.ListData
import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.repository.Repository

class RepositoryImpl: Repository {
    override fun getCompanyData(): List<CompanyData> {

        return ListData.listData

    }
}
