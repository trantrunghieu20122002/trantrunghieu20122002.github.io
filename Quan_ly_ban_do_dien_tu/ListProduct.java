package Quan_ly__ban_dien_thoai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ListProduct implements Imenu{
    Products[] ListProduct;    
    int n;
    int m = 0;
    Order[] ListOrder = new Order[m];
    Scanner sc = new Scanner(System.in);
    
public void WriteFile() throws FileNotFoundException{
    File pointFile = new File("dataInfoProduct.txt");
    PrintStream writter = new PrintStream(pointFile);
    for(int i=0;i<n;i++)
    {
        writter.println("Sản Phẩm thứ "+(i+1)+" : ");
        writter.println("Tên hãng : "+ListProduct[i].Brand_name); 
        writter.println("Tên sản phẩm : "+ListProduct[i].getProduct_name());
        writter.println("Mã ID : "+ListProduct[i].getProduct_id());
        writter.println("Hệ điều hành : "+ListProduct[i].getOs());
        writter.println("CPU : "+ListProduct[i].getCpu());
        writter.println("Ram : "+ListProduct[i].getRam());
               
        if(ListProduct[i] instanceof Laptop){
            writter.println("VGA : "+( (Laptop)ListProduct[i]).getVGA() );
            writter.println("Bàn phím : "+( (Laptop)ListProduct[i]).getKeyboard() );
            writter.println("Camera : "+( (Laptop)ListProduct[i]).getCamera() );
            writter.println();
        }
        
        else if(ListProduct[i] instanceof PC){
            writter.println("VGA : "+( (PC)ListProduct[i]).getVGA() );
            writter.println("Bàn phím : "+( (PC)ListProduct[i]).getKeyboard() );
            writter.println("Case : "+( (PC)ListProduct[i]).getCase() );
            writter.println();
        }
        
        else if(ListProduct[i] instanceof Smartphone){
            writter.println("Pin : "+( (Smartphone)ListProduct[i]).getBattery() );
            writter.println("Camera : "+( (Smartphone)ListProduct[i]).getCamera() );
            writter.println();
        }
    }
}
    
    
    public void ReadFile() throws FileNotFoundException 
    {
        File file = new File("dataProduct.txt");       
        Scanner sc = new Scanner(file);
        if(sc.hasNextInt()){
            n =  sc.nextInt();
        }
        ListProduct = new Products[n];
        int i = 0;
            while(sc.hasNext()){            
                String chose = sc.nextLine();               
                switch(chose){
    			case "1":
    				ListProduct[i] = new Laptop();
    				ListProduct[i].setBrand_name(sc.nextLine());
    				ListProduct[i].setProduct_id(sc.nextLine());
    				ListProduct[i].setProduct_name(sc.nextLine());
    				ListProduct[i].setOs(sc.nextLine());
    				ListProduct[i].setCpu(sc.nextLine());
    				ListProduct[i].setRam(sc.nextLine());				    				
    				((Laptop) ListProduct[i]).setVGA(sc.nextLine());
    				((Laptop) ListProduct[i]).setCamera(sc.nextLine());
    				((Laptop) ListProduct[i]).setKeyboard(sc.nextLine());
    				((Laptop) ListProduct[i]).setPrice(Long.parseLong(sc.nextLine()));
    				i++;
    				break;
    			case "2":
    				ListProduct[i] = new PC();

    				ListProduct[i].setBrand_name(sc.nextLine());
    				ListProduct[i].setProduct_id(sc.nextLine());
    				ListProduct[i].setProduct_name(sc.nextLine());
    				ListProduct[i].setOs(sc.nextLine());
    				ListProduct[i].setCpu(sc.nextLine());
    				ListProduct[i].setRam(sc.nextLine());
    				((PC) ListProduct[i]).setVGA(sc.nextLine());
    				((PC) ListProduct[i]).setCase(sc.nextLine());
    				((PC) ListProduct[i]).setKeyboard(sc.nextLine());
    				((PC) ListProduct[i]).setPrice(Long.parseLong(sc.nextLine()));
    				i++;
    				break;
    			case "3":
    				ListProduct[i] = new Smartphone();
    				ListProduct[i].setBrand_name(sc.nextLine());
    				ListProduct[i].setProduct_id(sc.nextLine());
    				ListProduct[i].setProduct_name(sc.nextLine());
    				ListProduct[i].setOs(sc.nextLine());
    				ListProduct[i].setCpu(sc.nextLine());
    				ListProduct[i].setRam(sc.nextLine());
    				((Smartphone) ListProduct[i]).setBattery(sc.nextLine());
    				((Smartphone) ListProduct[i]).setCamera(sc.nextLine());
    				((Smartphone) ListProduct[i]).setPrice(Long.parseLong(sc.nextLine()));
    				i++;
    				break;
    			default:
    				break;
    			}            
            }
    }
    public ListProduct(){
    	
    }
    public void showProductList(){
    	for(int i = 0; i < ListProduct.length; i++){   
            System.out.println("======== XUẤT SẢN PHẨM THỨ "+ (i + 1) +" =========");
            if(ListProduct[i]==null)
               break;
            ListProduct[i].PrintProduct();
        }   
    }
    
    public void addProduct(){   
    	System.out.println("================= NHẬP SỐ LƯỢNG SẢN PHẨM MUỐN THÊM =================");
        System.out.print("Số lượng: ");
        int chose = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < chose; i++){
        	ListProduct = Arrays.copyOf(ListProduct, n+1);
            System.out.println("Nhập 1 để thêm Laptop === Nhập 2 để thêm PC === Nhập 3 để thêm Smartphone");
            System.out.print("Nhập lựa chọn: ");
            int choose = Integer.parseInt(sc.nextLine());
            System.out.println("Sản phẩm thứ "+(n+1)+" :");
            switch(choose){
                case 1:
                	ListProduct[n] = new Laptop();
                	ListProduct[n].Insert();
                    break;
                case 2:
                	ListProduct[n] = new PC();
                	ListProduct[n].Insert();
                    break;
                case 3:
                	ListProduct[n] = new Smartphone();
                	ListProduct[n].Insert();
                    break;
            }         
           n++;      
        }
        System.out.println("================= KẾT THÚC NHẬP SẢN PHẨM=================\n");
    }

    
    public void deleteProduct(){
        System.out.print("Nhập ID sản phẩm muốn xóa: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        for(int i = 0; i < n; i++){
            if(ListProduct[i].getProduct_id().equals(id)){
            	isExisted = true;
                for(int j=i;j<n-1;j++)
                ListProduct[j] = ListProduct[j+1];
                ListProduct = Arrays.copyOf(ListProduct, n-1);
                n--;
                break;
            }
        }
        if (!isExisted) {
                System.out.println("Sản phẩm có ID "+id + " không tồn tại!!");
            }
	}
    public void deleteProduct(String id){
    	for(int i = 0; i < n; i++){
            if(ListProduct[i].getProduct_id().equals(id)){
                for(int j=i;j<n-1;j++)
                ListProduct[j] = ListProduct[j+1];
                ListProduct = Arrays.copyOf(ListProduct, n-1);
                n--;
                break;
            }
	}
    }
    public void editProduct() {	
		System.out.print("Nhập mã sản phẩm muốn chỉnh sửa: ");
		String id = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
        	if(ListProduct[i] == null) break;
        	if(ListProduct[i].getProduct_id().equals(id)) {
                isExisted = true;
                ListProduct[i].Insert();
                break;
            }
        }
        if (!isExisted) {
        	System.out.println("Sản phẩm có ID là"+ id + " không tồn tại");
        }
	}
    public void searchProductID() {
		System.out.print("Nhập ID sản phẩm muốn tìm kiếm: ");
		String id = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
			if(ListProduct[i] == null) {
				break;
			}
			if(ListProduct[i].getProduct_id().equals(id)) {		
				isExisted = true;
				ListProduct[i].PrintProduct();
				break;
			}
		}	
        if (!isExisted) {
        	 System.out.println("Sản phẩm có ID là"+ id + " không tòn tại");
        }
	}
    public void searchProductName() {
		System.out.print("Nhập tên sản phẩm muốn tìm kiếm: ");
		String name = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
			if(ListProduct[i] == null) {
				break;
			}
			if(ListProduct[i].getProduct_name().equals(name)) {	
				isExisted = true;
				ListProduct[i].PrintProduct();
				break;
			}
		}	
        if (!isExisted) {
        	 System.out.println("Sản phẩm có tên " + name + " không tồn tại ");
        }
	}
    public void searchPrice() {
    	System.out.print("Nhập Min giá sản phẩm cần tìm kiếm: ");
        long min=Long.parseLong(sc.nextLine());
        System.out.print("Nhập Max giá sản phẩm cần tìm kiếm: ");
        long max=Long.parseLong(sc.nextLine());
        for(int i=0;i<ListProduct.length;i++){
            if(ListProduct[i].getSellingPrice()>min && ListProduct[i].getSellingPrice()<max){
            	
                System.out.println("Sản phẩm thứ "+(i+1)+" :");
                ListProduct[i].PrintProduct();
                System.out.println();
            }
        }	     
    }
    public void addOrder(String purchasedProductID, long sellingprice) {	        
        ListOrder = Arrays.copyOf(ListOrder, m+1); 
        ListOrder[m] = new Order();
        ListOrder[m].setPurchasedProductID(purchasedProductID);
        ListOrder[m].setTotalPrice(sellingprice); 
        m++;
	}
    public void order() {
		showProductList();
		System.out.println("Chọn sản phẩm muốn mua bằng mã sản phẩm: ");
		String choose = sc.nextLine();
		boolean isExisted = false;
		for(int i = 0; i < n; i++) {
			if(ListProduct[i] == null) {
				break;
			}
			if(ListProduct[i].getProduct_id().equals(choose)) {		
				isExisted = true;
				String id = ListProduct[i].getProduct_id();
				long price = ListProduct[i].getSellingPrice();
				addOrder(id, price);	
				deleteProduct(id);
				break;
			}
		}	
        if (!isExisted) {
        	 System.out.println("Sản phẩm có ID là "+ choose + " không tổn tại");        	 
        }
        else System.out.println("Đã đặt mua sản phẩm có ID là " + choose);
        
	}
    public void showOrderlist() {
    	for(int i = 0; i < ListOrder.length; i++){   
    		if(ListOrder[i] == null) break;
            System.out.println("======== ĐƠN HÀNG THỨ "+ (i + 1) +" =========");                           
            ListOrder[i].printOrder();
        }
    }
    public void showMenu() {
    	System.out.println("**************************MENU SẢN PHẨM**************************");
        System.out.println("________________________________________________________");
        System.out.println("| 1. Xóa thông tin sản phẩm bằng ID                    |");
        System.out.println("| 2. Chỉnh sửa thông tin sản phẩm bằng ID              |");
        System.out.println("| 3. Thêm sản phẩm                                     |");
        System.out.println("| 4. Tìm kiếm sản phẩm bằng ID                         |");
        System.out.println("| 5. Tìm kiếm sản phẩm bằng Tên                        |");
        System.out.println("| 6. Tìm kiếm sản phẩm bằng giá bán                    |");
        System.out.println("| 7. Hiển thị tất cả sản phẩm hiện có                  |");
        System.out.println("| 8. Chọn sản phẩm muốn đặt mua		                   |");
        System.out.println("| 9. Hiển thị danh sách sản phẩm đã đặt mua            |");
        System.out.println("| 0. Thoát Menu sản phẩm                               |");
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
	    	 deleteProduct();
	    	 break;
	     case 2:
	    	 editProduct();
	    	break;
	     case 3:
	    	 addProduct();
	    	 break;
	     case 4:
	    	 searchProductID();
	    	 break;
	     case 5:
	    	 searchProductName();
	    	 break;
	     case 6:
	    	 searchPrice();
	    	 break;
	     case 7:
	    	 showProductList();
	    	 break;
	     case 8:
	    	 order();
	    	 break;
	     case 9:
	    	 showOrderlist();
	    	 break;
	     case 0:
	    	 System.out.println("Đã thoát khỏi menu sản phẩm!");
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
