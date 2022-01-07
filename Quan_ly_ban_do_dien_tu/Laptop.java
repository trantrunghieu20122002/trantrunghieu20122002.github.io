package Quan_ly__ban_dien_thoai;

import java.io.Serializable;
import java.util.Scanner;

public class Laptop extends Products implements Serializable{	
	private String VGA;
	private String Keyboard;
	private String Camera;
	public Laptop() {
		
	}
	public Laptop(String Product_id, String Brand_name, String Product_name, String OS,String CPU, String Ram, String VGA, String Keyboard, String Camera) {
		super(Product_id, Brand_name, Product_name, OS, CPU, Ram);
		this.VGA = VGA;
		this.Keyboard = Keyboard;
		this.Camera = Camera;
	}
	@Override
	public long getSellingPrice() {		
		return (long) (Price + (Price*6/100) + Price * Tax);
	}
	@Override
	public void PrintProduct() {
		super.PrintProduct();
		System.out.println("VGA: " + VGA);
		System.out.println("Ban phim: " + Keyboard);
		System.out.println("Camera: " + Camera);
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
		System.out.print("Nhap do phan giai camera: ");
		Camera = sc.next();
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
	public void setCamera(String Camera) {
		this.Camera = Camera;
	}
	public String getCamera() {
		return Camera;
	}
	@Override
	public String getFileLine() {
        return super.getFileLine() + " " + VGA + " " + " " + Keyboard + " " +Camera;
    }
	
}
