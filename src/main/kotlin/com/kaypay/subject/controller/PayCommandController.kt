package com.kaypay.subject.controller

import com.kaypay.subject.service.PayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/pay")
class PayCommandController(
//        private val userCommandService: UserCommandService
    private val payService: PayService
) {
//    @PostMapping
//    fun createUser(@RequestBody dto: UserCreateDto): CompletableFuture<String> =
//            userCommandService.createUser(dto)
//
//    @PostMapping("{userId}/orders")
//    fun createOrder(
//            @PathVariable("userId") userId: String,
//            @RequestBody dto: OrderCreateDto): CompletableFuture<String> =
//            this.userCommandService.createOrder(userId, dto)

    @GetMapping
    fun hello(): String = this.payService.hello()

    @GetMapping("/exceptions")
    fun exceptions(): String = this.payService.throwException()
}