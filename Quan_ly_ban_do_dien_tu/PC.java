package Quan_ly__ban_dien_thoai;

import java.io.Serializable;
import java.util.Scanner;

public class PC extends Products implements Serializable{
	private String VGA;
	private String Keyboard;
	private String Case;
	public PC() {
		
	}
	public PC(String Product_id, String Brand_name, String Product_name, String OS,String CPU, String Ram, String VGA, String Keyboard, String Case) {
		super(Product_id, Brand_name, Product_name, OS, CPU, Ram);
		this.VGA = VGA;
		this.Keyboard = Keyboard;
		this.Case = Case;
	}
	@Override
	public long getSellingPrice() {		
		return (long) (Price + (Price*8/100) + Price * Tax);
	}
	@Override
	public void PrintProduct() {
		super.PrintProduct();
		System.out.println("VGA: " + VGA);
		System.out.println("Ban phim: " + Keyboard);
		System.out.println("Vo case: " + Case);
		System.out.println("Giá bán: " + getSellingPrice());
	}
	@Override 
	public void Insert() {
		Scanner sc = new Scanner(System.in);
		super.Insert();
		System.out.print("Nhap VGA: ");
		VGA= sc.next();
		System.out.print("Nhap ban phim: ");
		Keyboard = sc.next();
		System.out.print("Nhap vo case: ");
		Case = sc.next();
	}
	public void setVGA(String VGA) {
		this.VGA = VGA;
	}
	public String getVGA() {
		return VGA;
	}
	public void setKeyboard(String Keyboard) {
		this.Keyboard = Keyboard;
	}
	public String getKeyboard() {
		return Keyboard;
	}
	public void setCase(String Case) {
		this.Case = Case;
	}
	public String getCase() {
		return Case;
	}
	@Override
	public String getFileLine() {
        return super.getFileLine() + " " + VGA + " " + " " + Keyboard + " " +Case;
    }
}
