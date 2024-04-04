package controller;

import models.TheMuonModel;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TheMuonController {
    private static Collection<TheMuonModel> DanhSachTheMuon = new HashSet<>();

    public static void ThemTheMuon(TheMuonModel themuon) {
        DanhSachTheMuon.add(themuon);
        System.out.println("Thêm thẻ mượn thành công.");
    }

    public static void XoaTheMuon(String MaPhieuMuon) {
        boolean xoa = DanhSachTheMuon.removeIf(themuon -> themuon.getMaPhieuMuon().equals(MaPhieuMuon));
        if (xoa) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Thẻ không tồn tại!");
        }
    }

    public static Collection<TheMuonModel> getAllTheMuons() {
        return DanhSachTheMuon;
    }

    public static Collection<TheMuonModel> timTheMuonTheoMaPhieuMuon(String MaPhieuMuon) {
        return DanhSachTheMuon.stream()
                              .filter(themuon -> themuon.getMaPhieuMuon().equals(MaPhieuMuon))
                              .collect(Collectors.toSet());
    }
}
