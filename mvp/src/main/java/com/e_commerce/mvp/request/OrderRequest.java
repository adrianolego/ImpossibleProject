package com.e_commerce.mvp.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@Schema(name = "OrderRequest", description = "Payload to create an order")
public record OrderRequest(
        @NotBlank(message = "customerName cannot be blank")
        @Schema(description = "Customer name", example = "John Doe")
        String customerName,

        @NotBlank(message = "customerEmail cannot be blank")
        @Email(message = "customerEmail must be a valid email")
        @Schema(description = "Customer email", example = "john@email.com")
        String customerEmail,

        @NotBlank(message = "customerPhone cannot be blank")
        @Pattern(regexp = "^[0-9+()\\s-]{8,20}$", message = "customerPhone must have a valid format")
        @Schema(description = "Customer phone", example = "+55 (11) 99999-9999")
        String customerPhone,

        @NotNull(message = "totalAmount cannot be null")
        @DecimalMin(value = "0.01", message = "totalAmount must be greater than zero")
        @Schema(description = "Order total amount", example = "149.90")
        BigDecimal totalAmount,

        @Pattern(regexp = "PENDING|PROCESSED|ERROR", message = "status must be PENDING, PROCESSED or ERROR")
        @Schema(description = "Order status. If not provided, it will be PENDING", example = "PENDING", defaultValue = "PENDING")
        String status
) {
    public OrderRequest {
        if (status == null || status.isBlank()) {
            status = "PENDING";
        }
    }
}
