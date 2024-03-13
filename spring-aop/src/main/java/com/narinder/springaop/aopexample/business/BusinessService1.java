package com.narinder.springaop.aopexample.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narinder.springaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	
	@Autowired
	private DataService1 dataService;
	
	public int calculateMax() {
		int[] data = dataService.retrieveData();
		//throw new RuntimeException("Something went wrong!");
		return Arrays.stream(data).max().orElse(0);
	}

}
