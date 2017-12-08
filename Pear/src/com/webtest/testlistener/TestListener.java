package com.webtest.testlistener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{
	//Testָ����ÿһ����������
	public void onTestFailure(ITestResult result){
		System.out.println("the test case fail");
	}
	public void onTestSkipped(ITestResult result){
		System.out.println("the test case skip");
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("the test case pass");		
	}
	//3.��������������testng.xml�е�,test��ǩ��ʼǰ����ִ��

	public void onStart(ITestContext content){
		System.out.println("the test case run");
	}
	
	public void onFinish(ITestContext content){
		System.out.println("the test case done,send mail");
	}
	
}
