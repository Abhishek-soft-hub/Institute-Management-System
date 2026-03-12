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

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batches;
import com.example.demo.service.BatchService;

@RestController
public class BatchController {
	
	@Autowired
	BatchService BatchService;
	
	@PostMapping("batch")
	public ResponseEntity<String> batch(@RequestBody BatchDto batchDto){
		
		BatchService.batch(batchDto);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	@DeleteMapping("batch/delete/{id}")
	public ResponseEntity<String> deleteBatch(@PathVariable int id){
		BatchService.deleteBatch(id);
		return new ResponseEntity<String>("Batch are deleted", HttpStatus.OK);
	}
	
	@GetMapping("batch/{id}")
	public ResponseEntity<Batches> getBatch(@PathVariable int id){
		return new ResponseEntity<Batches>(BatchService.getBatch(id), HttpStatus.OK);
		
	}
	@GetMapping("batches")
	public ResponseEntity<List<Batches>> batches(){
		return new ResponseEntity<List<Batches>>(BatchService.batches() , HttpStatus.OK);
		
	}

}
