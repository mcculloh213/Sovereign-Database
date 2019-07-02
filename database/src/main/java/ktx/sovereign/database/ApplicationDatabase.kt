package ktx.sovereign.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ktx.sovereign.database.entity.*

@Database(
    entities = [
        Content::class,
        Document::class,
        GeoLocation::class,
        Keyword::class,
        Message::class,
        Note::class,
        NoteLocation::class,
        NoteMedia::class,
        ScrollingMenuItem::class
    ],
    version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun NoteDao()
    abstract fun MessageDao()
    abstract fun ScrollingMenuItemDao()

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