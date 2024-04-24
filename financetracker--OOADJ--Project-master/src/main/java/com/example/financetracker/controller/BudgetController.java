//Single Responsibility, Open Close, Builder
package com.example.financetracker.controller;

import com.example.financetracker.model.Budget;
import com.example.financetracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public String showBudgetPage(Model model) {
        model.addAttribute("budgets", budgetService.findAllBudgets());
        return "budget";
    }

    @PostMapping("/add")
    public String addBudget(Budget budget) {
        budgetService.addBudget(budget);
        return "redirect:/budget";
    }
}

