package ktx.sovereign.database.dao

import androidx.room.Dao
import ktx.sovereign.database.entity.Message

@Dao
interface MessageDao : BaseDao<Message>{
}