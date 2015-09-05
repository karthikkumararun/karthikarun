package com.karthik.spring.learning.weatherservice;

import net.webservicex.GetWeather;
import net.webservicex.GetWeatherResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * <p>
 * Class to make a call to weather service web service and display output
 * </p>
 * 
 * @author Karthik
 * @version 1.0
 */
@Component(value = "weatherServiceClient")
public class WeatherServiceClientImpl {

	@Autowired()
	protected WebServiceTemplate weatherServiceClient;

	/**
	 * <p>
	 * Method to call Weather service WS
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public GetWeatherResponse getweather(GetWeather request) throws Exception {
		GetWeatherResponse response = null;
		System.out.println(weatherServiceClient.getDefaultUri());
		response = (GetWeatherResponse) weatherServiceClient.marshalSendAndReceive(request);
		return response;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GetWeather weather = new GetWeather();
		weather.setCityName("New Delhi");
		weather.setCountryName("India");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-weatherservice.xml");
		WeatherServiceClientImpl client = (WeatherServiceClientImpl) context.getBean("weatherServiceClient");
		try {
			System.out.println("Finding weather information for: " + weather.getCityName() + ", "
					+ weather.getCountryName());
			GetWeatherResponse response = client.getweather(weather);
			if (response != null) {
				System.out.println("The weather information is: " + response.getGetWeatherResult());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((AbstractApplicationContext) context).registerShutdownHook();
		}
	}
}
