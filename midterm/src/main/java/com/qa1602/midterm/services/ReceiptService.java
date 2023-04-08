package com.qa1602.midterm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa1602.midterm.model.Receipt;
import com.qa1602.midterm.repository.ReceiptRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    public Receipt addReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }
}
