package com.zlb.axis.test;

import org.junit.Test;

public class ClientTest {

	@Test
	public static void main(String[] args){
		
		String url = "http://192.168.1.165:8081/axis2/services/zlbTrade";

		String ns = "http://trade.zlb.com";

		String method = "updPriceFactor";
		
//		Scanner sc = new Scanner(System.in); 
//        System.out.println("请输入investorid："); 
//        String investor = sc.nextLine(); 
//        System.out.println("请输入brokerid："); 
//        String broker = sc.nextLine(); 
//        System.out.println("请输入合约编号：");
//        String iid = sc.nextLine();
//        System.out.println("请输入报单序列号：");
//        String order = sc.nextLine();
//        System.out.println("请输入报单编号：");
//        String depute = sc.nextLine();
//        System.out.println("请输入方向：");
//        int dir = sc.nextInt();
//        System.out.println("请输入子账户id：");
//        int aid = sc.nextInt();
//        
//        JSONObject jobj = new JSONObject();
//        jobj.put(TradeConst.TRADE_CONDITION_PRICE, "NaN");
//        TradeMessage tm = new TradeMessage();
//		tm.setConditionPrice(jobj.getDouble(TradeConst.TRADE_CONDITION_PRICE));
//		if(Double.isNaN(tm.getConditionPrice())){
//			System.out.println(123);
//		}
		String s = "{\"holderid\":1000,\"pricefactor\":0}";
//        jobj.put("broker", broker);
//        jobj.put("investor", investor);
//        jobj.put("order", order);
//        jobj.put("dir", dir);
//        jobj.put("iid", iid);
//        jobj.put("aid", aid);
//        jobj.put("depute", depute);
		TradeClient.call(s, url, method, ns);
	}
		
}
