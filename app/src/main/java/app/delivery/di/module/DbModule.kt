package app.delivery.di.module

import android.content.Context
import androidx.room.Room
import app.delivery.db.AppDataBase
import app.delivery.db.dao.DeliveriesDao
import app.delivery.model.ThreadModel
import app.delivery.repository.database.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * provides instances of objects used for performing database operations
 */
@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "app_database.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDeliveriesDao(database: AppDataBase): DeliveriesDao {
        return database.deliveriesDao()
    }

    @Provides
    @Singleton
    fun provideAppRepository(
        thread: ThreadModel,
        deliveriesDao: DeliveriesDao
    ): DbRepository {
        return DbRepository(thread.dbThread, deliveriesDao)
    }
}