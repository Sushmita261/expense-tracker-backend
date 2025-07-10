package com.expensetracker.expensebackend.controller;



import com.expensetracker.expensebackend.model.Expense;
import com.expensetracker.expensebackend.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // GET all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // POST a new expense
    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    // DELETE an expense by ID
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
    @PutMapping("/{id}")
public Expense updateExpense(@PathVariable Long id, @Valid @RequestBody Expense updatedExpense) {
    return expenseService.updateExpense(id, updatedExpense);
}


}

