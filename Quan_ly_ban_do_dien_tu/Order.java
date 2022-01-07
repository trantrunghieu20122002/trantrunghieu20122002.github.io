package Quan_ly__ban_dien_thoai;

import java.util.Date;

public class Order {
	private int OrderID;
	Date date;
	private long TotalPrice;
	private String PurchasedProductID;
	public Order() {
		date = new Date();
		setOrderID((int) Math.floor(((Math.random() * 899999) + 100000))); //tao 6 so ngau nhien 
	}
	public long getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getOrderID(){
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public void printOrder() {
		System.out.println("Mã đơn hàng: " + OrderID);
		System.out.println("Thời điểm đặt hàng: " + date);
		System.out.println("Mã sản phẩm: " + PurchasedProductID);
		System.out.println("Giá tiền: " + TotalPrice);
	}
	public String getPurchasedProductID() {
		return PurchasedProductID;
	}
	public void setPurchasedProductID(String purchasedProductID) {
		PurchasedProductID = purchasedProductID;
	}
}
