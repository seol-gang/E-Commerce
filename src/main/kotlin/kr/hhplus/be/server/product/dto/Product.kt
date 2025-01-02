package kr.hhplus.be.server.product.dto

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: Long,
    val stock_quantity: Long
)
