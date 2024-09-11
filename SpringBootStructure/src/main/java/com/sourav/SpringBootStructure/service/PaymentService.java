package com.sourav.SpringBootStructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.SpringBootStructure.dto.PaymentRequest;
import com.sourav.SpringBootStructure.dto.PaymentResponse;
import com.sourav.SpringBootStructure.entity.PaymentEntity;
import com.sourav.SpringBootStructure.repository.PaymentRespository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRespository paymentRespository;
	
	public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObject) {
		PaymentEntity paymentEntity = paymentRespository.getPaymentById(internalRequestObject);
		
		//map it to response obj
		PaymentResponse paymentResponse = mapModelToResponseDTO(paymentEntity);
		return paymentResponse;
	}
	
	private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaymentId(paymentEntity.getId());
		paymentResponse.setAmount(paymentEntity.getPaymentAmount());
		paymentResponse.setCurrency(paymentEntity.getPaymentCurrency());
		return paymentResponse;
	}

}
