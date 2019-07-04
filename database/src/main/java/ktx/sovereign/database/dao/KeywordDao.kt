package ktx.sovereign.database.dao

import androidx.room.Dao
import ktx.sovereign.database.entity.Keyword

@Dao
interface KeywordDao : BaseDao<Keyword> {
}