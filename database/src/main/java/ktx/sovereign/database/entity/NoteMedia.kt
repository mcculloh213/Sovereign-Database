package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(
    tableName = SchemaInfo.NoteMedia.TableName,
    primaryKeys = [
        SchemaInfo.NoteMedia.Note,
        SchemaInfo.NoteMedia.Media
    ],
    foreignKeys = [
        ForeignKey(
            entity = Note::class,
            parentColumns = [SchemaInfo.Note.PrimaryKey],
            childColumns = [SchemaInfo.NoteMedia.Note]
        )
    ]
)
data class NoteMedia(
    @ColumnInfo(name = SchemaInfo.NoteMedia.Note) val note: Long,
    @ColumnInfo(name = SchemaInfo.NoteMedia.Media) val media: Long
)