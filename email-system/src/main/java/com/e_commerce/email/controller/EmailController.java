package com.e_commerce.email.controller;

import com.e_commerce.email.service.EmailService;
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
@RequestMapping("/v1/email")
@Tag(name = "Email", description = "Email Operations")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Send an email", description = "Send email to the client")
    public ResponseEntity<Void> sendEmails(@PathVariable @Positive Long id) {
        emailService.sendEmail(id);
        return ResponseEntity.ok().build();
    }
}
