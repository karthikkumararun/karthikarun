package club.allaboutjava.karthik.JAXB;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.example.exampleschema.UserDetailsType;
import org.example.exampleschema.UserType;

/**
 * <p>
 * Class for illustrating JAXB marshaling
 * <p>
 * 
 * @author Karthik Arun (karthikarun@outlook.com)
 *
 */
public class MarshallerExample {

	public static final Logger logger = Logger.getLogger(MarshallerExample.class);
	public static void main(String[] args) {
		UserDetailsType userDetails = new UserDetailsType();
		UserType user = new UserType();
		user.setUserName("Karthik Arun");
		user.setUserLocation("Bangalore");
		user.setUserPhone("9876543210");
		userDetails.setUserDetails(user);
		try {
			JAXBContext context = JAXBContext.newInstance(UserDetailsType.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(userDetails, stringWriter);
			logger.debug(stringWriter.toString());
		} catch (JAXBException e) {
			logger.error("JAXB exception occured: "+e);
		}
		
	}
}
