package com.kaypay.subject.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
open class RequestContext {

    open var version: String = "1.0.0"
    open var username: String = ""


//    open var user: User? = null
//    open fun gatherFromRequest(request: HttpServletRequest) {
//        request.userPrincipal?.let {
//            username = it.name
//            user = this.userRepository.findByAccount(username)
//        }
//    }
}