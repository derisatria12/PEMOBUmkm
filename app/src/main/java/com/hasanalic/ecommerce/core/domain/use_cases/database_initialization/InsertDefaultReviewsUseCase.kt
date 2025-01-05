package com.hasanalic.ecommerce.core.domain.use_cases.database_initialization

import com.hasanalic.ecommerce.core.domain.model.DataError
import com.hasanalic.ecommerce.core.domain.model.Result
import com.hasanalic.ecommerce.core.domain.repository.DatabaseInitializer
import com.hasanalic.ecommerce.core.domain.utils.DatabaseInitializerUtil
import javax.inject.Inject

class InsertDefaultReviewsUseCase @Inject constructor(
    private val databaseInitializer: DatabaseInitializer
) {
    suspend operator fun invoke(): Result<Unit, DataError.Local> {
        val arrayOfReviews = DatabaseInitializerUtil.getReviewEntityArray()
        return databaseInitializer.insertDefaultReviews(*arrayOfReviews)
    }
}