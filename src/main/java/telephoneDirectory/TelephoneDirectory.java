package telephoneDirectory;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * This class is the telephone directory
 * conteine's names and phone numbers
 * @author alexei
 * @version 1.0
 */
public class TelephoneDirectory {
	/* Information is store as a HashMap<name, phone's list> */
	private HashMap<String, LinkedList<String>> telphoneDirectory = 
			new HashMap<String, LinkedList<String>>();
	
	{
		LinkedList<String> ivanPhones = new LinkedList<String>();
		ivanPhones.add("+7 800 200 100");
		ivanPhones.add("+7 800 250 400");
		telphoneDirectory.put("Ivanov I.I.",ivanPhones);
		LinkedList<String> petrovPhones = new LinkedList<String>();
		petrovPhones.add("+7 850 200 100");
		petrovPhones.add("+7 800 230 400");
		petrovPhones.add("+7 800 230 450");
		telphoneDirectory.put("Petrov P.P.",petrovPhones);
		LinkedList<String> sidorovPhones = new LinkedList<String>();
		sidorovPhones.add("+7 800 200 111");
		telphoneDirectory.put("Sidorov D.D.",sidorovPhones);

	}
	
	public TelephoneDirectory(){}
	
	/*
	 * true if name exist in phone directory, otherwise false 
	 */
	public boolean isPersonExist(String name){
		return telphoneDirectory.containsKey(name);
	}
	/*
	 * set new person to phone directory
	 * or if exits already, then add just phone number's
	 */
	public void set(String name, LinkedList<String> telephones){
		if (!isPersonExist(name)){
			telphoneDirectory.put(name, telephones);
		}
		else{
			for (String telephone : telephones){
				telphoneDirectory.get(name).add(telephone);
			}
		}
	}
	
	@Override
	public String toString(){
		String dir="";
		for (String name: telphoneDirectory.keySet()){
			dir = dir + name + "\n" +
					toString(name) + "++++++++++++\n";
		}
		return dir;
	}
	
	public String toString(String name){
		String dir="";
		if (!isPersonExist(name)) return ("person" + name + "doesn't exist here\n");
		for (String telephone : telphoneDirectory.get(name)){
			dir = dir+telephone+"\n";
		}
		return dir;
	}
	/*
	 * printing to the standard out stream
	 * @param name 
	 */
	public void printFromDirectoryByName(String name){
		System.out.print(toString(name));
	}
}
