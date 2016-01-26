package club.allaboutjava.karthik.JAXB;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.example.exampleschema.CustomerDetailsType;

/**
 * <p>
 * Class for illustrating JAXB marshaling
 * <p>
 * 
 * @author Karthik Arun (karthikarun@outlook.com)
 *
 */
public class MarshallerExampleForNoRootElement {

	public static final Logger logger = Logger.getLogger(MarshallerExampleForNoRootElement.class);
	public static void main(String[] args) {
		CustomerDetailsType custDetails = new CustomerDetailsType();
		custDetails.setUserName("Karthik Arun");
		custDetails.setUserLocation("Bangalore");
		custDetails.setUserPhone("9876543210");
		
		try {
			JAXBContext context = JAXBContext.newInstance(CustomerDetailsType.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			QName qName = new QName("http://www.example.org/ExampleSchema", "CustomerDetailsType");
			JAXBElement<CustomerDetailsType> rootElement = new JAXBElement<CustomerDetailsType>(qName,CustomerDetailsType.class,custDetails);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(rootElement, stringWriter);
			logger.debug(stringWriter.toString());
		} catch (JAXBException e) {
			logger.error("JAXB exception occured: "+e);
		}
		
	}
}
