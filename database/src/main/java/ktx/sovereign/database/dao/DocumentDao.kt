package ktx.sovereign.database.dao

import androidx.room.Dao
import ktx.sovereign.database.entity.Document

@Dao
interface DocumentDao : BaseDao<Document> {
}