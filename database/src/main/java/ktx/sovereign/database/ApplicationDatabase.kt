package ktx.sovereign.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ktx.sovereign.database.dao.*
import ktx.sovereign.database.entity.*
import ktx.sovereign.database.fts.NoteFts

@Database(
    entities = [
        Content::class,
        Document::class,
        Geolocation::class,
        Image::class,
        Keyword::class,
        Message::class,
        MetaTag::class,
        Note::class,
        NoteFts::class,
        NoteLocation::class,
        NoteMedia::class,
        NoteTag::class,
        ScrollingMenuItem::class,
        Volume::class
    ],
    exportSchema = true,
    version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun ContentDao(): ContentDao
    abstract fun DocumentDao(): DocumentDao
    abstract fun GeolocationDao(): GeolocationDao
    abstract fun ImageDao(): ImageDao
    abstract fun KeywordDao(): KeywordDao
    abstract fun MessageDao(): MessageDao
    abstract fun MetaTagDao(): MetaTagDao
    abstract fun NoteDao(): NoteDao
    abstract fun ScrollingMenuItemDao(): ScrollingMenuItemDao
    abstract fun VolumeDao(): VolumeDao

    companion object {
        @Volatile
        private var Instance: ApplicationDatabase? = null

        @JvmStatic fun getDatabase(context: Context): ApplicationDatabase {
            val temp = Instance
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDatabase::class.java,
                    "industrial_badger_app.db3"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}