package com.octo4a

import com.octo4a.octoprint.OctoPrintService
import com.octo4a.repository.BootstrapRepository
import com.octo4a.repository.BootstrapRepositoryImpl
import com.octo4a.repository.OctoPrintHandlerRepository
import com.octo4a.repository.OctoPrintHandlerRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<BootstrapRepository> { BootstrapRepositoryImpl() }

    scope<OctoPrintService> {
        scoped<OctoPrintHandlerRepository> { OctoPrintHandlerRepositoryImpl(androidContext(), get()) }
    }
}