package tekephoneDirectory;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import telephoneDirectory.TelephoneDirectory;

public class TelephoneDirectoryTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	
	private TelephoneDirectory telephoneDirecory = new TelephoneDirectory();
	
	@Before
	public void setStreamOut(){
		System.setOut(new PrintStream(outContent));
	}
	@After
	public void returnStreamOut(){
		System.setOut(null);
	}
	
	@Test
	public void testPrint(){
		telephoneDirecory.printFromDirectoryByName("Sidorov D.D.");
		assertEquals("+7 800 200 111\n", outContent.toString());
	}
	
	@Test
	public void testPrint1(){
		telephoneDirecory.printFromDirectoryByName("Ivanov I.I.");
		assertEquals("+7 800 200 100\n+7 800 250 400\n", outContent.toString());
	}
	
	@Test
	public void testNoName(){
		String name = "Bulgakov I.I.";
		telephoneDirecory.printFromDirectoryByName(name);
		assertEquals("person" + name + "doesn't exist here\n", outContent.toString());
	}
}
