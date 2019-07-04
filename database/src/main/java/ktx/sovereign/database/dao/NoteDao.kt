package ktx.sovereign.database.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import ktx.sovereign.database.entity.*
import ktx.sovereign.database.relation.BadgerNote

@Dao
abstract class NoteDao : BaseDao<Note> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsertMedia(media: Image): Long
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insertNoteMedia(relation: NoteMedia)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsertLocation(location: Geolocation): Long
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insertNoteLocation(relation: NoteLocation)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsertTag(tag: MetaTag): Long
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insertNoteTag(relation: NoteTag)

    @Query("SELECT * FROM notes WHERE _id = :id")
    abstract suspend fun getNote(id: Long): Note?
    @Query ("SELECT COUNT(*) FROM notes")
    abstract suspend fun count(): Int

    @Query("SELECT * FROM notes")
    abstract fun getAllNotes(): LiveData<List<Note>>
    @Query("DELETE FROM notes")
    abstract fun deleteAll()

    @Query("""
        SELECT notes.* FROM notes
        JOIN fts_notes ON notes._id = fts_notes.docid
        WHERE fts_notes MATCH :query
    """)
    abstract fun search(query: String): LiveData<List<Note>>

    @Query("""
        SELECT * FROM images
        LEFT OUTER JOIN note_media ON images._id = note_media._media
        WHERE note_media._note = :id
    """)
    abstract suspend fun getImages(id: Long): List<Image>
    @Query("""
        SELECT * FROM locations
        LEFT OUTER JOIN note_locations ON locations._id = note_locations._location
        WHERE note_locations._note = :id
    """)
    abstract suspend fun getLocations(id: Long): List<Geolocation>
    @Query("""
        SELECT * FROM _metadata
        LEFT OUTER JOIN note_tags ON _metadata._id = note_tags._meta
        WHERE note_tags._note = :id
    """)
    abstract suspend fun getTags(id: Long): List<MetaTag>

    @Transaction
    open suspend fun getBadgerNote(id: Long): BadgerNote? {
        try {
            val note = getNote(id) ?: return null
            val images = getImages(id)
            val locations = getLocations(id)
            val tags = getTags(id)
            return BadgerNote(note, images, locations, tags)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return null
    }
    @Transaction
    open suspend fun getBadgerNote(note: Note): BadgerNote? {
        val id = note.id ?: return null
        try {
            val images = getImages(id)
            val locations = getLocations(id)
            val tags = getTags(id)
            return BadgerNote(note, images, locations, tags)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return null
    }
    @Transaction
    open suspend fun saveNote(
        note: Note,
        images: List<Image>,
        locations: List<Geolocation>,
        tags: List<MetaTag>
    ): BadgerNote? {
        try {
            if (note.id == null) {  // Create
                val id = insert(note)
                images.forEach {
                    val imageId = upsertMedia(it)
                    insertNoteMedia(NoteMedia(id, imageId))
                    it.id = imageId
                }
                locations.forEach {
                    val locationId = upsertLocation(it)
                    insertNoteLocation(NoteLocation(id, locationId))
                    it.id = locationId
                }
                tags.forEach {
                    val tagId = upsertTag(it)
                    insertNoteTag(NoteTag(id, tagId))
                    it.id = tagId
                }
                note.id = id
            } else {                // Update
                update(note)
                val id = note.id!!
                images.forEach {
                    val imageId = upsertMedia(it)
                    if (it.id == null) {
                        insertNoteMedia(NoteMedia(id, imageId))
                        it.id = imageId
                    }
                }
                locations.forEach {
                    val locationId = upsertLocation(it)
                    if (it.id == null) {
                        insertNoteLocation(NoteLocation(id, locationId))
                        it.id = locationId
                    }
                }
                tags.forEach {
                    val tagId = upsertTag(it)
                    if (it.id == null) {
                        insertNoteTag(NoteTag(id, tagId))
                        it.id = tagId
                    }
                }
            }
            return BadgerNote(note, images, locations, tags)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return null
    }

    @Query("SELECT * FROM notes")
    abstract fun cSelectAll(): Cursor
    @Query("SELECT * FROM notes WHERE _id = :id")
    abstract fun cGetNote(id: Long): Cursor
}