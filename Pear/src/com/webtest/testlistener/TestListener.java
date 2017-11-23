package com.webtest.testlistener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.webtest.mail.SendMail;

public class TestListener extends TestListenerAdapter{
	//Test指的是每一个测试用例
	public void onTestFailure(ITestResult result){
		System.out.println("用例执行失败，加入日志");
	}
	public void onTestSkipped(ITestResult result){
		System.out.println("用例发生跳跃执行");
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("执行成功了");		
	}
	//3.以下两个方法在testng.xml中的,test标签开始前，后执行

	public void onStart(ITestContext content){
		System.out.println("用例开始执行");
	}
	
	public void onFinish(ITestContext content){
		System.out.println("用例执行完毕，发送邮件");
		SendMail sendmail=new SendMail();
		try {
			sendmail.setemail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sendmail.createAttachMail(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
