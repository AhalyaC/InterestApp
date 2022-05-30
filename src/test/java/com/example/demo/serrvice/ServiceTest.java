package com.example.demo.serrvice;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

	@Autowired
	private ModelMapper mapper;
	
	@InjectMocks
	private InterestServiceImpl service;
	@Mock
	private InterestRepository repository;
	
	@Test
	public void saveInterest() {
		InterestRateDto dto = dummyInterestRate();
		InterestRate rate = new InterestRate();
		rate=mapper.map(dto,InterestRate.class);
		when(repository.save(rate)).thenReturn(rate);
		InterestRateDto response = service.saveInterest(dto);
		assertNotNull(response);
		assertEquals(response, dto);
		
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
}
