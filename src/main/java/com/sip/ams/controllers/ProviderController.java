package com.sip.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String getAddFormProvider(Model model)
	{
		
		model.addAttribute("provider", new Provider());
		return "provider/addProvider";
	}
	
	@PostMapping("/add")  // save provider in list
	//@ResponseBody
	//public String saveProvider(@RequestParam("nomprovider")String nom,@RequestParam("email")String email,@RequestParam("adresse")String adresse
	public String saveProvider(Provider provider)
	{
		providers.add(provider);
		return "redirect:list";
	}
	
	@GetMapping("/details/{id}") 
	public String detailsProvider(Model model, @PathVariable("id") int id)
	{
		
		//model.addAttribute("id", id);
		
		for(Provider provider : providers)
		{
			if(provider.getId() == id)
			{
				model.addAttribute("provider",provider);
				break;
			}
		}
		return "provider/detailsProvider";
	}
	
	@GetMapping("/delete/{id}") 
	public String delete(@PathVariable("id") int id)
	{
		
		for(Provider provider : providers)
		{
			if(provider.getId() == id)
			{
				providers.remove(provider);
				break;
			}
		}
		return "redirect:../list";
	}
	
	
	@GetMapping("/update/{id}") 
	public String updateProvider(Model model, @PathVariable("id") int id)
	{
		
		//model.addAttribute("id", id);
		
		for(Provider provider : providers)
		{
			if(provider.getId() == id)
			{
				model.addAttribute("provider",provider);
				break;
			}
		}
		return "provider/editProvider";
	}
	
	
	@PostMapping("/update") 
	public String updateAndSaveProvider(Provider provider)
	{

		for(Provider pr : providers)
		{
			if(pr.getId() == provider.getId())
			{
				providers.set(providers.indexOf(pr), provider);
				break;
			}
		}
		return "redirect:list";
	}
	
	

}
