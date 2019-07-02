package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(tableName = SchemaInfo.Note.TableName)
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.Note.PrimaryKey) val id: Long,
    @ColumnInfo(name = SchemaInfo.Note.Title) var title: String,
    @ColumnInfo(name = SchemaInfo.Note.Body) var body: String,
    @ColumnInfo(name = SchemaInfo.Note.IsFavorite) var favorite: Boolean,
    @ColumnInfo(name = SchemaInfo.Note.CreatedAt) val created: Long,
    @ColumnInfo(name = SchemaInfo.Note.LastUpdated) var updated: Long
)