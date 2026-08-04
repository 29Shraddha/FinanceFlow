package com.financeflow.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class IncomeRequestDTO {

    @NotBlank
    private String source;

    @Positive
    @NotNull
    private BigDecimal amount;

    @NotNull
    private LocalDate incomeDate;

    private String description;
}
