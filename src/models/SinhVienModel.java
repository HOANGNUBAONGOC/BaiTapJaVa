package models;

public class SinhVienModel {
	private String HoTen;
	private int Tuoi;
	private String Lop;
	
	public SinhVienModel() {
	}
	
	public SinhVienModel(String hoTen, int tuoi, String lop) {
		super();
		HoTen = hoTen;
		Tuoi = tuoi;
		Lop = lop;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getTuoi() {
		return Tuoi;
	}
	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	@Override
	public String toString() {
		return "SinhVien [HoTen=" + HoTen + ", Tuoi=" + Tuoi + ", Lop=" + Lop + "]";
	}


}


