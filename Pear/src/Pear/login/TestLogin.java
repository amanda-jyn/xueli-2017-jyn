package Pear.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.testlistener.TestListener;
@Listeners(TestListener.class)
public class TestLogin extends BaseTest{
	@Test
	public void testlogin(){
		PearLogin pl=new PearLogin(webtest);
		pl.login();
	}
}