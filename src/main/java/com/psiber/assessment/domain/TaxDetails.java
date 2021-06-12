package com.psiber.assessment.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxDetails {
	
	TaxDetails( ) {
		
	}
	
	private String taxYear;
	private String age;
	private String monthlyEarnings;
	private String annualEarnings;
	
	String[] memberElements;

	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMonthlyEarnings() {
		return monthlyEarnings;
	}
	public void setMonthlyEarnings(String monthlyEarnings) {
		this.monthlyEarnings = monthlyEarnings;
	}
	public String getAnnualEarnings() {
		return annualEarnings;
	}
	public void setAnnualEarnings(String annualEarnings) {
		this.annualEarnings = annualEarnings;
	}
	public String[] getMemberElements() {
		return memberElements;
	}
	public void setMemberElements(String[] memberElements) {
		this.memberElements = memberElements;
	}
	
	


}
