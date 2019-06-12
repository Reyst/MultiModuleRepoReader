package reyst.gsihome.research.repository.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource
import reyst.gsihome.research.repository.retrofit.Api
import reyst.gsihome.research.repository.retrofit.RetrofitDataSource
import javax.inject.Singleton

@Module
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(api: Api): reyst.gsihome.research.repository.core.RemoteGitHubDataSource = RetrofitDataSource(api)

}