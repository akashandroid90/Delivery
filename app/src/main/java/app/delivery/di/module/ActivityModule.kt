package app.delivery.di.module

import app.delivery.ui.detail.DetailActivity
import app.delivery.ui.list.ListActivity
import app.delivery.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * provides builder methods for Dagger
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeListActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity
}