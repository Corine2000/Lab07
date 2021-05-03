package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutages;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
			List<Nerc> List = new ArrayList<>(dao.getNercList());
			System.out.println(List) ;
			System.out.println(List.size()) ;
			
			ArrayList<PowerOutages> powerOutages = new ArrayList<>(dao.getAllPowerOutages());
			System.out.println(powerOutages.size());
			
			StringBuilder sb = new StringBuilder(); 
			/*for(PowerOutages p: powerOutages) {
				sb.append(String.format("%7d","%10d", "%20G", "%20G\n", p.getId(),p.getCustomers_affected(),p.getDataInizio(),p.getDataFine()));
			}*/
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}

}
