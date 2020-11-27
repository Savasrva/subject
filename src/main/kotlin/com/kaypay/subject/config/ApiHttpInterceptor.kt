package com.kaypay.subject.config

import org.apache.logging.log4j.LogManager
import org.slf4j.MDC
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ApiHttpInterceptor(
        private val environment: Environment,
        private val requestContext: RequestContext
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val method = request.method
        val requestPath = request.contextPath + request.servletPath
//        val ip = getRequestIpAddress(request)
        val userAgent = request.getHeader("User-Agent")
        requestContext.username = "logan test 1111"
//        requestContext.gatherFromRequest(request)
//        MDC.put("environment", environment.activeProfiles[0])
//        logger.info("[$ip] $method $requestPath - $userAgent")
        return true
    }
//    fun getRequestIpAddress(request: HttpServletRequest): String {
//        var requestIpAddress = request.getHeader("X-FORWARDED-FOR")
//        if (StringUtils.isEmpty(requestIpAddress)) {
//            requestIpAddress = request.remoteAddr
//        }
//        val ipArray = requestIpAddress.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//        if (ipArray.size > 1) {
//            requestIpAddress = ipArray[0]
//        }
//        if ("0:0:0:0:0:0:0:1" == requestIpAddress) {
//            requestIpAddress = "127.0.0.1"
//        }
//        return requestIpAddress
//    }
}