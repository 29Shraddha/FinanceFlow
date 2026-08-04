package com.financeflow.repository;

import com.financeflow.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i")
    BigDecimal getTotalIncome();
}
