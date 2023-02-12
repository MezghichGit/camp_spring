package com.sip.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Provider;

import static com.sip.ams.AmsApplication.providers;
@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	
	@GetMapping("/list")
	//@ResponseBody
	public String listProviders(Model model)
	{
		//System.out.println(providers);
		model.addAttribute("providers", providers);
		return "provider/listProviders";
	}
	
	@GetMapping("/add")  // get le formulaire d'ajout
	public String getAddFormProvider()
	{
		return "provider/addProvider";
	}
	
	@PostMapping("/add")  // save provider in list
	//@ResponseBody
	public String saveProvider(@RequestParam("nomprovider")String nom,@RequestParam("email")String email,@RequestParam("adresse")String adresse
			)
	{
		Provider p = new Provider(nom, email, adresse);
		providers.add(p);
		return "redirect:list";
	}

}
