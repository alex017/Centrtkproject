package ipAdress;

public class IpAdress {
	private int[] ipadress1 = new int[4];
	private int[] ipadress2 = new int[4]; 
	
	String[] splitIpAdress(String ip){ //split ip adress by dots
		return ip.split("\\.");
	}
	
	boolean validate(String[] ip){ // ip adress type xxx.xxx.xxx.xxx
		return ip.length == 4;
	}
	
	boolean validate(int numericFromIp){	// numeric in ip adress should be 
											// between 0 and 255
		return (numericFromIp >= 0 && numericFromIp <= 255);
	}
	
	int[] getIpAdressInInt(String[] ip) throws NotValidIpException{// get the ip[]
		// from String[] with validation
		int[] ipAdress = new int[4];
		if (!validate(ip)) { throw new NotValidIpException("not valid ip,"
				+ "ip has not right type "+ip);}
		for (int i = 0; i<4; i++){
			ipAdress[i] = Integer.parseInt(ip[i]);
			if (!validate(ipAdress[i])){ throw new NotValidIpException("not valid ip,"
					+ "numeric in ip is not avvalable "+ip+" "+ipAdress[i]);}
		}
		return ipAdress;
	}
	
	private void swapIps(){ // swap ip's, if 2-nd ip bigger 
		int[] ip = new int[4];
		ip = this.ipadress1;
		this.ipadress1 = this.ipadress2;
		this.ipadress2 = ip;
	}
	
	int levelOfNotEq(){ // the level in ip, started from the top,
											// where 2 ip adresse's are not equal
											// if they are equal then return 4
		for (int i = 0; i<4; i++){
			if (this.ipadress1[i] != this.ipadress2[i]){
				if (this.ipadress1[i] > this.ipadress2[i]) swapIps();
				return i;
			}
		}
		return 4;
	}
	
	private void printIp(int[] ipForPrint){ //print ip 
		for (int i = 0; i<3; i++){
			System.out.print(ipForPrint[i]+".");
		}
		System.out.println(ipForPrint[3]);
	}
	
	private void populateToEnd(int[] ipForPrint){// populate lower level of ip to 255
		populate(ipForPrint, 255);
	}
	private void populate(int[] ipForPrint, int max){// populate lower level of ip to max
		int i = 3;
		while (ipForPrint[i] < max){
			ipForPrint[i]++;
			printIp(ipForPrint);
		}
		if (max == 255)	incHighLev(i,ipForPrint);
	}
	private void incHighLev(int level, int[] ipForPrint){//increasing higher level of ip
		while (ipForPrint[level] == 255){
			ipForPrint[level] = 0;
			ipForPrint[--level]++;
			printIp(ipForPrint);
		}
	}
	
	private void makeEqOnLevel(int levelWhereNotEqual,int[] ipForPrint){
		// make ip equal on level
		while (ipForPrint[levelWhereNotEqual] != this.ipadress2[levelWhereNotEqual]){
			populateToEnd(ipForPrint);
		}
	}
	
	public void diaposon(){ // find and print diaposon
		int levelWhereNotEqual = levelOfNotEq();
		if (levelWhereNotEqual == 4) {System.out.println("Equal ip's");return;}
		
		int[] ipForPrint = this.ipadress1.clone();
		while (levelWhereNotEqual != 3){// we do populate, untill high levels
										// where was a different will be equal
										// then increasing level, whcich mean 
										// we go father in ip
										// by this we take equality on all levels except
										// the last one
			makeEqOnLevel(levelWhereNotEqual, ipForPrint);
			levelWhereNotEqual++; 
		}
		//populate the tail which is the lower level
		populate(ipForPrint, this.ipadress2[3]-1);
	}
		
	IpAdress(String ip1, String ip2) throws NotValidIpException{
		// split ip adresse's by dots
		String[] ipAdress1 = this.splitIpAdress(ip1); 
		String[] ipAdress2 = this.splitIpAdress(ip2);
		// trying to transform ip int[] from String[]
		// we do validation in transformation time
		this.ipadress1 = getIpAdressInInt(ipAdress1);
		this.ipadress2 = getIpAdressInInt(ipAdress2);
	}

	public static void main(String[] args) {
		/*// firstly need to be sure that had been sent 2 arguments 
		if (args.length != 2){
			System.out.println("Should be 2 ip adresses");
			return;
		}
		try {
			IpAdress ad = new IpAdress(args[0], args[1]);
		} catch (NotValidIpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/				
	}
}
