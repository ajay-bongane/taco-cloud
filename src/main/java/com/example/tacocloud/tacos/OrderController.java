package com.example.tacocloud.tacos;

import com.example.tacocloud.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if(errors.hasErrors()) return "orderForm";

        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();

        log.info("TacoOrder submitted: " + order);
        return "redirect:/";
    }

}
