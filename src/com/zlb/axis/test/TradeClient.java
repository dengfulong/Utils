package com.zlb.axis.test;

import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.zlb.common.data.TradeMessage;

public class TradeClient {
	public static String call(String message, String url, String method,
			String namingSpace) {
		String xml = null;
		try {
//
			RPCServiceClient rsc = new RPCServiceClient();
			Options options = rsc.getOptions();
//			options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);
			EndpointReference epr = new EndpointReference(url);
			options.setTo(epr);

			QName qName = new QName(namingSpace, method);
			Object[] args = new Object[] { message };
			Class[] classes = new Class[] { String.class };

			xml = (String) rsc.invokeBlocking(qName, args, classes)[0];
//			rsc.invokeRobust(qName, args);
			System.out.println(xml);
			
//			Service service = new Service();
//			Call call;
//			try {
//				call = (Call) service.createCall();
//				call.setTargetEndpointAddress(new java.net.URL(url));
//			} catch (ServiceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xml;
	}
	
	
	//交易调用风控
	public static int callObject(TradeMessage tm, String url, String method,
			String namingSpace) {
		int xml = 0;
		try {

			RPCServiceClient rsc = new RPCServiceClient();
			Options options = rsc.getOptions();
			EndpointReference epr = new EndpointReference(url);
			options.setTo(epr);

			QName qName = new QName(namingSpace, method);
			Object[] args = new Object[] { tm };
			Class[] classes = new Class[] { int.class };

			xml = (int) rsc.invokeBlocking(qName, args, classes)[0];
            System.out.println(xml);

		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;

	}
	
	//java 调用gsoap服务
	public static void callC(String url,String method,String[] partName,String ns,String[] param){
		
		try   
        {   
              
			EndpointReference endpointReference = new EndpointReference(url);   
			  
			//请求参数设置  
			Options options = new Options();   
			//            options.setAction("");    
			options.setTo(endpointReference);   
			  
			ServiceClient sender = new ServiceClient();   
			sender.setOptions(options);   
			
			
			OMFactory fac = OMAbstractFactory.getOMFactory();  
			OMNamespace omNs = fac.createOMNamespace(ns, "web");  
			  
			OMElement data = fac.createOMElement(method, omNs);  
			for(int i=0;i<partName.length;i++){  
				OMElement inner = fac.createOMElement(partName[i], omNs);  
				inner.setText(param[i]);  
				data.addChild(inner);  
			}  
              
            //发送并得到结果，至此，调用成功，并得到了结果   
            OMElement result = sender.sendReceive(data); 
            Iterator iterator = result.getChildElements();
            Iterator innerItr;
            OMElement r = null;
            while (iterator.hasNext()) {
                r = (OMElement) iterator.next();
                innerItr = result.getChildElements();
                System.out.println(((OMElement)innerItr.next()).getText());
            }
  
		}catch (AxisFault ex){   
	        ex.printStackTrace();   
	    }
	}
}
