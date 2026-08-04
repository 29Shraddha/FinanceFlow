package com.financeflow.service;

import com.financeflow.dto.DashboardResponseDTO;
import com.financeflow.repository.ExpenseRepository;
import com.financeflow.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public DashboardService(
            IncomeRepository incomeRepository,
            ExpenseRepository expenseRepository) {

        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public DashboardResponseDTO getDashboard() {

        BigDecimal income = incomeRepository.getTotalIncome();

        BigDecimal expense = expenseRepository.getTotalExpense();

        BigDecimal balance = income.subtract(expense);

        return DashboardResponseDTO.builder()
                .totalIncome(income)
                .totalExpense(expense)
                .balance(balance)
                .incomeCount(incomeRepository.count())
                .expenseCount(expenseRepository.count())
                .build();
    }

}
