package com.zlb.axis.test;

import org.junit.Test;

import net.sf.json.JSONObject;

public class MajorInstruments {
	@Test
	public void testUpdateMajorInst() {

		JSONObject jobj = new JSONObject();
		jobj.put("un", "lhtzadmin");
		jobj.put("passwd", ";flaksd(*&F");
		String xmlStr = jobj.toString();
		String url = "http://210.14.149.157:8080/axis2/services/StrategyEngine";
		// String url =
		// "http://192.168.1.188:8080/axis2/services/StrategyEngine";
		String method = "updateMajorInst";
		String nm = "http://webservices.engine.strategy.zlb.com";
		String result = TradeClient.call(xmlStr, url, method, nm);

		System.out.println("result is: " + result);
	}

}
