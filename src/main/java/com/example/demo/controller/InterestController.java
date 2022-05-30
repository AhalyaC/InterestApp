package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InterestRateDto;
import com.example.demo.entity.InterestRate;
import com.example.demo.service.InterestService;

@RestController
@RequestMapping("/interest")
public class InterestController {

    @Autowired
    private InterestService service;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping("/save-interest")
    public ResponseEntity<InterestRateDto>createIntrestApp1(@RequestBody InterestRateDto interestRateDTO){
    	InterestRate interestRate = modelMapper.map(interestRateDTO, InterestRate.class);
    	InterestRate intrestApp11 = service.saveInterest(interestRate);
    	InterestRateDto intrestApprequest1 = modelMapper.map(interestRate, InterestRateDto.class);
        return new ResponseEntity<InterestRateDto>(intrestApprequest1, HttpStatus.CREATED);
    }
    
    @GetMapping("/get-all")
    public List<InterestRate> getAllRate(){
    	return service.getAll();
    }
    
    @PostMapping("/update-interest/{interestId}")
    public InterestRate updateInterestRate(@PathVariable("interestId") int intersestId,@RequestBody InterestRate rate) {
		rate.setInterestId(intersestId);
    	return service.updateInterest(rate);
    	
    }
    
    @GetMapping("/get-interest-byid/{id}")
    public Object getInterestById(@PathVariable("id") int interestID) {
    	return service.getById(interestID);
    }
    
    @GetMapping("/delete-interest/{interestId}")
    public Object deleteInterest(@PathVariable("interestId") int interestId) {
    	return service.deleteInterest(interestId);
    }
    
    
}