// Serviço de Impostaos Brasileiros (Com Interface)
// -----------------------------------------------------------------------------------------------------------------
// Com a implementação da Interface, o Serviço de Imposto Brasileiro, contem apenas a regra para este tipo de operação
// baseando na implementação da Interface onde são definidos os metodos necessários para esta Classe
// -----------------------------------------------------------------------------------------------------------------
// Declaro o metodo para calcular os impostos para geração da Fatura

package model.services;

public class BrazilTaxService implements TaxService {

	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
