package com.financeflow.service;

import com.financeflow.dto.IncomeRequestDTO;
import com.financeflow.dto.IncomeResponseDTO;
import com.financeflow.entity.Income;
import com.financeflow.repository.IncomeRepository;
import org.springframework.stereotype.Service;
import com.financeflow.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    // Add Expense
    public IncomeResponseDTO addIncome(IncomeRequestDTO request) {

        Income income = Income.builder()
                .source(request.getSource())
                .amount(request.getAmount())
                .incomeDate(request.getIncomeDate())
                .description(request.getDescription())
                .build();

        Income savedIncome =incomeRepository.save(income);

        return IncomeResponseDTO.builder()
                .id(savedIncome.getId())
                .source(savedIncome.getSource())
                .amount(savedIncome.getAmount())
                .incomeDate(savedIncome.getIncomeDate())
                .description(savedIncome.getDescription())
                .build();
    }

    // Get All Expenses
    public List<IncomeResponseDTO> getAllIncome() {

        return incomeRepository.findAll()
                .stream()
                .map(income -> IncomeResponseDTO.builder()
                        .id(income.getId())
                        .source(income.getSource())
                        .amount(income.getAmount())
                        .incomeDate(income.getIncomeDate())
                        .description(income.getDescription())
                        .build())
                .toList();
    }
    public IncomeResponseDTO getIncomeById(Long id) {

        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found"));

        return IncomeResponseDTO.builder()
                .id(income.getId())
                .source(income.getSource())
                .amount(income.getAmount())
                .incomeDate(income.getIncomeDate())
                .description(income.getDescription())
                .build();
    }
    public IncomeResponseDTO updateIncome(Long id, IncomeRequestDTO request){

        Income income= incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found"));

        income.setSource(request.getSource());
        income.setAmount(request.getAmount());
        income.setIncomeDate(request.getIncomeDate());
        income.setDescription(request.getDescription());

        Income updatedIncome = incomeRepository.save(income);

        return IncomeResponseDTO.builder()
                .id(updatedIncome.getId())
                .source(updatedIncome.getSource())
                .amount(updatedIncome.getAmount())
                .incomeDate(updatedIncome.getIncomeDate())
                .description(updatedIncome.getDescription())
                .build();
    }
    public void deleteIncome(Long id){

        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found"));

        incomeRepository.delete(income);

    }
}

