package com.e_commerce.sms.controller;

import com.e_commerce.sms.service.SmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/v1/sms")
@Tag(name = "Sms", description = "Sms Operations")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Send an sms", description = "Send sms to the client")
    public ResponseEntity<Void> sendSms(@PathVariable @Positive Long id) {
        smsService.sendEmail(id);
        return ResponseEntity.ok().build();
    }
}
