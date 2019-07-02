package ktx.sovereign.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ktx.sovereign.database.provider.SchemaInfo

@Entity(tableName = SchemaInfo.GeoLocation.TableName)
data class GeoLocation (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.GeoLocation.PrimaryKey) val id: Long,
    @ColumnInfo(name = SchemaInfo.GeoLocation.Latitude) var latitude: Double,
    @ColumnInfo(name = SchemaInfo.GeoLocation.Longitude) var longitude: Double,
    @ColumnInfo(name = SchemaInfo.GeoLocation.Altitude) var altitude: Double,
    @ColumnInfo(name = SchemaInfo.GeoLocation.Timestamp) val timestamp: Long,
    @ColumnInfo(name = SchemaInfo.GeoLocation.Description) var description: String? = null
)