package com.nefrit.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.nefrit.data.db.dao.OperationsDao
import com.nefrit.data.db.model.OperationLocal
import java.util.concurrent.Executors

@Database(version = 1,
    entities = [
        OperationLocal::class
    ])
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "app.db")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Executors.newSingleThreadExecutor().execute {
                                instance!!.operationsDao().addPoints(DataEntity.populateData())
                            }
                        }
                    })
                    .build()
            }
            return instance!!
        }
    }

    abstract fun operationsDao(): OperationsDao
}