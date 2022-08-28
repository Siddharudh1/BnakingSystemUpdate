package Mypackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountOperations {
	Map<String, Account> map = new HashMap<String, Account>();
	public void createCustomerAccount(String id,String firstName, String userName, String lastName, String age, String address,
			String mobileNumber, String emailId,String dateOfBirth, double balance) 
	{
		long pin = (long) (Math.random()*10000);
		System.out.println("Pin generated is :"+pin);
		long accNumber = (long)(Math.random()*1000000000);
		System.out.println("Account Number :"+accNumber);
		Account a1 = new Account(id,firstName,userName,lastName,age, address,mobileNumber, emailId,dateOfBirth,pin, balance);
		map.put(id, a1);
		System.out.println(map);
		System.out.println("Account created successfully...");
	}
	public void addMoney(String id,double amount) {
		Account entry = map.get(id);
		if(entry.getId().equals(id)) {
			double bal = entry.getBalance()+amount;
			System.out.println("amount "+amount+" credited successfully");
			entry.setBalnce(bal);
			System.out.println(map);
		}
		else 
		{
			System.out.println("invalid pin");
		}
		
	}

	public void withDrawMoney(String id,double amount) {
		Account entry = map.get(id);
		if(entry.getId().equals(id) && amount < entry.getBalance()) {
			double bal = entry.getBalance()-amount;
			System.out.println("amount "+amount+" withdraw successfully");
			entry.setBalnce(bal);
			System.out.println(map);
		}else {
			System.out.println("Invalid Id");
		}
	}
	
	public void closeAccount(String id,long pin) {
		Account entry3 = map.get(id);
		if(entry3.getId().equals(id) && entry3.getPin() == pin) {
			map.remove(id);
			System.out.println("Account closed successfully");
			System.out.println(map);
		}
		else {
			System.out.println("invalid id or username");
		}
	}
	
	public void viewBalnce(String id,String username,long pin) {
			Account entry = map.get(id);
			if(entry.getId().equals(id)&& entry.getUsername().equals(username) && entry.getPin() == pin) {
				System.out.println("Current balance is "+entry.getBalance());
				System.out.println(map);
			}
			else 
			{
				System.out.println("invalid username or id or pin");
			}
		
	}
	public void withDrawMoney(String id,String username,long pin ,double amount) {
		Account entry = map.get(id);
		if(entry.getId().equals(id) && entry.getUsername().equals(username) && entry.getPin() == pin && amount<entry.getBalance()) {
			double bal = entry.getBalance()-amount;
			System.out.println("amount "+amount+" withdraw successfully,total balnce is "+bal);
			entry.setBalnce(bal);
			System.out.println(map);
		}
		else {
			System.out.println("invalid username or id or pin or insufficient balnce to wthdraw money");
		}
	}
	
}
