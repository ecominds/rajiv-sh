/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.db.hackathon.ecominds.model.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripePaymentService {
	@Value("${stripe.publicApiKey}")
    private String apiPublicKey;
	
	@Value("${stripe.secretApiKey}")
    private String apiSecretKey;
	
	public String getPublicKey() {
		return apiPublicKey;
	}
	
	@PostConstruct
    public void init() {
        Stripe.apiKey = apiSecretKey;
    }
	
    public Charge charge(ChargeRequest chargeRequest) 
      throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        
        Charge charge = Charge.create(chargeParams);
        
        return charge;
    }
}