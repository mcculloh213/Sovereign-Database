package ktx.sovereign.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import ktx.sovereign.database.SchemaInfo

@Entity(tableName = SchemaInfo.Note.TableName)
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.Note.PrimaryKey) var id: Long? = null,
    @ColumnInfo(name = SchemaInfo.Note.Title) var title: String,
    @ColumnInfo(name = SchemaInfo.Note.Body) var body: String,
    @ColumnInfo(name = SchemaInfo.Note.IsFavorite) var favorite: Boolean,
    @ColumnInfo(name = SchemaInfo.Note.CreatedAt) val created: Long,
    @ColumnInfo(name = SchemaInfo.Note.LastUpdated) var updated: Long
) : Parcelable {
    @Ignore
    constructor()
            : this(null, "", "", false, -1, -1)
    @Ignore
    constructor(title: String, body: String, favorite: Boolean, created: Long, updated: Long)
            : this(null, title, body, favorite, created, updated)
}
