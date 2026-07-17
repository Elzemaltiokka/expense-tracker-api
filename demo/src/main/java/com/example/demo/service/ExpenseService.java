package com.example.demo.service;

import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Harcama bulunamadı, id: " + id));
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setBaslik(updatedExpense.getBaslik());
        existingExpense.setMiktar(updatedExpense.getMiktar());
        existingExpense.setKategori(updatedExpense.getKategori());
        existingExpense.setTarih(updatedExpense.getTarih());
        return expenseRepository.save(existingExpense);
    }

    public void deleteExpense(Long id) {
        getExpenseById(id); // kayıt yoksa burada RuntimeException fırlar
        expenseRepository.deleteById(id);
    }
}
