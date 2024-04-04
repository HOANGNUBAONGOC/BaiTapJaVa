package models;

public class TheMuonModel {
	private String MaPhieuMuon;
	private String NgayMuon;
	private String HanTra;
	private String SoHieuSach;
	private SinhVienModel sv;
	
	public TheMuonModel(String maPhieuMuon, String ngayMuon, String hanTra, String soHieuSach, SinhVienModel sV) {
		super();
		MaPhieuMuon = maPhieuMuon;
		NgayMuon = ngayMuon;
		HanTra = hanTra;
		SoHieuSach = soHieuSach;
		sv = sV;
	}

	public String getMaPhieuMuon() {
		return MaPhieuMuon;
	}
	public void setMaPhieuMuon(String maPhieuMuon) {
		MaPhieuMuon = maPhieuMuon;
	}
	public String getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(String ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public String getHanTra() {
		return HanTra;
	}
	public void setHanTra(String hanTra) {
		HanTra = hanTra;
	}
	public String getSoHieuSach() {
		return SoHieuSach;
	}
	public void setSoHieuSach(String soHieuSach) {
		SoHieuSach = soHieuSach;
	}
	public SinhVienModel getSV() {
		return sv;
	}
	public void setSV(SinhVienModel sV) {
		sv = sV;
	}

	@Override
	public String toString() {
		return "TheMuonModel [MaPhieuMuon=" + MaPhieuMuon + ", NgayMuon=" + NgayMuon + ", HanTra=" + HanTra
				+ ", SoHieuSach=" + SoHieuSach + ", sv=" + sv + "]";
	}
	

	
}


