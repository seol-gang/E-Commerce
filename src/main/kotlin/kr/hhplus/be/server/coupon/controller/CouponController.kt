package kr.hhplus.be.server.coupon.controller

import kr.hhplus.be.server.coupon.dto.Coupon
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/coupons")
class CouponController {

    @PostMapping("/{couponId}")
    fun issueCoupon(@PathVariable couponId: Long): ResponseEntity<Coupon> {
        val coupon = Coupon(
            couponId = couponId,
            expiredAt = LocalDateTime.now().plusDays(30),
            discountType = "percent",
            discountValue = 10,
            minimumOrderAmount = 30000,
            maximumDiscountAmount = 5000
        )
        return ResponseEntity.ok(coupon)
    }
}
