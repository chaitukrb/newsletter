package com.example.newsletter.controller;

import com.example.newsletter.model.Subscription;
import com.example.newsletter.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/sub")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("sub/sortby={var}")
    public List<Subscription> SortBy(@PathVariable(value = "var")
                                                        String var) {
        if(var.equals("id")) {
            return subscriptionRepository.sortById();
        }
        else if(var.equals("name")) {
            return subscriptionRepository.sortByName();
        }
        return subscriptionRepository.findAll();
    }

//    @GetMapping("sub/filter")
//    public List<Subscription> filterSubs(@Valid @RequestBody List<String> subs) {
//        return
//    }

    @GetMapping("/sub/{id}")
    public Optional<Subscription> getSubscriptionById(@PathVariable(value = "id")
                                                        Long subId) {
        return subscriptionRepository.findById(subId);
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @PostMapping("/sub")
    public Subscription createSubscription(@Valid @RequestBody Subscription subscription) {
        return  subscriptionRepository.save(subscription);
    }


}
