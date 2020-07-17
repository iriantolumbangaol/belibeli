package com.example.belibeli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.belibeli.model.AccesoriesModel;
import com.example.belibeli.repository.AccesoriesRepository;

@Service
@Transactional
public class AccesoriesService {
	
	@Autowired
	private AccesoriesRepository accesoriesRepository;
	
	public void create(AccesoriesModel accesoriesModel) {
		this.accesoriesRepository.save(accesoriesModel);
	}
	
	public List<AccesoriesModel> readData(){
		return this.accesoriesRepository.findAll();
	}
	
	public void delete(int id) {
		accesoriesRepository.deleteById(id);
	}
	
	public AccesoriesModel get(int id) {
		return accesoriesRepository.findById(id).get();
	}

}
