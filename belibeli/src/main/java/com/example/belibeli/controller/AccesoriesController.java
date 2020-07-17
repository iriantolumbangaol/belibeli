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

import com.example.belibeli.model.AccesoriesModel;
import com.example.belibeli.service.AccesoriesService;

@Controller
@RequestMapping("/accesories")
public class AccesoriesController {

	@Autowired
	AccesoriesService accesoriesService;

	@RequestMapping("/")
	public String viewAccesories(Model model) {
		List<AccesoriesModel> listAccesories = accesoriesService.readData();
		model.addAttribute("listAccesories", listAccesories);
		return "accesories/accesories";
	}

	@RequestMapping("/insert")
	public String accesoriesInsert() {
		String insert = "accesories/insertAccesories";
		return insert;
	}

	@RequestMapping("/save")
	public String accesoriesSave(HttpServletRequest request, Model model) throws ParseException {

		String categories = request.getParameter("categories");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");

		String date = request.getParameter("date");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = formatDate.parse(date);
		System.out.println(tanggalLahir);

		AccesoriesModel accesoriesModel = new AccesoriesModel();

		accesoriesModel.setCategories(categories);
		accesoriesModel.setName(name);
		accesoriesModel.setQuantity(quantity);
		accesoriesModel.setPrice(price);
		accesoriesModel.setDescription(description);
		accesoriesModel.setDate(tanggalLahir);

		this.accesoriesService.create(accesoriesModel);

		this.viewAccesories(model);

		return "redirect:/accesories/";

	}

	@RequestMapping("/edit/save")
	public String accesoriesEditSave(HttpServletRequest request, Model model) throws ParseException {

		int id = Integer.parseInt(request.getParameter("id"));
		String categories = request.getParameter("categories");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");

		String date = request.getParameter("date");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = formatDate.parse(date);
		System.out.println(tanggalLahir);

		AccesoriesModel accesoriesModel = new AccesoriesModel();

		accesoriesModel.setId(id);
		accesoriesModel.setCategories(categories);
		accesoriesModel.setName(name);
		accesoriesModel.setQuantity(quantity);
		accesoriesModel.setPrice(price);
		accesoriesModel.setDescription(description);
		accesoriesModel.setDate(tanggalLahir);

		this.accesoriesService.create(accesoriesModel);

		this.viewAccesories(model);

		return "redirect:/accesories/";

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable int id, Model model) {
		model.addAttribute("accesoriesModel", accesoriesService.get(id));
		return "accesories/editAccesories";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		accesoriesService.delete(id);
		return "redirect:/accesories/";
	}

}
