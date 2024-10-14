package com.pardess.directions.data.di

import com.pardess.directions.data.repository.AppContextRepositoryImpl
import com.pardess.directions.data.repository.KakaoApiRepositoryImpl
import com.pardess.directions.domain.repository.AppContextRepository
import com.pardess.directions.domain.repository.KakaoApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    // KakaoApiRepository 의존성 주입 (KakaoApiRepositoryImpl)
    @Binds
    @Singleton
    abstract fun provideKakaoApiRepository(
        kakaoApiRepositoryImpl: KakaoApiRepositoryImpl,
    ): KakaoApiRepository

    // AppContextRepository 의존성 주입 (AppContextRepositoryImpl)
    @Binds
    @Singleton
    abstract fun provideAppContextRepository(
        appContextRepository: AppContextRepositoryImpl
    ): AppContextRepository
}