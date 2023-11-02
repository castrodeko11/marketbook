package br.com.aco.marketbook.marketbook.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}