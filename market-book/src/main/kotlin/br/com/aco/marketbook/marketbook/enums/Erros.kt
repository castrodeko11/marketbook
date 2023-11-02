package br.com.aco.marketbook.marketbook.enums

enum class Erros(val code: String, val message: String) {
    ML001("ML-001", "Invalid request"),
    ML101("ML-101", "Book [%s] not found"),
    ML102("ML-102", "Canoot update Book with status [%s]"),
    ML201("ML-201", "Cusotmer [%s] not found")

}