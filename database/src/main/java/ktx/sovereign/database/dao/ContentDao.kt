package ktx.sovereign.database.dao

import androidx.room.Dao
import ktx.sovereign.database.entity.Content

@Dao
interface ContentDao : BaseDao<Content> {
}