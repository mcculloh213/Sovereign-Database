package ktx.sovereign.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(obj: T): Long
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(vararg obj: T): List<Long>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(obj: T): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg obj: T): Long
    @Update
    suspend fun update(vararg obj: T): Int
    @Delete
    suspend fun delete(vararg obj: T): Int
}