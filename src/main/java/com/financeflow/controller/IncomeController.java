
    package com.financeflow.controller;

import com.financeflow.dto.IncomeRequestDTO;
import com.financeflow.dto.IncomeResponseDTO;
import com.financeflow.service.IncomeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/income")
    public class IncomeController {

        private final IncomeService incomeService;

        public IncomeController(IncomeService incomeService) {
            this.incomeService = incomeService;
        }

        @PostMapping
        public IncomeResponseDTO addIncome(@Valid @RequestBody IncomeRequestDTO request) {
            return incomeService.addIncome(request);
        }

        @GetMapping
        public List<IncomeResponseDTO> getAllIncome() {
            return incomeService.getAllIncome();
        }
        @GetMapping("/{id}")
        public IncomeResponseDTO getIncomeById(@PathVariable Long id) {
            return incomeService.getIncomeById(id);
        }
        @PutMapping("/{id}")
        public IncomeResponseDTO updateIncome(
                @PathVariable Long id,
                @Valid @RequestBody IncomeRequestDTO request){

            return incomeService.updateIncome(id, request);

        }
        @DeleteMapping("/{id}")
        public String deleteIncome(@PathVariable Long id){

            incomeService.deleteIncome(id);

            return "Income deleted successfully";
        }
    }


