package br.com.alura.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sale {

	private String paymentForm;

	@XmlElementWrapper(name = "products")
	@XmlElement(name = "product")
	private List<Product> products;

	public Sale() {

	}
	
	public Sale(String paymentForm, List<Product> products) {
		this.paymentForm = paymentForm;
		this.products = products;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(String paymentForm) {
		this.paymentForm = paymentForm;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentForm == null) ? 0 : paymentForm.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (paymentForm == null) {
			if (other.paymentForm != null)
				return false;
		} else if (!paymentForm.equals(other.paymentForm))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sales [paymentForm=" + paymentForm + ", products=" + products + "]";
	}

}
