package com.dce.hutool;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.hanlp.HanLPEngine;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.webservice.SoapClient;

public class HuToolStater {

	public static void main(String[] args) {
		String a = "2017年05/06日";
		Date value = Convert.toDate(a);
		System.out.println(value);
		
		String name = "ａｂｃ";
		String nameb = Convert.toDBC(name);
		System.out.println(nameb);
		String digitToChinese =Convert.digitToChinese(85494.99);////.numberToWord(897897.12); //
		System.out.println(digitToChinese);
		DateTime beginOfWeek = DateUtil.beginOfWeek(Calendar.getInstance().getTime());
		System.out.println(beginOfWeek);
		
		int apHash = HashUtil.apHash("asd");
		int jsHash = HashUtil.jsHash("abc");
		System.out.println(apHash+"\t ---js:\t"+jsHash);
		
		
		
		SecureUtil util = null;
		String url = "https://www.baidu.com/";
		String content = HttpUtil.get(url);
		
		System.out.println(content);
		
		
		//请求列表页
		String listContent = HttpUtil.get("https://www.oschina.net/action/ajax/get_more_news_list?newsType=&p=2");
		//使用正则获取所有标题
		List<String> titles = ReUtil.findAll("<span class=\"text-ellipsis\">(.*?)</span>", listContent, 1);
		for (String title : titles) {
		    //打印标题
		    Console.log(title);
		}

		
		
		// 新建客户端
		SoapClient client = SoapClient.create("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx")
	    // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
	    .setMethod("web:getCountryCityByIp", "http://WebXml.com.cn/")
	    // 设置参数，此处自动添加方法的前缀：web
	    .setParam("theIpAddress", "14.23.95.10");

	    // 发送请求，参数true表示返回一个格式化后的XML内容
	    // 返回内容为XML字符串，可以配合XmlUtil解析这个响应
	    Console.log(client.send(true));
	    
	    
//	    MailUtil.send("2856346101@qq.com", "测试", "邮件来自Hutool测试", false);
	    
	    
	  //自动根据用户引入的分词库的jar来自动选择使用的引擎
	    TokenizerEngine engine = TokenizerUtil.createEngine();

	    //解析文本
	    String text = "这两个方法的区别在于返回值";
	    Result result = engine.parse(text);
	    //输出：这 两个 方法 的 区别 在于 返回 值
	    String resultStr = CollUtil.join((Iterator<Word>)result, " ");

	    System.out.println(resultStr);
	}
}
