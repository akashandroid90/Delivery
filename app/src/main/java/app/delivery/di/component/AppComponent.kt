package app.delivery.di.component

import app.delivery.MyApplication
import app.delivery.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 *  initialize modules used for Dagger to provide instance to application
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, DbModule::class, NetworkModule::class,
        ActivityModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(app: MyApplication)
}