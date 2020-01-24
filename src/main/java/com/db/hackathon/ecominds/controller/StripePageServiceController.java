/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.db.hackathon.ecominds.model.ChargeRequest;
import com.db.hackathon.ecominds.model.ChargeRequest.Currency;
import com.db.hackathon.ecominds.service.StripePaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class StripePageServiceController {

	@Autowired
    private StripePaymentService paymentService;
	
	@GetMapping("/donate.html")
    public String donate(ModelMap model) {
		model.addAttribute("stripePublicKey", paymentService.getPublicKey());
		model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
		return "donate";
    }
	
    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
      throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.EUR);
        Charge charge = paymentService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }
 
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}