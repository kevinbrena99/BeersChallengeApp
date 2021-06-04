package com.brena.beerschallengeapp.domain.usecases

import com.brena.beerschallengeapp.domain.handle.Either
import com.brena.beerschallengeapp.domain.handle.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
abstract class BaseUseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    open operator fun invoke(scope: CoroutineScope, params: Params,
                             onResult: (Either<Failure, Type>) -> Unit = {}) {
        val backgroundJob = scope.async(Dispatchers.IO) { run(params) }
        scope.launch { onResult(backgroundJob.await()) }
    }
}