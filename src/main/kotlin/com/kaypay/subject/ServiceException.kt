package com.kaypay.subject

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

open class ServiceException(message: String?) : RuntimeException(message)

class UserNotAvailableException : ServiceException("서비스를 이용할 수 없는 사용자 입니다")
class CustomAccessDeniedException : ServiceException("해당 리소스에 접근하기 위한 권한이 없습니다")
class CustomAuthenticationException : ServiceException("인증되지 않은 사용자 요청입니다")

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
open class InternalServerException(message: String) : Exception(message)

class NeedConfirmException(message: String = "예상하지 못한 케이스 발생") : InternalServerException("[개발자확인필요] $message")

// BadRequestException
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
open class BadRequestException(message: String) : ServiceException(message)