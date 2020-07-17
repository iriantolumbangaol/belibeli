package com.example.belibeli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.belibeli.model.AccesoriesModel;
import com.example.belibeli.service.AccesoriesService;

@RestController
@RequestMapping(value="/api/accesories")
public class AccesoriesApi {
	
	@Autowired
	private AccesoriesService accesoriesService;
	
	@GetMapping("/get")
	public List<AccesoriesModel> getMapping(){
		List<AccesoriesModel> listAccesories = accesoriesService.readData();
		
		return listAccesories;
	}
	
	@PostMapping("/post")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String, Object> postMapping(@RequestBody AccesoriesModel accesoriesModel){
		
		this.accesoriesService.create(accesoriesModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Message", "Added Successfully");
		
		return map;
	}
	
	@PutMapping("/put")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> putMapping(@RequestBody AccesoriesModel accesoriesModel){
		
		this.accesoriesService.create(accesoriesModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Message", "Updated Succesfully");
		
		return map;
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable Integer id){
		
		this.accesoriesService.delete(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Message", "Deleted Successfully");
		
		return map;
	}
}
