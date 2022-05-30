package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InterestRateDto;
import com.example.demo.entity.InterestRate;
import com.example.demo.repository.InterestRepository;

@Service
public class InterestServiceImpl implements InterestService{

	@Autowired
	private InterestRepository interestRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public InterestRate saveInterest(InterestRate interestRate) {
		return interestRepository.save(interestRate);
	}

	@Override
	public List<InterestRate> getAll() {

		return interestRepository.findAll();
	}

	@Override
	public InterestRate updateInterest(InterestRate rate) {
		return interestRepository.save(rate);
	}

	@Override
	public Object deleteInterest(int interestId) {
		InterestRate rate = new InterestRate();
		if(0!=interestId) {
			try {
				rate=interestRepository.findById(interestId).get();
			}catch (Exception e) {
				return "Given data not exist";
			}
			rate.setDelete(true);
			interestRepository.save(rate);
		}
		return "Given data is deleted successfully";
	}

	@Override
	public Object getById(int interestID) {
		Optional<InterestRate> rate = interestRepository.findById(interestID);
		try {
			return rate;
		}catch (Exception e) {
			return "Given data not exist";
		}
	}
}
