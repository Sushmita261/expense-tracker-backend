package com.expensetracker.expensebackend.service;



import com.expensetracker.expensebackend.model.Expense;
import com.expensetracker.expensebackend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Save a new expense
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
    public Expense updateExpense(Long id, Expense updatedExpense) {
    Expense existing = expenseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

    existing.setTitle(updatedExpense.getTitle());
    existing.setAmount(updatedExpense.getAmount());
    existing.setDate(updatedExpense.getDate());

    return expenseRepository.save(existing);
}

}
