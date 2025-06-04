package com.example.litthu_eyelash_app.domain.core.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UseCase<in P, R> {

    // val dispatcher: CoroutineDispatcher

    /** Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            // Moving all use case's executions to the injected dispatcher
            // In production code, this is usually the Default dispatcher (background thread)
            // In tests, this becomes a TestCoroutineDispatcher
            withContext(Dispatchers.IO) {
                execute(parameters).let {
                    Result.success(it)
                }
            }
        } catch (e: Exception) {
            println({ "${this::class.simpleName}: $e" })
            Result.failure(e)
        }
    }

    /**
     * The function which used to execute this use case
     *
     * @param parameters the input parameters to run the use case with
     * @return [Result]
     */
    @Throws(RuntimeException::class)
    suspend fun execute(parameters: P): R
}