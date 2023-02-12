package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fournisseur")
public class ProviderControllerv1 {
	
	@RequestMapping("/info")
	@ResponseBody
	public String info()
	{
		String formation="Spring";
		int nbrHeures = 20;
		System.out.println("Hello BootCamp");
		return "Détails formation : "+formation + " "+nbrHeures;
		
		//return "<h2 align=center>BootCamp</h2>";
		//return "info.html";
	}
	
	@RequestMapping("/data")
	public String data(Model model)
	{   
		String trainer = "Mohamed Amine Mezghich";
	    String adresse = "Tunis";
	    
	    model.addAttribute("trn", trainer);
	    model.addAttribute("adr", adresse );
	    
	    List<String> names = new ArrayList<>();
	    
	    names.add("Aymen");
	    names.add("Haithem");
	    names.add("Hatem");
	    names.add("Dhia");
	    model.addAttribute("names", names);
	    
	    List<Stagiaire> stagiaires = new ArrayList<>();
	    
	    Stagiaire s1 = new Stagiaire("Aymen", 22, "Sfax", 20000000);
	    Stagiaire s2 = new Stagiaire("Haithem", 24, "Tunis", 30000000);
	    Stagiaire s3 = new Stagiaire("Hatem", 23, "Jendouba", 40000000);
	    Stagiaire s4 = new Stagiaire("Dhia", 26, "ElGhazela", 50000000);
	    Class C;
	    stagiaires.add(s1);
	    stagiaires.add(s2);
	    stagiaires.add(s3);
	    stagiaires.add(s4);
	    
	    //System.out.println(stagiaires);
	    model.addAttribute("stagiaires", stagiaires); 
		return "data.html";
	}

}
