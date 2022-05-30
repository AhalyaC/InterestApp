package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @PostMapping("/save-interest")
    public InterestRateDto saveInterest(@RequestBody InterestRateDto interestRate){
        InterestRateDto rate = service.saveInterest(interestRate);
        return rate;
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
    
    @GetMapping("/delete-interest/{interestId}")
    public Object deleteInterest(@PathVariable("interestId") int interestId) {
    	return service.deleteInterest(interestId);
    }
    
    
}