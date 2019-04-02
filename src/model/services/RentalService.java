// Serviço de Locação (Com Interface)
// -----------------------------------------------------------------------------------------------------------------
// Com a implementação da Interface, o Serviço de Locação não precisa explicitamente saber quais as regras serão 
// aplicadas para definição dos Impostos, com isso caso mude as regras, não haverá qualquer alteração nesta classe
// uma vez que a mesma utiliza uma Interface Genérica
// -----------------------------------------------------------------------------------------------------------------
// Este serviço é composto pelo serviço de Impostos Brasileiro
// Declaro os atributos dos serviços Locação e Impostos Brasileiros
// Crio os metodos para geração da fatura

package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private double pricePerDay;
	private double pricePerHour;
	
	private TaxService taxService;

	// Implementando a "Injeção de Dependência" por meio do construtor
	// Injetando a dependência da Interface de Serviços de Imposto
	public RentalService(double pricePerDay, double pricePerHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicPayment;
		if (hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
	
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

	
	
}
