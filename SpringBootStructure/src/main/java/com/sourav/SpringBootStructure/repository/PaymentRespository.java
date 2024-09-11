package com.sourav.SpringBootStructure.repository;

import org.springframework.stereotype.Repository;

import com.sourav.SpringBootStructure.dto.PaymentRequest;
import com.sourav.SpringBootStructure.entity.PaymentEntity;

@Repository
public class PaymentRespository {
	
	public PaymentEntity getPaymentById(PaymentRequest paymentRequest) {
		PaymentEntity paymentEntityModel = executeQuery(paymentRequest);
		return paymentEntityModel;
	}
	
	private PaymentEntity executeQuery(PaymentRequest paymentRequest) {
		//connect with DB and fetch the data
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setId(paymentRequest.getPaymentId());
		paymentEntity.setPaymentAmount(100.00);
		paymentEntity.setPaymentCurrency("INR");
		return paymentEntity;
	}
}
