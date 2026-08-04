package com.financeflow.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BudgetRequestDTO {

    @NotBlank
    private String category;

    @Positive
    @NotNull
    private BigDecimal budgetAmount;

    @NotBlank
    private String month;
}