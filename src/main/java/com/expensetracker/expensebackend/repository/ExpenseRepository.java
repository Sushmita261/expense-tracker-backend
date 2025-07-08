package com.expensetracker.expensebackend.repository;



import com.expensetracker.expensebackend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
