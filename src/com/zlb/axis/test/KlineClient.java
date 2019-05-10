package com.zlb.axis.test;

import javax.xml.namespace.QName;


public class KlineClient {
	public static String call(String message, String url, String method) {
		String xml = null;
//		try {

//			RPCServiceClient rsc = new RPCServiceClient();
//			Options options = rsc.getOptions();
//			EndpointReference epr = new EndpointReference(url);
//			options.setTo(epr);
//
//			QName qName = new QName(
//					"http://webservices.engine.strategy.zlb.com", method);
//			Object[] args = new Object[] { message };
//			Class[] classes = new Class[] { String.class };
//
//			xml = (String) rsc.invokeBlocking(qName, args, classes)[0];
//
//		} catch (AxisFault e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return xml;
	}
}
