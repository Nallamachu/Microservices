package com.cf.firm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FIRM",schema="FIRM")
public class Firm implements Serializable {
	private static final long serialVersionUID = 5265012238210395338L;

	@Id
	@GeneratedValue(generator = "idSequence")
	@SequenceGenerator(schema = "FIRM", name = "idSequence", sequenceName = "firm_seq", allocationSize = 1)
	@Column(name="ID")
	private Long id;
	@Column(name="YEAR")
	private Long Year;
	@Column(name="AMOUNT")
	private Long amount;
	
	public Firm() {
		
	}

	public Firm(Long id, Long year, Long amount) {
		super();
		this.id = id;
		Year = year;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getYear() {
		return Year;
	}

	public void setYear(Long year) {
		Year = year;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
