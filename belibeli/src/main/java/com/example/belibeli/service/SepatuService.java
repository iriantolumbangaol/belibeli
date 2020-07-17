package com.example.belibeli.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.belibeli.model.SepatuModel;
import com.example.belibeli.repository.SepatuRepository;

@Service
@Transactional
public class SepatuService {
	
	@Autowired
	private SepatuRepository sepatuRepository;
	
	public void create(SepatuModel sepatuModel) {
		this.sepatuRepository.save(sepatuModel);
	}
	
	public List<SepatuModel> readData(){
		return this.sepatuRepository.findAll();
	}
	
	public void delete(int id) {
		sepatuRepository.deleteById(id);
	}
	
	public SepatuModel get(int id) {
		return sepatuRepository.findById(id).get();
	}

}
