package com.kaypay.subject.service

import com.kaypay.subject.BadRequestException
import com.kaypay.subject.config.RequestContext
import org.springframework.stereotype.Service

@Service
class PayService(
        private val requestContext: RequestContext
) {
    fun hello(): String{
       return this.requestContext.username
    }

    fun throwException(): String{
        throw BadRequestException("Exception 테스트")
    }
}