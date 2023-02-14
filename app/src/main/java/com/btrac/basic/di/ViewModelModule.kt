package com.btrac.basic.di

import com.btrac.basic.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { HomeViewModel(get(), get()) }
}