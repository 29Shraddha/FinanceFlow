package com.financeflow.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class IncomeResponseDTO {

    private Long id;
    private String source;
    private BigDecimal amount;
    private LocalDate incomeDate;
    private String description;
}
