package ru.evsmanko.mankoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.evsmanko.mankoff.service.BalanceService;
import ru.evsmanko.mankoff.utils.FormattingUtils;

@Controller
public class AccountController {
    @Autowired
    BalanceService balanceService;

    @Autowired
    FormattingUtils formattingUtils;

    @GetMapping("/user")
    public String userInfo() {
        return "info";
    }
    
    @GetMapping("/balans")
    public String balances(Model model)
    {
        model.addAttribute("data", balanceService.usersBalances());
        model.addAttribute("formatter", formattingUtils);
        return "balances";
    }
}
