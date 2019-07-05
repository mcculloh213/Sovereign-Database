package ktx.sovereign.database.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.withContext
import ktx.sovereign.database.dao.NoteDao
import ktx.sovereign.database.entity.*
import ktx.sovereign.database.relation.BadgerNote

class NoteRepository(private val dao: NoteDao) : EntityRepository() {
    val notes: LiveData<List<Note>> = dao.getAllNotes()

    suspend fun count(): Int = withContext(repositoryScope.coroutineContext) { dao.count() }

    /**
     * Inserts a [Note] into the database.
     * @return The inserted [Note.id]
     */
    suspend fun insert(note: Note): Long = withContext(repositoryScope.coroutineContext) { dao.insert(note) }
    suspend fun addLocation(location: Geolocation): Long = withContext(repositoryScope.coroutineContext) { dao.upsertLocation(location) }
    suspend fun addMedia(media: Image): Long = withContext(repositoryScope.coroutineContext) { dao.upsertMedia(media) }
    suspend fun addTag(tag: MetaTag): Long = withContext(repositoryScope.coroutineContext) { dao.upsertTag(tag) }
    suspend fun removeLocation(note: Long, location: Long) : Int = withContext(repositoryScope.coroutineContext) {
        dao.deleteNoteLocation(NoteLocation(note, location)
    )}
    suspend fun removeMedia(note: Long, media: Long): Int = withContext(repositoryScope.coroutineContext) {
        dao.deleteNoteMedia(NoteMedia(note, media))
    }
    suspend fun removeTag(note: Long, tag: Long): Int = withContext(repositoryScope.coroutineContext) {
        dao.deleteNoteTag(NoteTag(note, tag))
    }

    /**
     * Gets a [Note] from the database, searching on [Note.id]
     * @return The found note
     */
    suspend fun get(id: Long): Note? = withContext(repositoryScope.coroutineContext) { dao.getNote(id) }

    /**
     * Updates an existing [Note] in the database
     * @return The number of rows in the database updated.
     */
    suspend fun update(note: Note): Int = withContext(repositoryScope.coroutineContext) { dao.update(note) }

    /**
     * Deletes an existing [Note] from the database
     * @return The number of rows in the database deleted.
     */
    suspend fun delete(note: Note): Int = withContext(repositoryScope.coroutineContext) { dao.delete(note) }

    suspend fun getNote(id: Long): BadgerNote? = withContext(repositoryScope.coroutineContext) {
        dao.getBadgerNote(id)
    }
    suspend fun getNote(note: Note): BadgerNote? = withContext(repositoryScope.coroutineContext) {
        dao.getBadgerNote(note)
    }
    suspend fun saveNote(
        note: Note,
        media: List<Image>,
        locations: List<Geolocation>,
        tags: List<MetaTag>
    ): BadgerNote? = withContext(repositoryScope.coroutineContext) {
        dao.saveNote(note, media, locations, tags)
    }
}