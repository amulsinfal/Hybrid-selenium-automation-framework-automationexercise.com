package com.ae.objects;

public class Payments {

	private String nameOnCard;
	private String cardNumber;
	private String cvc;
	private String expiryMonth;
	private String expiryYear;

	public String getNameOnCard() {
		return nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvc() {
		return cvc;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

}