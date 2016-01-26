package club.allaboutjava.karthik.JAXB;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

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
public class UnmarshallingExampleWithSchemaValidation {

	public static final Logger logger = Logger.getLogger(UnmarshallingExample.class);

	public static void main(String[] args) {
		UnmarshallingExample unExample = new UnmarshallingExample();
		File file = new File(unExample.getClass().getClassLoader().getResource("ExampleSchemaBad.xml").getFile());
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=null;
		try {
			schema = schemaFactory.newSchema(new File(unExample.getClass().getClassLoader().getResource("ExampleSchema.xsd").getFile()));
		} catch (Exception e) {
			logger.error("SAX parse Exception: ", e);
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserDetailsType.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setSchema(schema);
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
