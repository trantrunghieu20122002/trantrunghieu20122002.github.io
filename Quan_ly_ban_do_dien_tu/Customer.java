package Quan_ly__ban_dien_thoai;
import java.util.Scanner;

public class Customer implements IInsert{
	    private String CustomerID;
	    private String Name;
	    private String Email;
	    private String Address;
	    private String MobileNum;
	    Scanner sc = new Scanner(System.in);
	    
	    public Customer(){
	    	CustomerID = null;
	        Name = null;
	        Email = null;
	        Address = null;
	        MobileNum = null;
	    }

	    public Customer(String CustomerID,String Name, String Email, String Address, String MobileNum) {
	        this.CustomerID = CustomerID;
	        this.Name = Name;
	        this.Email = Email;
	        this.Address = Address;
	        this.MobileNum = MobileNum;
	    }

	    public String getCustomerID() {
	        return CustomerID;
	    }
	    public void setCustomerId(String CustomerID) {
	        this.CustomerID = CustomerID;
	    }	   
	    public String getName() {
	        return Name;
	    }
	    public void setName(String Name) {
	        this.Name = Name;
	    }	  	   
	    public String getEmail() {
	        return Email;
	    }

	    public void setEmail(String Email) {
	        this.Email = Email;
	    }
	    public String getAddress() {
	        return Address;
	    }
	    public void setAddress(String Address) {
	        this.Address = Address;
	    }	 
	    public String getMobileNum() {
	        return MobileNum;
	    }
	    public void setMobileNum(String MobileNum) {
	        this.MobileNum = MobileNum;
	    }	    
	    public void Insert(){
	    	System.out.print("Nhập mã khách hàng: ");
			CustomerID = sc.nextLine();
			System.out.print("Nhập tên khách hàng: ");
			Name = sc.nextLine();
			System.out.print("Nhập email của khách hàng: ");
			Email = sc.nextLine();
			System.out.print("Nhập địa chỉ của khách hàng: ");
			Address = sc.nextLine();
			System.out.print("Nhập số điện thoại khách hàng: ");
			MobileNum = sc.nextLine();			
	    }
	    
	    public void PrintCustomer() {
			System.out.println("Mã khách hàng: " + CustomerID);
			System.out.println("Tên khách hàng: " + Name);
			System.out.println("Email khách hàng: " + Email);
			System.out.println("Địa chỉ: " + Address);
			System.out.println("Số điện thoại: " + MobileNum);		
		}	   	   
}
