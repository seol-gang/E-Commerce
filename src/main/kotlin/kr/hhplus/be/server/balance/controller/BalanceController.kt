package kr.hhplus.be.server.balance.controller


import kr.hhplus.be.server.annotation.UserId
import kr.hhplus.be.server.balance.controller.request.BalanceChargeRequest
import kr.hhplus.be.server.balance.dto.Balance
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/balance")
class BalanceController {
    @GetMapping
    fun getBalance(
            @UserId userId: Long
    ): ResponseEntity<Balance> {
        return ResponseEntity.ok(Balance(userId = userId, balance = 10000))
    }

    @PostMapping("/charge")
    fun chargeBalance(
            @UserId userId: Long,
            @RequestBody request: BalanceChargeRequest
    ): ResponseEntity<Balance> {
        return ResponseEntity.ok(Balance(userId = userId, balance = request.balance))
    }
}