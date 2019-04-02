// Entidade Veiuculo
// Declaro todos os atributos referente ao veiculo

package model.entities;

public class Vehicle {
	
	private String model;

	public Vehicle(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
