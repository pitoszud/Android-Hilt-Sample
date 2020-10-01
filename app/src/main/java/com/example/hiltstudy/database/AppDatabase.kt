package com.example.hiltstudy.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.hiltstudy.data.Booking


@Database(entities = [
    Booking::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun bookingDao(): BookingDao


    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }





    companion object {
        @Volatile
        private var instance: AppDatabase? = null


        fun getInstance(context: Context): AppDatabase {
            return instance
                ?: synchronized(this){
                    instance
                        ?: buildDatabase(
                            context
                        ).also {
                            instance = it
                        }
                }
        }


        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "bookingDatabase")
                .addCallback(
                    roomCallback(
                        context
                    )
                )
                //.addMigrations(MIGRATION_ADD_DELETE)
                .fallbackToDestructiveMigration()
                .build()
        }


        private fun roomCallback(context: Context): Callback{
            return object: Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val request = OneTimeWorkRequestBuilder<BookingDatabaseWorker>().build()
                    WorkManager.getInstance(context).enqueue(request)
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                }
            }

        }





    }

}
