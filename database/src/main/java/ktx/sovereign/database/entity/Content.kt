package ktx.sovereign.database.entity

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(tableName = SchemaInfo.Content.TableName)
data class Content(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SchemaInfo.Content.PrimaryKey) val id: String,
    @ColumnInfo(name = SchemaInfo.Content.Title) var title: String,
    @ColumnInfo(name = SchemaInfo.Content.Path) val path: String,
    @ColumnInfo(name = SchemaInfo.Content.ApplicationToken) val token: String,
    @ColumnInfo(name = SchemaInfo.Content.Checksum) var checksum: String
)