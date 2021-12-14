package com.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarController {

	@Autowired
	CarRepository carrepo;
	
	@RequestMapping(value = "getByBrand")
	public String getBrand (Model model) 
	{
		List<String> car = carrepo.findBrands();
		System.out.println(car);
		model.addAttribute("cars",car);
		return "searchByBrand";
	}
	
	@RequestMapping(value = "getByPrice")
	public String getPrice() 
	{
		return "searchByPrice";
	}
	
	@RequestMapping(value = "/searchByBrand", method = RequestMethod.POST)
	public String searchByBrand(@RequestParam("bname") String bname, Model model) 
	{
		String space=" ";
		bname = bname.replaceFirst(",", "");
		System.out.println(bname);
		List<Car> car = carrepo.findCarsByBrand(bname);
		model.addAttribute("cars",car);
		model.addAttribute("space",space);
		return "buyCar";
	}
	
	@RequestMapping(value = "/searchByPrice", method = RequestMethod.POST)
	public String searchByPrice(@RequestParam("price") String price, Model model) 
	{
		List<Car> car;
		String space=" ";
		if(price.equals("ltf")) 
		{
			car = carrepo.findCarsBelowFive(500000);
		}
		else 
		{
			car = carrepo.findCarsAboveFive(500000);
		}
		model.addAttribute("cars",car);
		model.addAttribute("space",space);
		return "buyCar";
	}
	
	@RequestMapping(value = "/buyCar", method = RequestMethod.POST)
	public String buyCar(@RequestParam("buy") String buy, Model model) 
	{
		model.addAttribute("buy",buy);
		return "success";
	}
}
