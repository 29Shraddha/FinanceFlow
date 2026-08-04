package com.financeflow.service;

import com.financeflow.dto.ExpenseRequestDTO;
import com.financeflow.dto.ExpenseResponseDTO;
import com.financeflow.entity.Expense;
import com.financeflow.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.financeflow.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Add Expense
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO request) {

        Expense expense = Expense.builder()
                .title(request.getTitle())
                .amount(request.getAmount())
                .category(request.getCategory())
                .expenseDate(request.getExpenseDate())
                .description(request.getDescription())
                .build();

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseResponseDTO.builder()
                .id(savedExpense.getId())
                .title(savedExpense.getTitle())
                .amount(savedExpense.getAmount())
                .category(savedExpense.getCategory())
                .expenseDate(savedExpense.getExpenseDate())
                .description(savedExpense.getDescription())
                .build();
    }

    // Get All Expenses
    public List<ExpenseResponseDTO> getAllExpenses() {

        return expenseRepository.findAll()
                .stream()
                .map(expense -> ExpenseResponseDTO.builder()
                        .id(expense.getId())
                        .title(expense.getTitle())
                        .amount(expense.getAmount())
                        .category(expense.getCategory())
                        .expenseDate(expense.getExpenseDate())
                        .description(expense.getDescription())
                        .build())
                .toList();
    }
    public ExpenseResponseDTO getExpenseById(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        return ExpenseResponseDTO.builder()
                .id(expense.getId())
                .title(expense.getTitle())
                .amount(expense.getAmount())
                .category(expense.getCategory())
                .expenseDate(expense.getExpenseDate())
                .description(expense.getDescription())
                .build();
    }
    public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO request){

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setDescription(request.getDescription());

        Expense updatedExpense = expenseRepository.save(expense);

        return ExpenseResponseDTO.builder()
                .id(updatedExpense.getId())
                .title(updatedExpense.getTitle())
                .amount(updatedExpense.getAmount())
                .category(updatedExpense.getCategory())
                .expenseDate(updatedExpense.getExpenseDate())
                .description(updatedExpense.getDescription())
                .build();
    }
    public void deleteExpense(Long id){

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        expenseRepository.delete(expense);

    }
}
