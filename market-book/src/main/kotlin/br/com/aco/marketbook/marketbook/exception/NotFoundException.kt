package br.com.aco.marketbook.marketbook.exception

class NotFoundException(override val message: String, val errorCode: String) : Exception() {
}