package com.example.mytestwork.domain.repository

import com.example.mytestwork.domain.list.ListData
import com.example.mytestwork.domain.model.CompanyData
import javax.inject.Inject

class RepositoryImpl @Inject constructor(){
     fun getCompanyData(): List<CompanyData> {
        //в реальном приложении будет обращение к серверу через retrofit
        return ListData.listData

    }
}
