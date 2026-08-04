package com.financeflow.controller;

import com.financeflow.dto.BudgetRequestDTO;
import com.financeflow.dto.BudgetResponseDTO;
import com.financeflow.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public BudgetResponseDTO addBudget(@Valid @RequestBody BudgetRequestDTO request) {
        return budgetService.addBudget(request);
    }

    @GetMapping
    public List<BudgetResponseDTO> getAllBudget() {
        return budgetService.getAllBudget();
    }
    @GetMapping("/{id}")
    public BudgetResponseDTO getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }
    @PutMapping("/{id}")
    public BudgetResponseDTO updateBudget(
            @PathVariable Long id,
            @Valid @RequestBody BudgetRequestDTO request){

        return budgetService.updateBudget(id, request);

    }
    @DeleteMapping("/{id}")
    public String deleteBudget(@PathVariable Long id){

        budgetService.deleteBudget(id);

        return "Budget deleted successfully";
    }
}

