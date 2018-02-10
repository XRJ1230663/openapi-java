package com.topnet.jyopenapi;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Described 剑鱼数据开放平台接口调用样例
 * @author rz
 * @date 2018-02-09
 * @version v1.0
 */
public class JyOpenApi  {
	
	/**
	 * 调用样例
	 * 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String appid="jyo_2018Yhsal8Ujk";
		String secret="secRtjdsklv90bbn";
		
		Map<String, String> parameters = new HashMap<String, String>();
		// 请求参数
		parameters.put("action","getdata");
	    parameters.put("keyword", "北京拓普丰联信息工程有限公司"); //keyword参数必须是公司名称全称,不支持模糊匹配。
	    parameters.put("appid", appid);
	    parameters.put("timestamp", new Date().getTime()/1000+"");
  
	    //参数签名
	    try {
	    	String signature=JyOpenUtils.Signature(parameters, secret);
	    	parameters.put("signature",signature);
	    	JyOpenUtils.post("https://api.jianyu360.com/open",parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
