package com.example.mytestwork.di

import com.example.mytestwork.presentation.viewmodel.MainViewModelFactory
import dagger.Component

@Component
interface AppComponent {
fun mainViewModelFactory(): MainViewModelFactory
}