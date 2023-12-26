package com.example.mytestwork.domain.list

import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.model.FirstItem
import com.example.mytestwork.domain.model.SecondItem


object ListData {
       var listData = listOf(
            CompanyData(
                title = "Рудник скалистый",
                items = mutableListOf(
                    FirstItem(
                        title = "ПУБР",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 1 этажа"
                            )
                        )
                    ),
                    FirstItem(
                        title = "ПУБР 1",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 2 этажа"
                            )
                        )
                    ),
                    FirstItem(
                        title = "ПУБР 2",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 3 этажа"
                            )
                        )
                    )
                )
            ),

            CompanyData(
                title = "Рудник скалистый 2",
                items = mutableListOf(
                    FirstItem(
                        title = "ПУБР 3",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 4 этажа"
                            )
                        )
                    ),
                    FirstItem(
                        title = "ПУБР 4",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 5 этажа"
                            )
                        )
                    )
                )
            ),

            CompanyData(
                title = "Рудник скалистый 3",
                items = mutableListOf(
                    FirstItem(
                        title = "ПУБР 5",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 6 этажа"
                            )
                        )
                    ),
                    FirstItem(
                        title = "ПУБР 6",
                        items = mutableListOf(
                            SecondItem(
                                title = "Очистная камера 7 этажа"
                            ),
                        )
                    )
                )
            )
        )
    }
