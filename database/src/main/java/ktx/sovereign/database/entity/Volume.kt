package ktx.sovereign.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import ktx.sovereign.database.SchemaInfo

@Entity(tableName = SchemaInfo.Volume.TableName)
@Parcelize
data class Volume(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SchemaInfo.Volume.PrimaryKey) val id: String,
    @ColumnInfo(name = SchemaInfo.Volume.Name) var name: String,
    @ColumnInfo(name = SchemaInfo.Volume.Description) var description: String,
    @ColumnInfo(name = SchemaInfo.Volume.Token) var token: String
) : Parcelable