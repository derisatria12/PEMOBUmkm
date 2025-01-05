package com.hasanalic.ecommerce.feature_checkout.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.hasanalic.ecommerce.MainCoroutineRule
import com.hasanalic.ecommerce.core.domain.model.Result
import com.hasanalic.ecommerce.feature_checkout.data.local.entity.CardEntity
import com.hasanalic.ecommerce.feature_checkout.data.repository.FakeCardRepository
import com.hasanalic.ecommerce.feature_checkout.domain.repository.CardRepository
import com.hasanalic.ecommerce.feature_checkout.domain.use_cases.GetCardsByUserIdUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCardsByUserIdUseCaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var cardRepository: CardRepository
    private lateinit var getCardsByUserIdUseCase: GetCardsByUserIdUseCase

    @Before
    fun setup() {
        cardRepository = FakeCardRepository()
        getCardsByUserIdUseCase = GetCardsByUserIdUseCase(cardRepository)
    }

    @Test
    fun `Get Cards should returns card list successfuly`() = runBlocking {
        val result = getCardsByUserIdUseCase("1")
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isNotEmpty()
        assertThat((result as Result.Success).data.first()).isInstanceOf(CardEntity::class.java)
    }
}