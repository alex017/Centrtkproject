package ipAdress;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IpAdressTest {
	String ip1 = "192.168.1.4";
	String ip2 = "192.168.1.7";
	IpAdress ipAd;
	{		
		try {
			ipAd = new IpAdress(ip1, ip2);
		} catch (NotValidIpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValid(){		
		int numeric = 100;
		Assert.assertTrue(ipAd.validate(numeric));
		numeric = 256;
		Assert.assertFalse(ipAd.validate(numeric));
		numeric = -1;
		Assert.assertFalse(ipAd.validate(numeric));
	}
	
	@Test
	public void testLevelOfNotEq() throws NotValidIpException{
		String ipInt1 = "192.168.1.112";
		String ipInt2 = "192.168.4.5"; 
		Assert.assertEquals(2,new IpAdress(ipInt1,ipInt2).levelOfNotEq());
	}
	
	
	@Test
	public void testLevelOfNotEqWhenEq() throws NotValidIpException{
		String ipInt1 = "192.168.1.112";
		String ipInt2 = "192.168.1.112"; 
		Assert.assertEquals(4,new IpAdress(ipInt1,ipInt2).levelOfNotEq());
	}
	
	@Test
	public void testLevelOfNotEqWhenNotEqAtAll() throws NotValidIpException{
		String ipInt1 = "172.68.1.112";
		String ipInt2 = "192.168.1.112"; 
		Assert.assertEquals(0,new IpAdress(ipInt1,ipInt2).levelOfNotEq());
	}
	
	@Test(expected = NotValidIpException.class)
	public void testNotValidIpException() throws NotValidIpException{
		ip1 = "192.168.1.256";
		ip2 = "192.168.4.5";
		IpAdress ipAdEx = new IpAdress(ip1, ip2);		
	}
	
	@Test(expected = NotValidIpException.class)
	public void testNotValidIpExceptionAnother() throws NotValidIpException{
		ip1 = "192.168";
		ip2 = "192.168.4";
		IpAdress ipAdEx = new IpAdress(ip1, ip2);		
	}
	
	@Test
	public void testDiaposon(){
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    ipAd.diaposon();
	    assertEquals("192.168.1.5\n"
	    		+ "192.168.1.6\n", outContent.toString());	    
		System.setOut(null);
		

	}
	
}
