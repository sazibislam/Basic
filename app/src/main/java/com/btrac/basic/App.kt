package com.btrac.basic

import android.app.Application
import com.btrac.basic.di.appModule
import com.btrac.basic.di.cacheModule
import com.btrac.basic.di.networkModule
import com.btrac.basic.di.repositoryModule
import com.btrac.basic.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@App)
      modules(
        appModule,
        cacheModule,
        networkModule,
        repositoryModule,
        viewModelModule,
        // useCaseModule,
      )
    }
  }
}