package com.example.litthu_eyelash_app.domain.core.usecase

interface NonSuspendUseCase<P, R> {

    operator fun invoke(parameters: P): Result<R> {
        return try {
            Result.success(execute(parameters))
        } catch (e: Exception) {
            println({ "${this::class.simpleName}: $e" })
            Result.failure(e)
        }
    }

    fun execute(parameters: P): R
}
