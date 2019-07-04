package ktx.sovereign.database.dao

import androidx.room.Dao
import ktx.sovereign.database.entity.Volume

@Dao
interface VolumeDao : BaseDao<Volume> {
}