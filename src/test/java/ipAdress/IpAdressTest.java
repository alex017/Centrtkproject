package ipAdress;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class IpAdressTest {
	String ip1 = "192.168.1.112";
	String ip2 = "192.168.4.5";
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
	public void testLevelOfNotEq(){
		int[] ipInt1 = {192, 168, 1, 112};
		int[] ipInt2 = {192, 168, 4, 5}; 
		Assert.assertEquals(2,ipAd.levelOfNotEq(ipInt1, ipInt2));
	}
	
	@Test
	public void testLevelOfNotEqWhenEq(){
		int[] ipInt1 = {192, 168, 1, 112};
		int[] ipInt2 = {192, 168, 1, 112}; 
		Assert.assertEquals(4,ipAd.levelOfNotEq(ipInt1, ipInt2));
	}
	
	@Test
	public void testLevelOfNotEqWhenNotEqAtAll(){
		int[] ipInt1 = {172, 168, 1, 112};
		int[] ipInt2 = {192, 168, 1, 112}; 
		Assert.assertEquals(0,ipAd.levelOfNotEq(ipInt1, ipInt2));
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
	
}
