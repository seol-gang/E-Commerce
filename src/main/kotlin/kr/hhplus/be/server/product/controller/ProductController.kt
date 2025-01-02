package kr.hhplus.be.server.product.controller

import kr.hhplus.be.server.product.dto.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        val products = listOf(
                Product(1, "후드티", "아주 멋진 후드티", 30000, 100),
                Product(2, "청바지", "편안한 청바지", 45000, 50),
                Product(3, "티셔츠", "기본 티셔츠", 20000, 200)
        )
        return ResponseEntity.ok(products)
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long): ResponseEntity<Product> {
        val product = Product(productId, "후드티", "아주 멋진 후드티", 30000, 100)
        return ResponseEntity.ok(product)
    }

    @GetMapping("/top-5")
    fun getTop5Products(): ResponseEntity<List<Product>> {
        val products = listOf(
                Product(1, "후드티", "아주 멋진 후드티", 30000, 100),
                Product(2, "청바지", "편안한 청바지", 45000, 50),
                Product(3, "티셔츠", "기본 티셔츠", 20000, 200),
                Product(4, "키보드", "해피해킹", 400000, 10),
                Product(5, "마우스", "G903", 119000, 30),
        )
        return ResponseEntity.ok(products)
    }
}
