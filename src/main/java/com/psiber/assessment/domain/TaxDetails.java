package com.psiber.assessment.domain;

public class TaxDetails {
	
	TaxDetails( ) {
		
	}
	
	private String taxYear;
	private String age;
	private String monthlyEarnings;
	private String annualEarnings;
	private String medicalMain;
	
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
	public String getMedicalMain() {
		return medicalMain;
	}
	public void setMedicalMain(String medicalMain) {
		this.medicalMain = medicalMain;
	}
	
	

}
