package samle_project;

import java.util.ArrayList;
import java.util.Scanner;

public class Banking {
	 int Accno;
	private String Acc_holder_name;
	 int Accpin;
	  int AvailableBalance;
	
	static ArrayList<Banking> list=new ArrayList<Banking>();
 static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int acno=1000;
		show();
		int c=sc.nextInt();
		String s;
        if(c>5)
        	System.out.println("Invalid Input");
       
        
        try {        	    		       	
        	 switch(c) {
        		
        		case 1:
        			
        			String acc_holder_name;
        			int accno;
        			int accpin;
        			int availableBalance=0;
        			accno=1000 + (int)(Math.random() * ((2000 - 1000) + 1));
        			//Accno=accno;
        		System.out.println("Enter your Name:");
        		acc_holder_name=sc.next();
        		System.out.println("Enter your account pin:");
        		accpin=sc.nextInt();
        		availableBalance=0;
        		list.add(new Banking(accno,acc_holder_name,accpin,availableBalance));
        		for(Banking b:list) {
        			System.out.println("your generated Account number:"+b.getAccno());
        		}
        		       		
        		        			
        			break;
        		case 2:
        			int accno1;
        			int accpin1;
        		System.out.println("Enter your Account no:");
        		accno1=sc.nextInt();
        		System.out.println("Enter your pin");
        			accpin1=sc.nextInt();
        			validate(accno1,accpin1);
        		
            	break;
        		case 3:
        			int accno3;
        			int accpin3;
        			System.out.println("Enter Account number:");
        			accno3=sc.nextInt();
        			System.out.println("Enter Account pin:");
        			accpin3=sc.nextInt();
        			System.out.println("Enter Amount to Deposit");
        			int Amount=sc.nextInt();
        			Deposit(accno3,accpin3,Amount);
        			
        			break;
        		case 4:
        			int accno4;
        			int accpin4;
        			System.out.println("Enter Account number:");
        			accno4=sc.nextInt();
        			System.out.println("Enter Account pin:");
        			accpin4=sc.nextInt();
        			System.out.println("Enter Amount to withdraw");
        			int WAmount=sc.nextInt();
        			withdraw(accno4,accpin4,WAmount);
        			break;
        		case 5:
        			System.exit(0);
        		}
        		System.out.println("do you want to continue Y/N");
                s=sc.next();
                if(s.equals("y")) {
               	 main(null);
                }
                else {
               	 System.exit(0);
                }
        		
        }
        
        catch(Exception e) {
        	System.out.println(e);
        }
        
      
	}
	
	private static void Deposit(int accno3, int accpin3,int Amount) {
		for(int i=0;i<list.size();i++) {
			String n=list.get(i).getAcc_holder_name();
			int x=list.get(i).getAccno();
			int y=list.get(i).getAccpin();
			int z=list.get(i).getAvailableBalance();
	    	if(x==accno3&&y==accpin3) {
	    	
	    	z=z+Amount;
	    	list.set(i,new Banking(x,n,y,z));
	    	System.out.println("Availbale Balance: "+z);
	    	}
	    	else {
	    		System.out.println("Invalid pin");
	    	}
		
	}
	}




	private static void withdraw(int accno4, int accpin4, int wAmount) {
		for(int i=0;i<list.size();i++) {
			String n=list.get(i).getAcc_holder_name();
			int x=list.get(i).getAccno();
			int y=list.get(i).getAccpin();
			int z=list.get(i).getAvailableBalance();
	    	if(x==accno4&&y==accpin4) {
	    		
	    	if(z>=wAmount) {
	    		z=z-wAmount;
	    		System.out.println("Available Balance: "+z);
	    		list.set(i,new Banking(x,n,y,z));
	    	}
	    	else {
	    		System.out.println("no sufficient balance ");
	    	}
	    		
	    	}
	    	else {
	    		System.out.println("Invalid pin");
	    	}
		
	}
	}

	public void setAccno(int accno) {
		Accno = accno;
	}

	public void setAcc_holder_name(String acc_holder_name) {
		Acc_holder_name = acc_holder_name;
	}

	public void setAccpin(int accpin) {
		Accpin = accpin;
	}

	public  void setAvailableBalance(int availableBalance) {
		AvailableBalance = availableBalance;
	}

	private static void validate(int accno1, int accpin1) {
		for(int i=0;i<list.size();i++) {
			int x=list.get(i).getAccno();
			int y=list.get(i).getAccpin();
	    	if(x==accno1&&y==accpin1) {
	    		System.out.println("Account holder name: "+list.get(i).getAcc_holder_name());
	    		System.out.println("Account Number: "+list.get(i).getAccno());
	    		System.out.println("Availbale Balance: "+list.get(i).getAvailableBalance());
	    	}
	    	else {
	    		System.out.println("invalid pin");
	    	}
		    
		}  		       		
	}


	public Banking(int accno, String acc_holder_name, int accpin, int availableBalance) {
		super();
		this.Accno = accno;
		this.Acc_holder_name = acc_holder_name;
		this.Accpin = accpin;
		this.AvailableBalance = availableBalance;
	}

	public int getAccno() {
		return Accno;
	}

	public String getAcc_holder_name() {
		return Acc_holder_name;
	}

	public int getAccpin() {
		return Accpin;
	}

	public int getAvailableBalance() {
		return AvailableBalance;
	}

	public static void show() {
		System.out.println("1.Create Account");
		System.out.println("2.Available Balance");
		System.out.println("3.Credit/Debit");
		System.out.println("4.Withdraw");
		System.out.println("5.Exit");
		
	}
	

}
