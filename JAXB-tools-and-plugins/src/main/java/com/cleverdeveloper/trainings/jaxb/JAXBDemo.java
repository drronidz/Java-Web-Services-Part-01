package com.cleverdeveloper.trainings.jaxb;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 26/01/2022 14:54
*/

import com.cleverdeveloper.patient.Patient;
import com.diogonunes.jcolor.Attribute;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;


public class JAXBDemo {
    public static void main(String[] args) throws JAXBException {
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(45, 45, 45);
        /*********** The process of Marshalling ***********/

        System.out.println(colorize("\t######### The process of Marshalling #########\t", BOLD(), textColor, backgroundColor));

        /* This is the main entry point for the JAXB API */
        JAXBContext context = JAXBContext.newInstance(Patient.class);

        /* Creating a marshaller */
        Marshaller marshaller = context.createMarshaller();

        /* Creating a new patient */
        Patient patient = new Patient();
        patient.setId(123);
        patient.setName("DIAB");

        /**
         * @param 1 : it is the actual JAXB element which should be marshalled (patient in our case).
         * @param 2 : it is a handler (output stream) which we want this XML to be written (StringWriter in our case).
         */
        StringWriter writer = new StringWriter();
        marshaller.marshal(patient, writer);

        /* Printing the content of the writer. */
        System.out.println(writer.toString());


        /*********** The process of UNMarshalling ***********/
        System.out.println(colorize("\t######### The process of Unmarshalling #########\t", BOLD(), textColor, backgroundColor));

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(writer.toString());
        /**
        * @param: it takes a new reader.
         * It usually returns an object using a type cast.
        * */
        Patient patientResult = (Patient) unmarshaller.unmarshal(reader);

        System.out.println(patientResult);
    }
}
