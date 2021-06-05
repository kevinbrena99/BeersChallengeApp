package com.brena.beerschallengeapp.presentation

import android.app.Application
import com.brena.beerschallengeapp.data.di.mapperDataModule
import com.brena.beerschallengeapp.data.di.networkModule
import com.brena.beerschallengeapp.data.di.repositoryModule
import com.brena.beerschallengeapp.domain.di.useCasesModule
import com.brena.beerschallengeapp.presentation.di.mapperPresentationModule
import com.brena.beerschallengeapp.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerCarouselApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BeerCarouselApplication)
            modules(
                arrayListOf(
                    mapperDataModule, repositoryModule,
                    useCasesModule, viewModelModule, networkModule, mapperPresentationModule
                )
            )
        }
    }
}