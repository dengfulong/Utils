package com.zlb.axis.test;

import java.util.Vector;


public class Produce implements Runnable {
	
	String url = "http://127.0.0.1:8080/axis2/services/RealTrade";
	String nm = "http://webservices.real.trade.zlb.com";
	String method = "tradeInfo";
	String xxx = "{123,456}";
	@Override
	public void run() {

			for(int i=1;i<=50;i++){
				
				TradeClient.call(xxx, url, method, nm);
			}
			
			
	}

}
