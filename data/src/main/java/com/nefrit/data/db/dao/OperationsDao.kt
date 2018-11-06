package com.nefrit.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
abstract class OperationsDao {

    @Query("DELETE FROM operations")
    abstract fun clearTable()
}