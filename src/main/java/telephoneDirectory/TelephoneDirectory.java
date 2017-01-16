package telephoneDirectory;

import java.util.HashMap;
import java.util.LinkedList;

public class TelephoneDirectory {
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
	
	public boolean isPersonExist(String name){
		return telphoneDirectory.containsKey(name);
	}
	
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
	
	public void printFromDirectoryByName(String name){
		System.out.print(toString(name));
	}
}
