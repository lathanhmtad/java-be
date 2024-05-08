package Model;

public class Item {
	private SANPHAM product;
	private int quantity;
	public SANPHAM getProduct() {
		return product;
	}
	public void setProduct(SANPHAM product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(SANPHAM product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}
	
}
