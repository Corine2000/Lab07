package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	List<PowerOutages> powerOutages;
	List<PowerOutages> soluzioneMigliore;
	private int CustomerMax;
	
	public Model() {
		podao = new PowerOutageDAO();
		powerOutages = podao.getAllPowerOutages();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}

	public List<PowerOutages> risolvi(Nerc nerc, int X, int Y){
		soluzioneMigliore = new ArrayList<>();
		CustomerMax = 0;
		List<PowerOutages> parziale = new ArrayList<>();
		
       cerca(parziale, nerc, X, Y, 0);
       
		return soluzioneMigliore;
	}
	
	private boolean cerca(List<PowerOutages> parziale, Nerc nerc, int x, int y, int livello) {
		//casi terminali
		if(livello==powerOutages.size()) //se abbiamo esplorato tutti i blackout e non abbiamo trovato soluzioni
			return false;
		
		int differenzaAnni = (int) diffAnni( parziale);
		int totOre = (int) SommaOre(parziale);
		int totClienti = TotCustomers(parziale);
		
		if(differenzaAnni > x)
			return false;
		
		if(totOre > y)
			return false;
		
		if(totClienti > CustomerMax) {
			CustomerMax = totClienti;
			soluzioneMigliore = new ArrayList<>(parziale);
			
			return true;
		}
		
		// parziale.add(powerOutages.get(livello));
		//  cerca(parziale, nerc, x, y, livello+1);
		 
		// parziale.remove(powerOutages.get(livello));
		 //  cerca(parziale, nerc, x, y, livello+1);
		 
			for(int i=0; i<powerOutages.size(); i++) {
				PowerOutages p = powerOutages.get(i);
				   if(p.getNerc_id()==nerc.getId()) { //prendo tutti i powerOutages che hanno lo stesso nerc inserito dall'utente
				      if(!parziale.contains(p)) {
					     parziale.add(p);
					
					  cerca(parziale, nerc, x, y, livello+1);
					   //if(trovato)
						  // return true;
					    parziale.remove(p);
				}
			}
		} 
			return false;
	}

	/*
	 * questa funzione mi restituisce la differenza di anni tra l'ultimo e il primo
	 * elemento della lista
	 */
	public long diffAnni(List<PowerOutages> parziale) { 
		long diff=0;
		if(parziale.size()>0) {
			LocalDateTime data1= parziale.get(0).getDataInizio();
			LocalDateTime data2= parziale.get(parziale.size()-1).getDataInizio();
			diff = ChronoUnit.YEARS.between(data1, data2) + 1;
		}
		return diff;
	}
	
	public long SommaOre(List<PowerOutages> parziale) {
		long totale =0;
		
		if(parziale.size()>0) {
			for(PowerOutages p: parziale) {
				LocalDateTime data1 = p.getDataInizio();
				LocalDateTime data2 = p.getDataFine();
				long diff = Duration.between(data1, data2).getSeconds(); //mi da la differenza in secondi delle 2 date
				
				totale+=diff;
			}
		}
		return totale/3600;
		
	}
	
	public int TotCustomers(List<PowerOutages> parziale) {
		int tot=0;
		if(parziale.size()>0) {
			for(PowerOutages p: parziale) {
				tot+= p.getCustomers_affected();
			 }
		}
		
		return tot;
	}
}
