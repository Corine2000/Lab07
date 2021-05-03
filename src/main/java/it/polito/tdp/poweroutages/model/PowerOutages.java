package it.polito.tdp.poweroutages.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PowerOutages {
	private int id;
	private int event_type_id;
	private int tag_id;
	private int area_id;
	private int nerc_id;
	private int responsible_id;
	private int customers_affected;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private int demand_loss;
	
	public PowerOutages(int id, int event_type_id, int tag_id, int area_id, int nerc_id, int responsible_id,
			int customers_affected, LocalDateTime dataInizio, LocalDateTime dataFine, int demand_loss) {
		super();
		this.id = id;
		this.event_type_id = event_type_id;
		this.tag_id = tag_id;
		this.area_id = area_id;
		this.nerc_id = nerc_id;
		this.responsible_id = responsible_id;
		this.customers_affected = customers_affected;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.demand_loss = demand_loss;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public int getNerc_id() {
		return nerc_id;
	}

	public void setNerc_id(int nerc_id) {
		this.nerc_id = nerc_id;
	}

	public int getResponsible_id() {
		return responsible_id;
	}

	public void setResponsible_id(int responsible_id) {
		this.responsible_id = responsible_id;
	}

	public int getCustomers_affected() {
		return customers_affected;
	}

	public void setCustomers_affected(int customers_affected) {
		this.customers_affected = customers_affected;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public int getDemand_loss() {
		return demand_loss;
	}

	public void setDemand_loss(int demand_loss) {
		this.demand_loss = demand_loss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutages other = (PowerOutages) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString() {
		return this.id+" "+this.dataInizio+" "+this.dataFine +" "+this.customers_affected+" "+this.nerc_id;
	}

}
