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

import com.example.belibeli.model.KaosModel;
import com.example.belibeli.service.KaosService;

@RestController
@RequestMapping(value="/api/kaos")
public class KaosApi {
	
	@Autowired
	private KaosService kaosService;
	
	@GetMapping("/get")
	public List<KaosModel> getMapping(){
		List<KaosModel> listKaos = kaosService.readData();
		
		return listKaos;
	}
	
	@PostMapping("/post")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String, Object> postMapping(@RequestBody KaosModel kaosModel){
		
		this.kaosService.create(kaosModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Message","Added Succesfully");
		
		return map;
	}
	
	@PutMapping("/put")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> putMapping(@RequestBody KaosModel kaosModel){
		
		this.kaosService.create(kaosModel);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Message", "Updated Successfully");
		
		return map;
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable Integer id){
		
		this.kaosService.delete(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Message", "Deleted Successfully");
		
		return map;
	}
	
	

}
