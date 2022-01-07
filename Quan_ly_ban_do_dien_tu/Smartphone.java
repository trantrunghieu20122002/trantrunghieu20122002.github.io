package Quan_ly__ban_dien_thoai;

import java.io.Serializable;
import java.util.Scanner;

public class Smartphone extends Products implements Serializable{
	private String Battery;
	private String Camera;
	public Smartphone() {
		
	}
	public Smartphone(String Product_id, String Brand_name, String Product_name, String OS,String CPU, String Ram, String Battery, String Camera) {
		super(Product_id, Brand_name, Product_name, OS, CPU, Ram);
		this.Battery = Battery;
		this.Camera = Camera;
	}
	@Override
	public long getSellingPrice() {		
		return (long) (Price + (Price*6/100) +Price * Tax);
	}
	@Override
	public void PrintProduct() {
		super.PrintProduct();
		System.out.println("Pin: " + Battery);
		System.out.println("Camera: " + Camera);
		System.out.println("Giá bán: " + getSellingPrice());
	}
	@Override 
	public void Insert() {
		Scanner sc = new Scanner(System.in);
		super.Insert();
		System.out.print("Nhap dung luong pin: ");
		Battery = sc.next();
		System.out.print("Nhap do phan giai camera: ");
		Camera = sc.next();
	}
	public void setBattery(String Battery) {
		this.Battery = Battery;
	}
	public String getBattery() {
		return Battery;
	}
	public void setCamera(String Camera) {
		this.Camera = Camera;
	}
	public String getCamera() {
		return Camera;
	}
	@Override
	public String getFileLine() {
        return super.getFileLine() + " " + Battery + " " +Camera;
    }
}
