package Quan_ly__ban_dien_thoai;

import java.util.Scanner;

public abstract class Products implements IInsert{
	protected String Brand_name;
	private String Product_name;
	private String Product_id;	
	private String OS;
	private String CPU;
	private String Ram;
	protected static float Tax = 10/100;
	protected long Price;
	Scanner sc = new Scanner(System.in);
	public Products() {
		
	}
	public Products(String Product_id, String Brand_name, String Product_name, String OS,String CPU, String Ram) {
		this.Brand_name = Brand_name;
		this.Product_id = Product_id;
		this.OS = OS;
		this.CPU = CPU;
		this.Ram = Ram;
	}
	public void Insert() {
		System.out.print("Nhap ten hang: ");
		Brand_name = sc.nextLine();
		System.out.print("Nhap ten san pham: ");
		Product_name = sc.nextLine();
		System.out.print("Nhap ma san pham: ");
		Product_id = sc.nextLine();
		System.out.print("Nhap he dieu hanh: ");
		OS = sc.nextLine();
		System.out.print("Nhap CPU: ");
		CPU = sc.nextLine();
		System.out.print("Nhap ram: ");
		Ram = sc.nextLine();
		System.out.print("Nhap gia ban: ");
		Price = Long.parseLong(sc.nextLine());
	}
	public static void showTax() {
		System.out.println("Thuế: " + Tax);
	}
	public void PrintProduct() {
		System.out.println("Ten hang: " + Brand_name);
		System.out.println("Ten san pham: " + Product_name);
		System.out.println("Ma san pham: " + Product_id);
		System.out.println("He dieu hanh: " + OS);
		System.out.println("CPU: " + CPU);
		System.out.println("Ram: " + Ram);
		showTax();
	}
	public void setBrand_name(String Brand_name) {
		this.Brand_name = Brand_name;		
	}
	public String getBrand_name() {
		return Brand_name;
	}
	public void setProduct_name(String Product_name) {
		this.Product_name = Product_name;		
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_id(String Product_id) {
		this.Product_id = Product_id;		
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setPrice(long Price) {
		this.Price = Price;		
	}
	public long getCost() {
		return Price;
	}
	public void setOs(String OS) {
		this.OS = OS;		
	}
	public String getOs() {
		return OS;
	}
	public void setCpu(String CPU) {
		this.CPU = CPU;		
	}
	public String getCpu() {
		return CPU;
	}
	public void setRam(String Ram) {
		this.Ram = Ram;		
	}
	public String getRam() {
		return Ram;
	}
	public abstract long getSellingPrice();
	public String getFileLine() {
        return Product_id + " " + Brand_name + " " + Product_name + " " + OS + " " + CPU + " " +  Ram;
    }
}
