package ktx.sovereign.database.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import ktx.sovereign.database.entity.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(note: Note): Long
    @Update
    suspend fun update(note: Note): Int
    @Delete
    suspend fun delete(note: Note): Int
    @Query("SELECT * FROM notes WHERE _id = :id")
    suspend fun getNote(id: Long): Note?
    @Query ("SELECT COUNT(*) FROM notes")
    suspend fun count(): Int

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>
    @Query("DELETE FROM notes")
    fun deleteAll()

    @Query("SELECT notes.* FROM notes JOIN fts_notes ON (notes._id = fts_notes.docid) WHERE fts_notes MATCH :query")
    fun search(query: String): LiveData<List<Note>>

    @Query("SELECT * FROM notes")
    fun cSelectAll(): Cursor
    @Query("SELECT * FROM notes WHERE _id = :id")
    fun cGetNote(id: Long): Cursor
}