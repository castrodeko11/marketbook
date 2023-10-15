package br.com.aco.marketbook.marketbook.controller.request

import java.math.BigDecimal

data class PutBookRequest(
    val name: String?,
    val price: BigDecimal?
)