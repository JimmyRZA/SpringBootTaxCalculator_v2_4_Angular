package com.psiber.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.psiber.assessment.domain.CalculatedPaye;
import com.psiber.assessment.domain.TaxDetails;

/**
 * @author Jimmy Mhlanga
 *
 */
@RestController
public class PsiberAssessmentController {

	@Autowired
	private CalculatedPaye calculatedPaye;

	private float _annualEarnings;
	private float calculatedmonthlyTax;
	private float calculatedAnnualTax;
	private float calculatedTaxCredits;
	private float payeDue;
	private float nettCash;
	private int age;
	private float lessTaxableInc;
	private int taxYear;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addTaxDetails")
	public ResponseEntity<CalculatedPaye> getCalculatedPAYE(@RequestBody TaxDetails taxdetails) {

		calculatedPaye = new CalculatedPaye();
		
		_annualEarnings = taxdetails.getMonthlyEarnings() != null
				? Float.parseFloat(taxdetails.getMonthlyEarnings()) * 12
				: Float.parseFloat(taxdetails.getAnnualEarnings());

		age = Integer.parseInt(taxdetails.getAge());

		taxYear = Integer.parseInt(taxdetails.getTaxYear());

		if (taxYear == 2021) {
			if (_annualEarnings >= 0 && _annualEarnings <= 205900) {
				calculatedmonthlyTax = (float) (_annualEarnings * 0.18);

				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);

				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);

				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 205901 && _annualEarnings <= 321600) {
				lessTaxableInc = _annualEarnings - 205900;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.26, 37062, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 321601 && _annualEarnings <= 445100) {
				lessTaxableInc = _annualEarnings - 321600;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.31, 67144, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 445101 && _annualEarnings <= 584200) {
				lessTaxableInc = _annualEarnings - 445100;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.36, 105429, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 584201 && _annualEarnings <= 744800) {
				lessTaxableInc = _annualEarnings - 584200;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.39, 155505, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 744801 && _annualEarnings <= 1577300) {
				lessTaxableInc = _annualEarnings - 744800;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.41, 218139, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 1577301) {
				lessTaxableInc = _annualEarnings - 157300;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.45, 559464, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			}
		} else if (taxYear == 2020) {
			if (_annualEarnings >= 0 && _annualEarnings <= 195850) {
				calculatedmonthlyTax = (float) (_annualEarnings * 0.18);

				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);

				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);

				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 195851 && _annualEarnings <= 305850) {
				lessTaxableInc = _annualEarnings - 195850;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.26, 37062, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 305851 && _annualEarnings <= 423300) {
				lessTaxableInc = _annualEarnings - 305850;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.31, 67144, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 423301 && _annualEarnings <= 555600) {
				lessTaxableInc = _annualEarnings - 423300;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.36, 105429, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 555601 && _annualEarnings <= 708310) {
				lessTaxableInc = _annualEarnings - 555600;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.39, 155505, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 708311 && _annualEarnings <= 1500000) {
				lessTaxableInc = _annualEarnings - 708310;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.41, 218139, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());

			} else if (_annualEarnings >= 1500001) {
				lessTaxableInc = _annualEarnings - 157300;
				calculatedmonthlyTax = calculateMonthlyTax(lessTaxableInc, (float) 0.45, 559464, age, taxYear);
				calculatedPaye.setMonthlyTax(calculatedmonthlyTax);
				calculatedPaye.setAnnualTax(calculatedmonthlyTax * 12);
				calculatedPaye.setTaxCredits(319);

				calculatedPaye.setPayeDue(calculatedPaye.getAnnualTax() - calculatedPaye.getTaxCredits());

				calculatedPaye.setNetCash((Float.parseFloat(taxdetails.getMonthlyEarnings()) / 160) - calculatedPaye.getPayeDue());
			}
		}
		return new ResponseEntity<CalculatedPaye>(calculatedPaye, HttpStatus.OK);

	}

	public float calculateMonthlyTax(float annualDiff, float percentage, float taxableAmount, int age, int year) {
		if(year == 2021)
			return ((((annualDiff * percentage) + taxableAmount)) - get2021TaxRabates(age)) / 12;
		return ((((annualDiff * percentage) + taxableAmount)) - get2020TaxRabates(age)) / 12;
	}

	public float get2021TaxRabates(int age) {
		float taxRate = (float) 0.0;
		if (age < 65)
			taxRate = 14958;
		else if (age >= 65 && age <= 75) {
			taxRate = 14958 + 8199;
		} else if (age >= 75)
			taxRate = 14958;
		return taxRate;
	}
	
	public float get2020TaxRabates(int age) {
		float taxRate = (float) 0.0;
		if (age < 65)
			taxRate = 14220;
		else if (age >= 65 && age <= 75) {
			taxRate = 14220 + 7794;
		} else if (age >= 75)
			taxRate = 14220 + 2601;
		return taxRate;
	}
}