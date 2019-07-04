package ktx.sovereign.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import ktx.sovereign.database.SchemaInfo

@Entity(tableName = SchemaInfo.MetaTag.TableName)
@Parcelize
data class MetaTag(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.MetaTag.PrimaryKey) var id: Long?,
    @ColumnInfo(name = SchemaInfo.MetaTag.Key) var key: String,
    @ColumnInfo(name = SchemaInfo.MetaTag.Value) var value: String
) : Parcelable {
    @Ignore
    constructor()
            : this(null, "", "")
    @Ignore
    constructor(key: String, value: String)
            : this(null, key, value)
}