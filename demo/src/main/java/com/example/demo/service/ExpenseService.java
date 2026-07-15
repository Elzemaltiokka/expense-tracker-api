package com.example.demo.service;

import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    // Depo görevlimizi çağırıyoruz
    private final ExpenseRepository expenseRepository;

    // Kural 1: Tüm harcamaları listele
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Kural 2: Yeni bir harcama kaydet
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
