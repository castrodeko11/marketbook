package br.com.aco.marketbook.marketbook.enums

enum class Erros(val code: String, val message: String) {
    ML101("ML-001", "Book [%s] not found"),
    ML102("ML-002", "Canoot update Book with status [%s]"),
    ML201("ML-002", "Cusotmer [%s] not found")

}