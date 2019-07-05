package ktx.sovereign.database.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class EntityRepository {
    private val job: Job = Job()
    protected val repositoryScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)

    fun cancel() {
        job.cancel()
    }
}