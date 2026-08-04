package com.financeflow.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequestDTO {

    @NotBlank
    private String title;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate expenseDate;

    private String description;
}
