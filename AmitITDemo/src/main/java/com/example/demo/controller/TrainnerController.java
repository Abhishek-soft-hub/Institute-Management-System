package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TrainnerDto;
import com.example.demo.entity.Trainner;
import com.example.demo.service.TrainnerService;

@RestController
public class TrainnerController {
	
	@Autowired
	TrainnerService trainnerService;
	
	@PostMapping("trainner")
	public ResponseEntity<String> trainner(@RequestBody TrainnerDto trainnerDto){
		trainnerService.trainner(trainnerDto);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	@DeleteMapping("trainner/delete/{id}")
	public ResponseEntity<String> deleteTrainner(@PathVariable int id){
		trainnerService.deleteTrainner(id);
		return new ResponseEntity<String>("Trainner are deleted", HttpStatus.OK);
		
	}
	@GetMapping("trainner/{id}")
	public ResponseEntity<Trainner> getTrainner(@PathVariable int id){
		return new ResponseEntity<Trainner>(trainnerService.getTrainner(id), HttpStatus.OK);
		
	}
	
	@GetMapping("trainners")
	 public ResponseEntity<List<Trainner>> trainners(){
		return new ResponseEntity<List<Trainner>>(trainnerService.trainners(), HttpStatus.OK);
		 
	 }

}
