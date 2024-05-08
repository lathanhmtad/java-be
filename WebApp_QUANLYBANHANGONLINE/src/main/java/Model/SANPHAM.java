package Model;

public class SANPHAM {
	int masanpham;
	String tensanpham;
	double dongia;
	double soluong;
	String hinhanh;
	String mota;
	int madanhmuc;
	public SANPHAM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SANPHAM(int masanpham, String tensanpham, double dongia, double soluong, String hinhanh, String mota,
			int madanhmuc) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.dongia = dongia;
		this.soluong = soluong;
		this.hinhanh = hinhanh;
		this.mota = mota;
		this.madanhmuc = madanhmuc;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public double getSoluong() {
		return soluong;
	}
	public void setSoluong(double soluong) {
		this.soluong = soluong;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	@Override
	public String toString() {
		return "SANPHAM [masanpham=" + masanpham + ", tensanpham=" + tensanpham + ", dongia=" + dongia + ", soluong="
				+ soluong + ", hinhanh=" + hinhanh + ", mota=" + mota + ", madanhmuc=" + madanhmuc + "]";
	}
}
