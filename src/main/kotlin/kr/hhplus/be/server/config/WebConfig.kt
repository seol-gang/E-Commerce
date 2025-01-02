package kr.hhplus.be.server.config

import kr.hhplus.be.server.interceptor.UserIdInterceptor
import kr.hhplus.be.server.resolver.UserIdResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    @Autowired
    private lateinit var userIdInterceptor: UserIdInterceptor

    @Autowired
    private lateinit var userIdResolver: UserIdResolver

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(userIdInterceptor)
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(userIdResolver)
    }
}
