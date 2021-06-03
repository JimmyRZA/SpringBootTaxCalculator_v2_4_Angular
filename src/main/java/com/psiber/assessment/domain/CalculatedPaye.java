package com.psiber.assessment.domain;

import org.springframework.stereotype.Component;

@Component
public class CalculatedPaye {
	public CalculatedPaye() {
		
	}
	
	private float monthlyTax;
	private float annualTax;
	private float taxCredits;
	private float payeDue;
	private float netCash;
	public float getMonthlyTax() {
		return monthlyTax;
	}
	public void setMonthlyTax(float monthlyTax) {
		this.monthlyTax = monthlyTax;
	}
	public float getAnnualTax() {
		return annualTax;
	}
	public void setAnnualTax(float annualTax) {
		this.annualTax = annualTax;
	}
	public float getTaxCredits() {
		return taxCredits;
	}
	public void setTaxCredits(float taxCredits) {
		this.taxCredits = taxCredits;
	}
	public float getPayeDue() {
		return payeDue;
	}
	public void setPayeDue(float payeDue) {
		this.payeDue = payeDue;
	}
	public float getNetCash() {
		return netCash;
	}
	public void setNetCash(float netCash) {
		this.netCash = netCash;
	}
	
	
	

}
