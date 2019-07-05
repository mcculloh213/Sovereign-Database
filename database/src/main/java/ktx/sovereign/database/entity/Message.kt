package ktx.sovereign.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import ktx.sovereign.database.SchemaInfo

@Parcelize
@Entity(tableName = SchemaInfo.Message.TableName)
data class Message(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SchemaInfo.Message.PrimaryKey) val id: Long,
    @ColumnInfo(name = SchemaInfo.Message.Conversation) val conversation: String,
    @ColumnInfo(name = SchemaInfo.Message.To) val to: String,
    @ColumnInfo(name = SchemaInfo.Message.From) val from: String,
    @ColumnInfo(name = SchemaInfo.Message.Text) val text: String,
    @ColumnInfo(name = SchemaInfo.Message.Timestamp) val timestamp: Long
) : Parcelable