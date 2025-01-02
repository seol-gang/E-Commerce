package kr.hhplus.be.server.order.controller.request

import Order

data class OrderRequest(
        val productList: List<Order>,
        val couponId: Long?
)
