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
		webtest.click("xpath=//span[contains(.,' 商城设置 ')]");
		webtest.click("xpath=//a[contains(.,'展示图列表')]");
		//新添加
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[2]/a");
		Checker ck1=new Checker(webtest);
		ck1.verifyText("xpath=//td[contains(.,'新添加')]", "新添加");
		Thread.sleep(3000);
		//已发布
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[3]/a");
		Checker ck2=new Checker(webtest);
		ck2.verifyText("xpath=//td[contains(.,'已发布')]", "已发布");
		Thread.sleep(3000);
		//已过期
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[4]/a");
		Checker ck3=new Checker(webtest);
		ck3.verifyText("xpath=//td[contains(.,'已过期')]", "已过期");
	}
}
