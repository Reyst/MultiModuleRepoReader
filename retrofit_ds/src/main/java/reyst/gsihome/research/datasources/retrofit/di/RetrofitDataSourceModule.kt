package reyst.gsihome.research.datasources.retrofit.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import reyst.gsihome.research.datasources.retrofit.Api
import reyst.gsihome.research.datasources.retrofit.RetrofitDataSource
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource
import javax.inject.Singleton

@Module
class RetrofitDataSourceModule {

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
    fun provideRemoteDataSource(api: Api): RemoteGitHubDataSource = RetrofitDataSource(api)

}