package com.example.belibeli.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.belibeli.model.KaosModel;
import com.example.belibeli.service.KaosService;

@Controller
@RequestMapping("/kaos")
public class KaosController {
	
	@Autowired
	KaosService kaosService;
	
	@RequestMapping("/")
	public String viewKaos(Model model) {
		List<KaosModel> listKaos = kaosService.readData();
		model.addAttribute("listKaos", listKaos);
		return "kaos/kaos";
	}
	
	@RequestMapping("/insert")
	public String kaosInsert(){
		String insert = "kaos/insertKaos";
		return insert;
	}
	
	@RequestMapping("/save")
	public String kaosSave(HttpServletRequest request, Model model) throws ParseException {
	
		
		String name = request.getParameter("name");
		String merk = request.getParameter("merk");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		String date = request.getParameter("date");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = formatDate.parse(date);
		System.out.println(tanggalLahir);
		
		KaosModel kaosModel = new KaosModel(); 
		
		kaosModel.setMerk(merk);
		kaosModel.setName(name);
		kaosModel.setQuantity(quantity);
		kaosModel.setPrice(price);
		kaosModel.setDate(tanggalLahir);
		kaosModel.setDescription(description);
		
		this.kaosService.create(kaosModel);
		
		this.viewKaos(model);
		
		return "redirect:/kaos/";
	
	}
	
	@RequestMapping("/edit/save")
	public String kaosSaveEdit(HttpServletRequest request, Model model) throws ParseException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String merk = request.getParameter("merk");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		String date = request.getParameter("date");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = formatDate.parse(date);
		System.out.println(tanggalLahir);
		
		KaosModel kaosModel = new KaosModel(); 
		
		kaosModel.setId(id);
		kaosModel.setMerk(merk);
		kaosModel.setName(name);
		kaosModel.setQuantity(quantity);
		kaosModel.setPrice(price);
		kaosModel.setDate(tanggalLahir);
		kaosModel.setDescription(description);
		
		this.kaosService.create(kaosModel);
		
		this.viewKaos(model);
		
		return "redirect:/kaos/";
		
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable int id, Model model) {
		model.addAttribute("kaosModel", kaosService.get(id));
		return "kaos/editKaos";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		kaosService.delete(id);;
		return "redirect:/kaos/";
	}
	
	
	

}
