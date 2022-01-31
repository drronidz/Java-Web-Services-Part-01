package com.cleverdeveloper.javafirstws.soap;


import com.cleverdeveloper.javafirstws.dto.PaymentProcessorRequest;
import com.cleverdeveloper.javafirstws.dto.PaymentProcessorResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/* @Annotation (@WebService)[required] : */
/* @ tells apache CXF or any SOAP run time that this particular class or interface should be exposed out as a web service*/
/* @ that's the only annotation that is required to expose this as a web service (the key annotation)*/

@WebService(name= "PaymentProcessor")
public interface PaymentProcessor {
	/*@ @Annotation (@webMethod)[optional] :*/
	/*@ This method will be exposed out automatically as web service method.*/
	@WebMethod
	public @WebResult(name = "response") PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
