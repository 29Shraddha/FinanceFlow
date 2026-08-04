package com.financeflow.service;

import com.financeflow.dto.BudgetRequestDTO;
import com.financeflow.dto.BudgetResponseDTO;
import com.financeflow.entity.Budget;
import com.financeflow.repository.BudgetRepository;
import org.springframework.stereotype.Service;
import com.financeflow.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    // Add Expense
    public BudgetResponseDTO addBudget(BudgetRequestDTO request) {

        Budget budget = Budget.builder()
                .category(request.getCategory())
                .budgetAmount(request.getBudgetAmount())
                .month(request.getMonth())
                .build();

        Budget savedBudget = budgetRepository.save(budget);

        return BudgetResponseDTO.builder()
                .id(savedBudget.getId())
                .category(savedBudget.getCategory())
                .budgetAmount(savedBudget.getBudgetAmount())
                .month(savedBudget.getMonth())
                .build();
    }

    // Get All Expenses
    public List<BudgetResponseDTO> getAllBudget() {

        return budgetRepository.findAll()
                .stream()
                .map(budget -> BudgetResponseDTO.builder()
                        .id(budget.getId())
                        .category(budget.getCategory())
                        .budgetAmount(budget.getBudgetAmount())
                        .month(budget.getMonth())
                        .build())
                .toList();
    }
    public BudgetResponseDTO getBudgetById(Long id) {

        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        return BudgetResponseDTO.builder()
                .id(budget.getId())
                .category(budget.getCategory())
                .budgetAmount(budget.getBudgetAmount())
                .month(budget.getMonth())
                .build();
    }
    public BudgetResponseDTO updateBudget(Long id, BudgetRequestDTO request){

        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        budget.setCategory(request.getCategory());
        budget.setBudgetAmount(request.getBudgetAmount());
        budget.setMonth(request.getMonth());

        Budget updatedBudget = budgetRepository.save(budget);

        return BudgetResponseDTO.builder()
                .id(updatedBudget.getId())
                .category(budget.getCategory())
                .budgetAmount(budget.getBudgetAmount())
                .month(budget.getMonth())
                .build();
    }
    public void deleteBudget(Long id){

        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        budgetRepository.delete(budget);

    }
}
