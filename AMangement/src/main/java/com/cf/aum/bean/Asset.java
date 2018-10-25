package com.cf.aum.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASSETS", schema = "AUM")
public class Asset implements Serializable {
	private static final long serialVersionUID = 8939841469766782137L;
	@Id
	@GeneratedValue(generator = "idSequence")
	@SequenceGenerator(schema = "AUM", name = "idSequence", sequenceName = "asset_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	@Column(name = "YEAR")
	private Long year;
	@Column(name = "AMOUNT")
	private Long amount;
	@Column(name = "DESCRETIONARY")
	private Long discretionary;

	public Asset() {

	}

	public Asset(Long id, Long year, Long amount, Long discretionary) {
		super();
		this.id = id;
		this.year = year;
		this.amount = amount;
		this.discretionary = discretionary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getDiscretionary() {
		return discretionary;
	}

	public void setDiscretionary(Long discretionary) {
		this.discretionary = discretionary;
	}

}
