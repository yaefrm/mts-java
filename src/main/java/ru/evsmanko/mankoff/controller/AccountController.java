package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.dto.TransferDto;
import ru.evsmanko.mankoff.dto.PaymentDto;
import ru.evsmanko.mankoff.entity.UserEntity;
import ru.evsmanko.mankoff.repository.UserEntityRepository;
import org.springframework.web.bind.annotation.PostMapping;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.BalanceService;
import ru.evsmanko.mankoff.service.TransferService;
import ru.evsmanko.mankoff.service.PaymentService;
import ru.evsmanko.mankoff.utils.FormattingUtils;

@Controller
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    BalanceService balanceService;

    @Autowired
    FormattingUtils formattingUtils;

    @Autowired
    UserEntityRepository userEntityRepository;

    private final UserRepository userRepository;
    private final TransferService transferService;



    private final PaymentService paymentService;


    @GetMapping("/user")
    public String userInfo(Model model) {
        val users =  userRepository.findAll();
        model.addAttribute("users", users);
        return "userInf";
    }

    @GetMapping("/transfers")
    public String transferInfo(Model model) {
        val transferEntities = transferService.findAll();
        model.addAttribute("transferEntities", transferEntities);
        return "transfers";
    }

    @GetMapping("/transfers/{id}")
    public String transferInfoBySenderId(@PathVariable Long id, Model model) {
        val transferEntities = transferService.findAllByIdSender(id);
        model.addAttribute("transferEntities", transferEntities);
        return "transfersById";
    }

    @GetMapping("/transfer-create")
    public String createTransferForm(Model model) {
        model.addAttribute("transfer", new TransferDto());
        return "transferCreate";
    }

    @PostMapping(
            path = "/transfer-create",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String transferAdd(TransferDto transfer, Model model) {
        transferService.save(transfer);
        return "redirect:/transfers";
    }

    @GetMapping("/user/{id}")
    public String userById(@PathVariable long id, Model model) {
        UserEntity userEntity = userEntityRepository.getUserEntityById(id);

        if (userEntity == null)
            return "user_not_found";

        model.addAttribute("userEntity", userEntity);
        return "user";
    }

    @PostMapping("/user")
    public String saveUserById(@RequestBody UserEntity userEntity, Model model) {
        model.addAttribute("userEntity", userEntityRepository.save(userEntity));
        return "user";
    }

    @GetMapping("/balans")
    public String balances(Model model)
    {
        model.addAttribute("data", balanceService.usersBalances());
        model.addAttribute("formatter", formattingUtils);
        return "balances";
    }

    @GetMapping("/payment/new")
    public String newPayment(Model model) {
        model.addAttribute("payment", new PaymentDto());
        return "new";
    }

    @PostMapping("/payment/new")
    public String create(@ModelAttribute("payment") PaymentDto payment) {
        paymentService.save(payment);
        return "new";
    }

    @GetMapping("/user/payments/{userId}")
    public String userPayments(@PathVariable long userId, Model model) {
        model.addAttribute("userPayments", paymentService.findPaymentsByBuyerId(userId));
        return "payments";
    }
}
