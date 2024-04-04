package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import models.SinhVienModel;
import models.TheMuonModel;
import controller.TheMuonController;

public class TheMuonView extends JFrame {
    private JPanel contentPane;
    private JTextField MaPhieuMuon;
    private JTextField NgayMuon;
    private JTextField HanTra;
    private JTextField SoHieuSach;
    private JTextField HoTen;
    private JTextField Tuoi;
    private JTextField Lop;
    private JTable table;

    public TheMuonView() {
        setTitle("Quản lý thẻ mượn sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel jp = new JPanel();
        contentPane.add(jp, BorderLayout.NORTH);

        JLabel lblMaPhieuMuon = new JLabel("Mã phiếu mượn:");
        jp.add(lblMaPhieuMuon);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(7, 2));
        JPanel jp2 = new JPanel();
        MaPhieuMuon = new JTextField();
        jp.add(MaPhieuMuon);
        MaPhieuMuon.setColumns(10);

        JLabel lblNgayMuon = new JLabel("Ngày mượn:");
        jp1.add(lblNgayMuon);

        NgayMuon = new JTextField();
        jp1.add(NgayMuon);
        NgayMuon.setColumns(10);

        JLabel lblHanTra = new JLabel("Hạn trả:");
        jp1.add(lblHanTra);

        HanTra = new JTextField();
        jp1.add(HanTra);
        HanTra.setColumns(10);

        JLabel lblSoHieuSach = new JLabel("Số hiệu sách:");
        jp1.add(lblSoHieuSach);

        SoHieuSach = new JTextField();
        jp1.add(SoHieuSach);
        SoHieuSach.setColumns(10);

        JLabel lblHoTen = new JLabel("Họ và tên:");
        jp1.add(lblHoTen);

        HoTen = new JTextField();
        jp1.add(HoTen);
        HoTen.setColumns(10);

        JLabel lblTuoi = new JLabel("Tuổi:");
        jp1.add(lblTuoi);

        Tuoi = new JTextField();
        jp1.add(Tuoi);
        Tuoi.setColumns(10);

        JLabel lblLop = new JLabel("Lớp:");
        jp1.add(lblLop);

        Lop = new JTextField();
        jp1.add(Lop);
        Lop.setColumns(10);

        JButton Them = new JButton("Thêm");
        Them.addActionListener(e -> {
            String maPhieuMuon = MaPhieuMuon.getText();
            String ngayMuon = NgayMuon.getText();
            String hanTra = HanTra.getText();
            String soHieuSach = SoHieuSach.getText();
            String hoTen = HoTen.getText();
            int tuoi = Integer.parseInt(Tuoi.getText());
            String lop = Lop.getText();

            SinhVienModel sv = new SinhVienModel(hoTen, tuoi, lop);
            TheMuonModel themuon = new TheMuonModel(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sv);
            TheMuonController.ThemTheMuon(themuon);

            refreshTable();
        });
        jp2.add(Them);

        JButton Xoa = new JButton("Xóa");
        Xoa.addActionListener(e -> {
            String maPhieuMuon = MaPhieuMuon.getText();
            TheMuonController.XoaTheMuon(maPhieuMuon);

            refreshTable();
        });
        jp2.add(Xoa);

        JButton Luu = new JButton("Lưu dữ liệu");
        Luu.addActionListener(e -> {
            refreshTable();
        });
        jp2.add(Luu);
        jp.add(jp1, BorderLayout.WEST);
        jp.add(jp2, BorderLayout.EAST);
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        initTable();
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã phiếu mượn");
        model.addColumn("Ngày mượn");
        model.addColumn("Hạn trả");
        model.addColumn("Số hiệu sách");
        model.addColumn("Họ và tên");
        model.addColumn("Tuổi");
        model.addColumn("Lớp");

        table.setModel(model);
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (TheMuonModel themuon : TheMuonController.getAllTheMuons()) {
            Vector<Object> row = new Vector<>();
            row.add(themuon.getMaPhieuMuon());
            row.add(themuon.getNgayMuon());
            row.add(themuon.getHanTra());
            row.add(themuon.getSoHieuSach());
            SinhVienModel sv = themuon.getSV();
            row.add(sv.getHoTen());
            row.add(sv.getTuoi());
            row.add(sv.getLop());
            model.addRow(row);
        }
    }

   
}
