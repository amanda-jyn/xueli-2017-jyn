package Pear.login;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestLogin extends BaseTest{
	@Test
	public void testlogin() throws Exception{
		PearLogin pl=new PearLogin(webtest);
		pl.login();
	}
}
