package app.delivery.di.module

import android.app.Application
import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import app.delivery.model.ThreadModel
import app.delivery.utils.NetworkConnectionUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * provides application level instances
 */
@Module
class AppModule(val application: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.baseContext
    }

    @Provides
    @Singleton
    fun provideExecutorService(): ThreadModel {
        return ThreadModel()
    }

    @Provides
    @Singleton
    fun provideHandler(): Handler {
        return Handler()
    }

    @Provides
    @Singleton
    fun provideAppUtils(): NetworkConnectionUtil {
        return NetworkConnectionUtil()
    }

    @Provides
    @Singleton
    fun provideLayoutInflater(context: Context): LayoutInflater = LayoutInflater.from(context)
}