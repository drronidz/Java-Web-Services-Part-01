package com.cleverdeveloper.javafirstws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/*
/* @Class: Marking this with The JAXB annotation.*/
/* @Object: So objects in this class can be serialized into & deserialized back.*/
/* @Class: The class here will have it's own complex type in the generated WSDL file an eventually the SOAP message.*/
/* @Annotation : @XmlType: can have optionally a name (by default the name is the class name).*/
/* @Annotation :@XmlAccessorType: tells the JAXB runtime which is the Apache CXF (in this case) at which level the JAXB*/
/* @Annotation :@XmlAccessorType: between the parenthesis we indicates the type*/

@XmlType(name="PaymentProcessorRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentProcessorRequest {

	@XmlElement(name = "creditCardInfo", required = true)
	private CreditCardInfo creditCardInfo;

	@XmlElement(name = "amount")
	private Double amount;

	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
