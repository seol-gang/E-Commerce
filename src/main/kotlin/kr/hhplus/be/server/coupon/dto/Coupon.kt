package kr.hhplus.be.server.coupon.dto

import java.time.LocalDateTime

data class Coupon(
        val couponId: Long,
        val expiredAt: LocalDateTime,
        val discountType: String,
        val discountValue: Int,
        val minimumOrderAmount: Int,
        val maximumDiscountAmount: Int
)
