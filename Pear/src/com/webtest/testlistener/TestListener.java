package com.webtest.testlistener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{
	//Test指的是每一个测试用例
	public void onTestFailure(ITestResult result){
		System.out.println("the test case fail");
	}
	public void onTestSkipped(ITestResult result){
		System.out.println("the test case skip");
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("the test case pass");		
	}
	//3.以下两个方法在testng.xml中的,test标签开始前，后执行

	public void onStart(ITestContext content){
		System.out.println("the test case run");
	}
	
	public void onFinish(ITestContext content){
		System.out.println("the test case done,send mail");
	}
	
}
