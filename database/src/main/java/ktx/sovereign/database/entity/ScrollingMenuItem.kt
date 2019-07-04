package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ktx.sovereign.database.SchemaInfo

@Entity(tableName = SchemaInfo.ScrollingMenuItem.TableName)
data class ScrollingMenuItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.PrimaryKey) val id: Long,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Context) val context: String,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Label) val label: String,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Item) val item: String,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Directive) val directive: String,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Icon) val icon: String,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Tint) val tint: Int,
    @ColumnInfo(name = SchemaInfo.ScrollingMenuItem.Ordinal) var ordinal: Int
)