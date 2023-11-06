package com.tlf.ExpenseShare.Controller;

import com.tlf.ExpenseShare.Model.Expense;
import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Service.ExpenseService;
import com.tlf.ExpenseShare.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@CrossOrigin
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping("/{group_id}")
    public ResponseEntity<List<Expense>> getSpecificExpense(@PathVariable("group_id") int id) {
        return ResponseEntity.ok(expenseService.getSpecificExpense(id));
    }
}
