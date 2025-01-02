package kr.hhplus.be.server.resolver

import jakarta.servlet.http.HttpServletRequest
import kr.hhplus.be.server.annotation.UserId
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class UserIdResolver: HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(UserId::class.java)
    }

    override fun resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?,
                                 webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): Long {
        val request = webRequest.getNativeRequest(HttpServletRequest::class.java)
        return request?.getAttribute("userId") as Long
    }
}