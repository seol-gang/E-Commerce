package kr.hhplus.be.server.order.controller

import kr.hhplus.be.server.annotation.UserId
import kr.hhplus.be.server.order.controller.request.OrderRequest
import kr.hhplus.be.server.order.controller.response.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {

    @PostMapping
    fun createOrder(@UserId userId: Long, @RequestBody orderRequest: OrderRequest): ResponseEntity<OrderResponse> {
        val orderResponse = OrderResponse(
                orderId = 1,
                orderHistory = orderRequest.productList,
        )
        return ResponseEntity.ok(orderResponse)
    }
}
