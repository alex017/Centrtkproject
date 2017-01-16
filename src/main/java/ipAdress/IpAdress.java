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
	
	/*String ip1 = "192.168.1.112";
	String ip2 = "192.168.4.5";
	IpAdress ipAd = new IpAdress(ip1, ip2);
	private void swapIps(){ // swap 2 ip's 
		int[] ip = new int[4];
		ip = this.ipadress1;
		this.ipadress1 = this.ipadress2;
		this.ipadress2 = ip;
	}
	*/
	int levelOfNotEq(){ // the level in ip, started from the top,
											// where 2 ip adresse's are not equal
											// if they are equal then return 0 and 4 if equal
		for (int i = 0; i<4; i++){
			if (this.ipadress1[i] != this.ipadress2[i]){
				/*if (ip1[i] < ip2[i]){
					swapIps();
				}
				*/
				return i;
			}
		}
		return 4;
	}
	
	private void diaposon(int[] ip1, int ip2[]){
		int levelWhereNotEqual = levelOfNotEq();
	}
		
	IpAdress(String ip1, String ip2) throws NotValidIpException{
		// split ip adresse's by dots
		String[] ipAdress1 = this.splitIpAdress(ip1); 
		String[] ipAdress2 = this.splitIpAdress(ip2);
		// trying to transform ip int[] from String[]
		// we do validation in transformation time
		this.ipadress1 = getIpAdressInInt(ipAdress1);
		this.ipadress2 = getIpAdressInInt(ipAdress2);
		for (int i = 0; i<4; i++){
			System.out.println(this.ipadress2[i]);
		}
		//System.out.println(this.levelOfNotEq(this.ipadress1, this.ipadress2));
		
	}

	public static void main(String[] args) {
		// firstly need to be sure that had been sent 2 arguments 
		if (args.length != 2){
			System.out.println("Should be 2 ip adresses");
			return;
		}
		try {
			IpAdress ad = new IpAdress(args[0], args[1]);
		} catch (NotValidIpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
