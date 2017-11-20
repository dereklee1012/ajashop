package com.ajashop.web.common.xml;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class XmlBinding {
	
	public static Object getUnmarshallingFromInputstream(InputStream inputStream, Class<?> cls) throws Exception {
		try {
			JAXBContext context 		= JAXBContext.newInstance(cls);			
			Unmarshaller unmarshaller 	= context.createUnmarshaller();
			
			UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	
			SAXParserFactory factory = SAXParserFactory.newInstance();
	
			factory.setNamespaceAware(true);
				
			XMLReader reader = factory.newSAXParser().getXMLReader();
	
			reader.setContentHandler(unmarshallerHandler);
	
			reader.parse(new InputSource(inputStream));	
			
			return unmarshallerHandler.getResult();		
						
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			inputStream.close();
		}
	}
	
	public static Object getUnmarshallingFromString(String xmlString, Class<?> cls) throws Exception {
		try {
			JAXBContext context 		= JAXBContext.newInstance(cls);			
			Unmarshaller unmarshaller 	= context.createUnmarshaller();
			
			UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	
			SAXParserFactory factory = SAXParserFactory.newInstance();
	
			factory.setNamespaceAware(true);
				
			XMLReader reader = factory.newSAXParser().getXMLReader();
	
			reader.setContentHandler(unmarshallerHandler);
	
			reader.parse(new InputSource(new StringReader(xmlString)));	
			
			return unmarshallerHandler.getResult();		
						
		} catch(Exception e) {
			throw e;
		} 
	}
	
	public static String getMarshallingString(Object obj) {
		JAXBContext jaxbContext;
		StringWriter st = new StringWriter(); 
		try {
			jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, st);
			return st.toString();
		} catch(Exception e) {
			return null;
		} 
	}
	
	public static String getMarshallingStringAndNullpadding(Object obj) {
		JAXBContext jaxbContext;
		StringWriter st = new StringWriter(); 
		try {
			jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, st);
			return st.toString() + "\0";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
