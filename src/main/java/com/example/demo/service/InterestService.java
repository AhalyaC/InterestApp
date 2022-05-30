package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.InterestRateDto;
import com.example.demo.entity.InterestRate;

@Service
public interface InterestService {
	InterestRate saveInterest(InterestRate interestRate);

	List<InterestRate> getAll();

	InterestRate updateInterest(InterestRate rate);

	Object deleteInterest(int interestId);

	Object getById(int interestID);
}
