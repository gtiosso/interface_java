package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
			
		CarRental carRental = new CarRental(start, finish, new Vehicle(model));
	
		System.out.print("Enter price per Hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per Day: ");
		double pricePerDay = sc.nextDouble();
		
		// Declaro explicitamente o tipo de serviço de imposto que será utilizado
		// Como BrazilTaxService se trata de um subtipo da Interface TaxService, é realizado um UPCASTING,
		// pois no serviço de locação de carros está definido o tipo de objeto TaxService
		// Ou seja, está realizando uma "Injeção de Dependência" por meio de construtor
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println();
		System.out.println("INVOICE:");
		System.out.println("Basic Payment: " + String.format("%.2f", carRental.getInvoice().getbasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
