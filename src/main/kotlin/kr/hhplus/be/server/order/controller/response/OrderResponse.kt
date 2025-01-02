package kr.hhplus.be.server.order.controller.response

import Order

data class OrderResponse(
        val orderId: Long,
        val orderHistory: List<Order>
)

