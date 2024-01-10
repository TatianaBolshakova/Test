package com.example.mytestwork.domain.repository

import com.example.mytestwork.domain.model.CompanyData

interface Repository {
    fun getCompanyData(): List<CompanyData>
}