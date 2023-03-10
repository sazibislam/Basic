package com.btrac.basic.di

import com.btrac.basic.data.remote.source.AuthRemote
import com.btrac.basic.data.remote.source.AuthRemoteImpl
import com.btrac.basic.data.remote.source.HomeRemoteImpl
import com.btrac.basic.data.remote.source.HomeRemote
import org.koin.dsl.module

/**
 * Network module
 * This DI module will be responsible of providing network dependencies
 * which need to be live as long as app is living
 * @constructor Create empty Network module
 */
val networkModule = module {
  single<AuthRemote> { AuthRemoteImpl(get()) }
  single<HomeRemote> { HomeRemoteImpl(get()) }
}