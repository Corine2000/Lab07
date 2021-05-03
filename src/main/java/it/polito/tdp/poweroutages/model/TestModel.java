package it.polito.tdp.poweroutages.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		List<Nerc> tuttiNerc = model.getNercList();
		System.out.println(tuttiNerc);
        
		Nerc nerc = tuttiNerc.get(3);
		List<PowerOutages> soluzione = model.risolvi(nerc, 4, 1000);
		  System.out.println(soluzione.size());
		
		for(PowerOutages p: soluzione)
		  System.out.println(p.toString());
	}

}
