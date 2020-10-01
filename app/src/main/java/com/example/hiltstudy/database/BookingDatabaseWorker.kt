package com.example.hiltstudy.database

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

class BookingDatabaseWorker(context: Context, workerParms: WorkerParameters): CoroutineWorker(context, workerParms) {

    override suspend fun doWork(): Result = coroutineScope {
        try{
            val database = AppDatabase.getInstance(applicationContext)
            database.bookingDao().deleteBookings()

            // load lake list from Json file
//            val lakeList = listOf(
//                Lake("12340", "Dupa", 3.5, 4.1, ""),
//                Lake("12341", "Mamry", 6.3, 9.7),
//                Lake("12342", "Solina", 3.5, 4.1, ""),
//                Lake("12343", "Grafham Water", 6.3, 9.7),
//                Lake("12344", "Rutlant Water", 3.5, 4.1, ""),
//                Lake("12345", "Big lake", 6.3, 9.7),
//                Lake("12346", "Small lake", 3.5, 4.1, ""),
//                Lake("12347", "Deep Lake", 6.3, 9.7)
//            )

            // val lakeList = lakeService.getLakes()

            // database.bookingDao().insertLakes(lakeList)

            Result.success()
        }catch (ex: Exception){
            Log.e(TAG, "exception: $ex.t")
            Result.failure()
        }
    }


    suspend fun fetchLakesFromFirebase(){

    }



    companion object{
        const val TAG = "LakeDatabaseWorker"
    }
}