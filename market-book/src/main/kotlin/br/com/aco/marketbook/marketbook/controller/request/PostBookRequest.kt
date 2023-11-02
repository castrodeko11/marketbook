package br.com.aco.marketbook.marketbook.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

data class PostBookRequest(
    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:NotNull
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
) {

}
