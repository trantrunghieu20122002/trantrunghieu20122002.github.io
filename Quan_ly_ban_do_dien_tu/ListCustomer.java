package Quan_ly__ban_dien_thoai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ListCustomer implements Imenu{
	int n = 10;
    Customer[] ListCustomer;
    Scanner sc = new Scanner(System.in);
    
    
    public void WriteFile() throws FileNotFoundException{
    File pointFile = new File("dataInfoCustomer.txt");
    PrintStream writter = new PrintStream(pointFile);
        for(int i=0;i<n;i++)
        {
            writter.println("Khách hàng thứ "+(i+1)+" : ");
            writter.println("Mã khách hàng : "+ListCustomer[i].getCustomerID());
            writter.println("Tên khách hàng : "+ListCustomer[i].getName());
            writter.println("Email khách hàng : "+ListCustomer[i].getEmail());
            writter.println("Địa chỉ khách hàng : "+ListCustomer[i].getAddress());
            writter.println("Số điện thoại khách hàng : "+ListCustomer[i].getMobileNum());
            writter.println();
        }
    }
    
    public void ReadFile() throws FileNotFoundException{
        File file = new File("dataCustomer.txt");         
        Scanner sc = new Scanner(file);              
        ListCustomer = new Customer[n];
        int i = 0;
        while(sc.hasNext()){        	
        	ListCustomer[i] = new Customer();
            ListCustomer[i].setCustomerId(sc.nextLine());
            ListCustomer[i].setName(sc.nextLine());
            ListCustomer[i].setEmail(sc.nextLine());
            ListCustomer[i].setAddress(sc.nextLine());
            ListCustomer[i].setMobileNum(sc.nextLine());          
            i++;
        }
    }
    public ListCustomer(){
    	
    }
    public void addCustomer(){
    	System.out.println("================= NHẬP SỐ LƯỢNG KHÁCH HÀNG MUỐN THÊM =================");
        System.out.print("Nhập số lượng: ");
        int chose = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < chose; i++){
        	ListCustomer = Arrays.copyOf(ListCustomer, n + 1);
            ListCustomer[n] = new Customer();
        	ListCustomer[n].Insert();
            n++;
        }                 
        System.out.println("===================== KẾT THÚC THÊM KHÁCH HÀNG =====================\n");   
    }
        
	
    public void deleteCustomer(){
    	System.out.print("Nhập ID khách hàng muốn xóa: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        for(int i = 0; i < n; i++){
            if(ListCustomer[i].getCustomerID().equals(id)){
            	isExisted = true;
                for(int j=i;j<n-1;j++)
                ListCustomer[j] = ListCustomer[j+1];
                ListCustomer = Arrays.copyOf(ListCustomer, n-1);
                n--;
                break;
            }       
        }
        if (!isExisted) {
        	System.out.println("Khách hàng có " + id + " không tồn tại");
        }
    }
    public void editCustomer() {	
    	System.out.print("Nhập ID khách hàng muốn chỉnh sửa: ");
		String id = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
        	if(ListCustomer[i] == null) break;
        	if(ListCustomer[i].getCustomerID().equals(id)) {
                isExisted = true;
                ListCustomer[i].Insert();
                break;
            }
        }
        if (!isExisted) {
        	System.out.println("Khách hàng có ID là"+ id + " không tồn tại");
        }
	}
    public void searchCustomerID(){
    	System.out.print("Nhập ID khách hàng muốn tìm kiếm: ");
		String id = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
			if(ListCustomer[i] == null) {
				break;
			}
			if(ListCustomer[i].getCustomerID().equals(id)) {
				isExisted = true;
				ListCustomer[i].PrintCustomer();
				break;
			}
		}	
        if (!isExisted) {
        	 System.out.println("Khách hàng có ID là"+ id + " không tòn tại");
        }
    }
    public void searchCustomerMobileNum(){
    	System.out.print("Nhập số điện thoại khách hàng muốn tìm kiếm: ");
		String num = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
			if(ListCustomer[i] == null) {
				break;
			}
			if(ListCustomer[i].getMobileNum().equals(num)) {
				isExisted = true;
				ListCustomer[i].PrintCustomer();
				break;
			}
		}	
        if (!isExisted) {
        	 System.out.println("Khách hàng có số điện thoại là"+ num + " không tồn tại");
        }
    }
    public void showCustomerList(){
        for(int i = 0; i < ListCustomer.length; i++)
        {   
            System.out.println("======== THÔNG TIN KHÁCH HÀNG THỨ  "+ (i + 1) +" =========");
            if(ListCustomer[i] == null)
               break;
            ListCustomer[i].PrintCustomer();
        }   
    }
    public void showMenu() {
    	System.out.println("**************************MENU KHÁCH HÀNG**************************");
        System.out.println("________________________________________________________");
        System.out.println("| 1. Xóa thông tin khách hàng bằng ID                  |");
        System.out.println("| 2. Chỉnh sửa thông tin khách hàng bằng ID            |");
        System.out.println("| 3. Thêm khách hàng                                   |");
        System.out.println("| 4. Tìm kiếm khách hàng bằng ID                       |");
        System.out.println("| 5. Tìm kiếm khách hàng bằng số điện thoại            |");
        System.out.println("| 6. Hiển thị thông tin tất cả khách hàng hiện có      |");
        System.out.println("| 0. Thoát Menu khách hàng                             |");
        System.out.println("________________________________________________________");
        System.out.print("VUI LÒNG NHẬP LỰA CHỌN : ");
    }
    public void menu(){		
		Scanner sc = new Scanner(System.in);
		int choose = -1;
		showMenu();
	    boolean exit = false; 	        	    
	     while (true) {	    
	     choose = sc.nextInt();
	     switch (choose) {
	     case 1:
	    	 deleteCustomer();
	    	 break;
	     case 2:
	    	 editCustomer();
	    	break;
	     case 3:
	    	 addCustomer();
	    	 break;
	     case 4:
	    	 searchCustomerID();
	    	 break;
	     case 5:
	    	 searchCustomerMobileNum();
	    	 break;
	     case 6:
	    	 showCustomerList();
	    	 break;
	     case 0:
	    	 System.out.println("Đã thoát khỏi menu khách hàng!");
	    	 exit = true;
	    	 break;
	     default:
	    	 System.out.println("Không hợp lệ! Vui lòng chọn lại!!!");
	    	 break;
	     }
	     if (exit) {
	    	 break;
	     }
	     showMenu();
	     }
		}
}