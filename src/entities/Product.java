package entities;

public class Product {

	private String name;
	private String value;
	private String quantiti;

	public Product(String name, String value, String quantiti) {
		super();
		this.name = name;
		this.value = value;
		this.quantiti = quantiti;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getQuantiti() {
		return quantiti;
	}

	public void setQuantiti(String quantiti) {
		this.quantiti = quantiti;
	}

	public Double sum() {
		Double valueT = Double.valueOf(value);
		Integer quantitiT = Integer.valueOf(quantiti);
		return valueT * quantitiT;
	}

}
