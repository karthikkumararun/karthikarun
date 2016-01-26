package club.allaboutjava.karthik.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.example.exampleschema.UserDetailsType;

/**
 * <p>
 * Class for illustrating JAXB unmarshaling
 * <p>
 * 
 * @author Karthik Arun (karthikarun@outlook.com)
 *
 */
public class UnmarshallingExample {

	public static final Logger logger = Logger.getLogger(UnmarshallingExample.class);

	public static void main(String[] args) {
		UnmarshallingExample unExample = new UnmarshallingExample();
		File file = new File(unExample.getClass().getClassLoader().getResource("ExampleSchema.xml").getFile());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserDetailsType.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<UserDetailsType> rootElement = jaxbUnmarshaller.unmarshal(new StreamSource(file),
					UserDetailsType.class);
			UserDetailsType userDetails = rootElement.getValue();
			logger.debug("UserName: "+userDetails.getUserDetails().getUserName());
			logger.debug("UserLocation: "+userDetails.getUserDetails().getUserLocation());
		} catch (Exception e) {
			logger.error("JaxB unMarshalling exception: ", e);
		}
	}
}
