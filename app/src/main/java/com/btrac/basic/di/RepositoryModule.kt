package com.btrac.basic.di

import com.btrac.basic.data.repositoryImpl.AuthRepositoryImpl
import com.btrac.basic.data.repositoryImpl.HomeRepositoryImpl
import com.btrac.basic.domain.repository.AuthRepository
import com.btrac.basic.domain.repository.HomeRepository
import org.koin.dsl.module

/**
 * Repositories module
 * This DI module will be responsible of providing repositories dependencies
 * which need to be live as long as app is living
 * @constructor Create empty Repositories module
 */
val repositoryModule = module {
  single<AuthRepository> { AuthRepositoryImpl(get()) }
  single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}