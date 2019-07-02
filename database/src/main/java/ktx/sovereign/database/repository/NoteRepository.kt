package ktx.sovereign.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ktx.sovereign.database.dao.NoteDao
import ktx.sovereign.database.entity.Note

class NoteRepository(private val dao: NoteDao) {
    val notes: LiveData<List<Note>> = dao.getAllNotes()

    @WorkerThread
    suspend fun count(): Int = dao.count()

    /**
     * Inserts a [Note] into the database.
     * @return The inserted [Note.id]
     */
    @WorkerThread
    suspend fun insert(note: Note): Long = dao.insert(note)

    /**
     * Gets a [Note] from the database, searching on [Note.id]
     * @return The found note
     */
    @WorkerThread
    suspend fun get(id: Long): Note? = dao.getNote(id)

    /**
     * Updates an existing [Note] in the database
     * @return The number of rows in the database updated.
     */
    @WorkerThread
    suspend fun update(note: Note): Int = dao.update(note)

    /**
     * Deletes an existing [Note] from the database
     * @return The number of rows in the database deleted.
     */
    @WorkerThread
    suspend fun delete(note: Note): Int = dao.delete(note)
}