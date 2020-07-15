package com.example.belibeli.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.belibeli.model.SepatuModel;
import com.example.belibeli.service.SepatuService;

@Controller
@RequestMapping("/sepatu")
public class SepatuController {
	
	@Autowired
	SepatuService sepatuService;
	
	@RequestMapping("/")
	public String viewSepatu(Model model) {
		List<SepatuModel> listSepatu = sepatuService.readData();
		model.addAttribute("listSepatu", listSepatu);
		return "sepatu/sepatu";
	}
	
	@RequestMapping("/insert")
	public String sepatuInsert(){
		String insert = "sepatu/insertSepatu";
		return insert;
	}
	
	@RequestMapping("/save")
	public String sepatuSave(HttpServletRequest request, Model model) throws ParseException {
	
		String id = request.getParameter("id");
		String merk = request.getParameter("merk");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		String date = request.getParameter("date");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = formatDate.parse(date);
		System.out.println(tanggalLahir);
		
		SepatuModel sepatuModel = new SepatuModel();
		
		sepatuModel.setId(id);
		sepatuModel.setMerk(merk);
		sepatuModel.setName(name);
		sepatuModel.setQuantity(quantity);
		sepatuModel.setPrice(price);
		sepatuModel.setDate(tanggalLahir);
		sepatuModel.setDescription(description);
		
		this.sepatuService.create(sepatuModel);
		
		this.viewSepatu(model);
		
		String html = "sepatu/sepatu";
		
		return html;
	
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable String id, Model model) {
		model.addAttribute("sepatuModel", sepatuService.get(id));
		return "sepatu/editSepatu";
	
	// public ModelAndView editSepatu(@PathVariable(name = "id")String id) {
		//ModelAndView mav = new ModelAndView("sepatu/editSepatu");
		//SepatuModel sepatuModel = sepatuService.get(id);
		//mav.addObject("sepatuModel", sepatuModel);
		
		//return mav;
		
	}
	
	@RequestMapping("/delete/{id}")
		public String deleteSepatu(@PathVariable(name = "id") String id) {	
			sepatuService.delete(id);
			return "redirect:/sepatu/";
	}

}
