package com.financeflow.controller;

import com.financeflow.dto.ExpenseRequestDTO;
import com.financeflow.dto.ExpenseResponseDTO;
import com.financeflow.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ExpenseResponseDTO addExpense(@Valid @RequestBody ExpenseRequestDTO request) {
        return expenseService.addExpense(request);
    }

    @GetMapping
    public List<ExpenseResponseDTO> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public ExpenseResponseDTO getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }
    @PutMapping("/{id}")
    public ExpenseResponseDTO updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequestDTO request){

        return expenseService.updateExpense(id, request);

    }
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id){

        expenseService.deleteExpense(id);

        return "Expense deleted successfully";
    }
}
