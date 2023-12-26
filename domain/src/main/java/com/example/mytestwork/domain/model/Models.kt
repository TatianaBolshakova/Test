package com.example.mytestwork.domain.model


private const val COMPANY = 0
private const val ROOM = 1
private const val SITE = 2

data class CompanyData(
    val title: String? = null,
    var items: List<FirstItem> = ArrayList(),
    var type:Int = COMPANY,
    var isExpanded:Boolean = false

)
data class FirstItem(
    val title: String? = null,
    var items: List<SecondItem> = ArrayList(),
    var type:Int = ROOM,
    var isExpanded:Boolean = false
)
data class SecondItem(
    val title: String? = null,
    var type:Int = SITE
)
