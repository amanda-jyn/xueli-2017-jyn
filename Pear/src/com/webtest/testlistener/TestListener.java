package com.webtest.testlistener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestListener extends TestListenerAdapter{
	//Testָ����ÿһ����������
	public void onTestFailure(ITestResult result){
		System.out.println("����ִ��ʧ�ܣ�������־");
	}
	public void onTestSkipped(ITestResult result){
		System.out.println("����������Ծִ��");
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("ִ�гɹ���");		
	}
	//3.��������������testng.xml�е�,test��ǩ��ʼǰ����ִ��

	public void onStart(ITestContext content){
		System.out.println("������ʼִ��");
	}
	
	public void onFinish(ITestContext content){
		System.out.println("����ִ����ϣ������ʼ�");
		
	}
	
}
