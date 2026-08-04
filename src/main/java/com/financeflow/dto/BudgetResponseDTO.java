package com.financeflow.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BudgetResponseDTO {

    private Long id;
    private String category;
    private BigDecimal budgetAmount;
    private String month;
}
