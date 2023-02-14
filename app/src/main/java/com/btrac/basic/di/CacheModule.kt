package com.btrac.basic.di

import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.pref.PrefsImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Cache module
 * This DI module will be responsible of providing caching dependencies
 * which need to be live as long as app is living
 * @constructor Create empty Cache module
 */
val cacheModule = module {
  single<Prefs> { PrefsImpl(androidContext()) }
}