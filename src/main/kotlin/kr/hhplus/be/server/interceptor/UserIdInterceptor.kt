package kr.hhplus.be.server.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import kr.hhplus.be.server.annotation.UserId
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.HandlerInterceptor

@Component
class UserIdInterceptor: HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if(handler !is HandlerMethod) return true

        val hasUserIdAnnotation = handler.methodParameters.any {
            it.hasParameterAnnotation(UserId::class.java)
        }

        if (!hasUserIdAnnotation) {
            return true
        }

        val authHeader = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val userId = authHeader.substring(7) // Remove "Bearer " prefix
            request.setAttribute("userId", userId.toLong())
            return true
        }

        throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization header is required")
    }
}