package com.sourav.SpringBootStructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.SpringBootStructure.dto.PaymentRequest;
import com.sourav.SpringBootStructure.dto.PaymentResponse;
import com.sourav.SpringBootStructure.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id) {

		// map incoming data to internal request DTO
		PaymentRequest internalRequestObject = new PaymentRequest();
		internalRequestObject.setPaymentId(id);

		// pass this internalRequestObject to further layer for processing
		PaymentResponse paymentResponse = paymentService.getPaymentDetailsById(internalRequestObject);

		// return the Response DTO 
		return ResponseEntity.ok(paymentResponse);
	}
}
