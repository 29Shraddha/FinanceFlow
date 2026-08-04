package com.financeflow.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ExpenseResponseDTO {

    private Long id;
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate expenseDate;
    private String description;
}
