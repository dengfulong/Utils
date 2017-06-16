package com.zlb.axis.test;

import org.junit.Test;

import net.sf.json.JSONObject;

public class ActivityForceDev {

	@Test
	public void testForceDelivery() {
		JSONObject jobjParam = new JSONObject();
		jobjParam.put("uid", 130206);
		jobjParam.put("lc", "jyw@zlW");
		// 1: is last tradingday 2: not lasttradingday
		int isLastTradingDay = 1;
		int notLastTradingDay = 2;
		jobjParam.put("delivertype", 2);
		jobjParam.put("activityid", 1);
		String xmlStr = jobjParam.toString();
		// String url = "http://192.168.1.188:8888/axis2/services/SimTrade";
		String url = "http://192.168.1.188:8888/axis2/services/SimTrade";
		String method = "forceDelivery";
		String nm = "http://webservices.trade.strategy.zlb.com";
		String result = TradeClient.call(xmlStr, url, method, nm);

		System.out.println("result is: " + result);
	}

}
