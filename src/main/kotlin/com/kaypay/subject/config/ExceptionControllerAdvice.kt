package com.kaypay.subject.config

import com.kaypay.subject.ServiceException
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class ExceptionControllerAdvice(
    private val environment: Environment
) {

    private val logger = LoggerFactory.getLogger(ExceptionControllerAdvice::class.java)

    @ExceptionHandler(ServiceException::class)
    fun handleServiceException(
            e: ServiceException,
            request: HttpServletRequest,
            response: HttpServletResponse
    ): ResponseEntity<ErrorResponse> {
        logger.error("-----------------------------------------------------")
        logger.error("service exception occurred: ${e.message}")
        logger.error("-----------------------------------------------------")

//        if (e is (ServiceException)NeedConfirmException) {
//            val phase = environment.activeProfiles[0]
//            Sentry.getContext().addTag("environment", phase)
//            Sentry.capture(e)
//        }

        return ResponseEntity.badRequest().body(ErrorResponse("22", e.message))
    }

//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception::class)
//    fun handleException(
//        e: Exception,
//        request: HttpServletRequest,
//        response: HttpServletResponse
//    ): ResponseEntity<ErrorResponse> {
//        logger.error("-----------------------------------------------------")
//        logger.error("exception occurred: ${e.message}")
//        logger.error("-----------------------------------------------------")
//
//        val phase = environment.activeProfiles[0]
//        if (arrayOf("beta", "prod").contains(phase)) {
//            Sentry.getContext().addTag("environment", phase)
//            Sentry.capture(e)
//        } else {
//            e.printStackTrace()
//        }
//
//        return BaseResponse.internalServerError(e)
//    }
//
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
//    fun handleMethodArgumentNotValidException(
//        e: MethodArgumentNotValidException,
//        request: HttpServletRequest,
//        response: HttpServletResponse
//    ): ResponseEntity<ErrorResponse> {
//        logger.error("-----------------------------------------------------")
//        logger.error("valid exception occurred: ${e.message}")
//        logger.error("-----------------------------------------------------")
//
//        logger.error("${e.bindingResult.allErrors}")
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//            .body(ErrorResponse(Code.BAD_REQUEST, e.bindingResult.allErrors[0].defaultMessage))
//    }
//
////    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
////    @ExceptionHandler(value = [HttpRequestMethodNotSupportedException::class])
////    fun handleHttpRequestMethodNotSupportedException(
////        e: HttpRequestMethodNotSupportedException,
////        request: HttpServletRequest,
////        response: HttpServletResponse
////    ): ResponseEntity<ErrorResponse> {
////
////        logger.error("-----------------------------------------------------")
////        logger.error("handleHttpRequestMethodNotSupportedException: ${e.message}")
////        logger.error("-----------------------------------------------------")
////        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
////            .body(ErrorResponse(Code.BAD_REQUEST, "지원하지 않는 API method 요청입니다"))
////    }
//
//
//    @ResponseStatus(value = HttpStatus.FORBIDDEN)
//    @ExceptionHandler(value = [CustomAccessDeniedException::class])
//    fun handleAccessDeniedException(
//        e: CustomAccessDeniedException,
//        request: HttpServletRequest,
//        response: HttpServletResponse
//    ): ResponseEntity<ErrorResponse> {
//        logger.error("-----------------------------------------------------")
//        logger.error("handleAccessDeniedException: ${e.message}")
//        logger.error("-----------------------------------------------------")
//
//        return BaseResponse.accessDeniedException(e)
//    }
//
//    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(value = [CustomAuthenticationException::class])
//    fun handleAccessDeniedException(
//        e: CustomAuthenticationException,
//        request: HttpServletRequest,
//        response: HttpServletResponse
//    ): ResponseEntity<ErrorResponse> {
//        logger.error("-----------------------------------------------------")
//        logger.error("handleAccessDeniedException: ${e.message}")
//        logger.error("-----------------------------------------------------")
//
//        return BaseResponse.authenticationException(e)
//    }

}