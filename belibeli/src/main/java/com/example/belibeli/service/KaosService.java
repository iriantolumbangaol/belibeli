package com.example.belibeli.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.belibeli.model.KaosModel;
import com.example.belibeli.repository.KaosRepository;

@Service
@Transactional
public class KaosService {
	
	@Autowired
	private KaosRepository kaosRepository;
	
	public void create(KaosModel kaosModel) {
		this.kaosRepository.save(kaosModel);
	}
	
	public List<KaosModel> readData(){
		return this.kaosRepository.findAll();
	}
	
	public void delete(String id) {
		kaosRepository.deleteById(id);
	}
	
	public KaosModel get(String id) {
		return kaosRepository.findById(id).get();
	}

}
