package com.financeflow.repository;

import com.financeflow.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT COALESCE(SUM(e.amount),0) FROM Expense e")
    BigDecimal getTotalExpense();
}