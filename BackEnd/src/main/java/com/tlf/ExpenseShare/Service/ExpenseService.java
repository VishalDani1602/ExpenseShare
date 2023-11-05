package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Model.Expense;
import com.tlf.ExpenseShare.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(@RequestBody Expense expense) {
//        System.out.println(expense.getDescription());
        return expenseRepository.save(expense);
    }
}
