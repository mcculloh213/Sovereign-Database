package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(
    tableName = SchemaInfo.NoteLocation.TableName,
    primaryKeys = [
        SchemaInfo.NoteLocation.Note,
        SchemaInfo.NoteLocation.Location
    ],
    foreignKeys = [
        ForeignKey(
            entity = Note::class,
            parentColumns = [SchemaInfo.Note.PrimaryKey],
            childColumns = [SchemaInfo.NoteLocation.Note]
        ),
        ForeignKey(
            entity = GeoLocation::class,
            parentColumns = [SchemaInfo.GeoLocation.PrimaryKey],
            childColumns = [SchemaInfo.NoteLocation.Location]
        )
    ]
)
data class NoteLocation(
    @ColumnInfo(name = SchemaInfo.NoteLocation.Note) val note: Long,
    @ColumnInfo(name = SchemaInfo.NoteLocation.Location) val media: Long
)