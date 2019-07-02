package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(tableName = SchemaInfo.Document.TableName)
data class Document(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.Document.PrimaryKey) val id: Long,
    @ColumnInfo(name = SchemaInfo.Document.RemoteRepository) val repository: String,
    @ColumnInfo(name = SchemaInfo.Document.FileName) var filename: String,
    @ColumnInfo(name = SchemaInfo.Document.MimeType) val mime: String,
    @ColumnInfo(name = SchemaInfo.Document.IsLocal) var isLocal: Boolean = false
)