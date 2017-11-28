package Pear.market;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PictureStateChange extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		try {
			lg.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(dependsOnMethods="Login")
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' �̳����� ')]");
		webtest.click("xpath=//a[contains(.,'չʾͼ�б�')]");
		//�����
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[2]/a");
		Checker ck1=new Checker(webtest);
		ck1.verifyText("xpath=//td[contains(.,'�����')]", "�����");
		Thread.sleep(3000);
		//�ѷ���
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[3]/a");
		Checker ck2=new Checker(webtest);
		ck2.verifyText("xpath=//td[contains(.,'�ѷ���')]", "�ѷ���");
		Thread.sleep(3000);
		//�ѹ���
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[4]/a");
		Checker ck3=new Checker(webtest);
		ck3.verifyText("xpath=//td[contains(.,'�ѹ���')]", "�ѹ���");
	}
}
