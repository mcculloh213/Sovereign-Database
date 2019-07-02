package ktx.sovereign.database.fts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import ktx.sovereign.database.entity.Note
import ktx.sovereign.database.provider.SchemaInfo

@Fts4(contentEntity = Note::class)
@Entity(tableName = SchemaInfo.NoteFts.TableName)
class NoteFts (
    @ColumnInfo(name = SchemaInfo.Note.Title) val title: String,
    @ColumnInfo(name = SchemaInfo.Note.Body) val body: String
)