package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.BalanceService;
import ru.evsmanko.mankoff.utils.FormattingUtils;

@Controller
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    BalanceService balanceService;

    @Autowired
    FormattingUtils formattingUtils;

    private final UserRepository userRepository;
    @GetMapping("/user")
    public String userInfo(Model model) {
        val users =  userRepository.findAll();
        model.addAttribute("users", users);
        return "userInf";
    }

    @GetMapping("/balans")
    public String balances(Model model)
    {
        model.addAttribute("data", balanceService.usersBalances());
        model.addAttribute("formatter", formattingUtils);
        return "balances";
    }
}
