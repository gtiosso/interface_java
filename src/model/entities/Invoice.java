// Entidade Fatura
// Declaro todos os atributos da entidade fatura
// Crio o metodo para gerar o total da fatura

package model.entities;

public class Invoice {
	
	private Double basicPayment;
	private Double tax;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getbasicPayment() {
		return basicPayment;
	}
	
	public void setbasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return getbasicPayment() + getTax();
	}
}
