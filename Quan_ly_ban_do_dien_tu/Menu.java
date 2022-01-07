package Quan_ly__ban_dien_thoai;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu implements Imenu{
	ListProduct listproduct = new ListProduct();
	ListCustomer listcustomer = new ListCustomer();
	public Menu() throws FileNotFoundException {
		listproduct.ReadFile();
                listproduct.WriteFile();
		listcustomer.ReadFile();       
                listcustomer.WriteFile();  
	}
	public void showMenu() {
		System.out.println("**************************MENU KHÁCH HÀNG**************************");
        System.out.println("________________________________________________________");
        System.out.println("| 1. Mở menu sản phẩm                                  |");
        System.out.println("| 2. Mở menu khách hàng                                |");       
        System.out.println("| 0. Thoát                                             |");   
        System.out.println("________________________________________________________");
        System.out.print("VUI LÒNG NHẬP LỰA CHỌN : ");
	}
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int choose = -1;
		showMenu();
	    boolean exit = false; 	        	    
	     while (true) {	    
	     choose = sc.nextInt();
	     switch (choose) {
	     case 1:
	    	 listproduct.menu();
	    	 break;
	     case 2:
	    	 listcustomer.menu();
	    	break;	     
	     case 0:
	    	 System.out.println("Đã thoát khỏi menu!");
	    	 exit = true;
	    	 break;
	     default:
	    	 System.out.println("Không hợp lê! Vui lòng chọn lại!!");
	    	 break;
	     }
	     if (exit) {
	    	 break;
	     }
	     showMenu();
	     }
		}
}

