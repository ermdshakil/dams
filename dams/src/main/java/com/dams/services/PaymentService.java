package com.dams.services;

import java.util.List;

import com.dams.dto.PaymentsDto;

public interface PaymentService {
	
    PaymentsDto createPayment(PaymentsDto paymentDto);
    PaymentsDto updatePayment(PaymentsDto paymentDto, Long paymentId);
    int deletePaymentById(Long paymentId);
    List<PaymentsDto> getAllPayments();
    Long countPayment();

}
