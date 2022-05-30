package com.example.demo.serrvice;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.dto.InterestRateDto;
import com.example.demo.entity.InterestRate;
import com.example.demo.repository.InterestRepository;
import com.example.demo.service.InterestServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceTest {

	@InjectMocks
	private ModelMapper mapper;
	
	@InjectMocks
	private InterestServiceImpl service;
	@Mock
	private InterestRepository repository;
	
	@Test
	public void saveInterest() {
		InterestRate rate = dummyInterestRates();
		when(repository.save(rate)).thenReturn(rate);
		InterestRate response = service.saveInterest(rate);
		assertNotNull(response);
		assertEquals(response, rate);
		
	}
	
	@Test
	public void updateInterest() {
		InterestRateDto interestRateDto = new InterestRateDto();
		interestRateDto=dummyInterestRate();
		
		InterestRate rate = new InterestRate();
		rate=mapper.map(interestRateDto,InterestRate.class);
		when(repository.save(rate)).thenReturn(rate);
		InterestRate interestRate = service.updateInterest(rate);
		assertNotNull(interestRate);
		assertEquals(interestRate, rate);
	}
	
	@Test
	public void test_findAll() {
		InterestRate rate = dummyInterestRates();
		List<InterestRate> rateList = new ArrayList<>();
		rateList.add(rate);
		when(repository.findAll()).thenReturn(rateList);
		List<InterestRate> response = service.getAll();
		assertNotNull(response);
		assertEquals(response.size(), rateList.size());
	}
	
	
	@Test
	public void test_deleteInterest() {
		
		InterestRate rate = dummyInterestRates();
		rate.setDelete(true);
		when(repository.save(rate)).thenReturn(rate);
		Object response = service.deleteInterest(rate.getInterestId());
		assertNotNull(response);
		System.out.println(response);
		assertEquals(response,"Given data not exist");
		
		
	}
	
	@Test
	public void test_getById() {
		
		Optional<InterestRate> rate = Optional.of(dummyInterestRates());
		when(repository.findById(1)).thenReturn(rate);
		Object response = service.getById(1);
		assertNotNull(response);
		assertEquals(response, rate);
	}
	
	private InterestRateDto dummyInterestRate() {
		InterestRateDto interestRateDto = new InterestRateDto();
		interestRateDto.setInterestId(1);
		interestRateDto.setDescription("TempInteresECOMINTERESTSILVERCARDtRatesGold description");
		interestRateDto.setName("ECOMINTERESTSILVERCARD1");
		interestRateDto.setRateSpecificationCode("ECOMINTERESTSILVERCARD1");
		interestRateDto.setValidFrom("02-01-2020");
		interestRateDto.setValidTill("04-01-2030");
		interestRateDto.setCurrency("INR");
		return interestRateDto;
	}
	
	private InterestRate dummyInterestRates() {
		InterestRate interestRate = new InterestRate();
		interestRate.setInterestId(1);
		interestRate.setDescription("TempInteresECOMINTERESTSILVERCARDtRatesGold description");
		interestRate.setName("ECOMINTERESTSILVERCARD1");
		interestRate.setRateSpecificationCode("ECOMINTERESTSILVERCARD1");
		interestRate.setValidFrom("02-01-2020");
		interestRate.setValidTill("04-01-2030");
		interestRate.setCurrency("INR");
		return interestRate;
	}
}
