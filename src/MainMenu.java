package src;
import java.io.BufferedReader;
import java.io.*;
public class MainMenu {
    public static void main(String args[]) throws Exception{
        menu();
    }
    public static void menu() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        QuanLyDanhSachSanPham dssanpham = new QuanLyDanhSachSanPham();
        QuanLyDSKhachHang dskhachhang = new QuanLyDSKhachHang();
        QuanLyDSNhanVien dsnhanvien = new QuanLyDSNhanVien();
        QuanLyDSCTHoaDon dschitiethoadon = new QuanLyDSCTHoaDon();
        QuanLyDanhSachHD dshoadon = new QuanLyDanhSachHD();
        QuanLyDanhSachNCC dsnhacungcap = new QuanLyDanhSachNCC();
        QuanLyDSCTPhieuNhap dschitietphieunhap = new QuanLyDSCTPhieuNhap();
        QuanLyDSPhieuNhap dsphieunhap = new QuanLyDSPhieuNhap();
        System.out.print("\nCHON DANH SACH DE THAO TAC \n");
        System.out.print(("0. THOAT \n"));
        System.out.print(("1. DANH SACH SAN PHAM \n"));
        System.out.print(("2. DANH SACH KHACH HANG \n"));
        System.out.print(("3. DANH SACH NHAN VIEN \n"));
        System.out.print(("4. DANH SACH CHI TIET HOA DON \n"));
        System.out.print(("5. DANH SACH HOA DON \n"));
        System.out.print(("6. DANH SACH NHA CUNG CAP \n"));
        System.out.print(("7. DANH SACH CHI TIET PHIEU NHAP \n"));
        System.out.print(("8. DANH SACH PHIEU NHAP \n"));
        int num = Integer.parseInt(in.readLine());
        switch(num){
            case 0:{
                System.out.print("Ban da thoat. \n");
                break;
            }
            case 1:{
                //dssanpham.nhap();
                dssanpham.menu();
                dssanpham.thuchien();
                menu();
                break;
            }
            case 2:{
                //dskhachhang.nhap();
                dskhachhang.menu();
                dskhachhang.thuchien();
                menu();
                break;
            }
            case 3:{
                //dsnhanvien.nhap();
                dsnhanvien.menu();
                dsnhanvien.thuchien();
                menu();
                break;
            }
            case 4:{
                //dschitiethoadon.nhap();
                dschitiethoadon.menu();
                dschitiethoadon.thuchien();
                menu();
                break;
            }
            case 5:{
                dshoadon.menu();
                dshoadon.thuchien();
                menu();
                break;
            }
            case 6:{
                dsnhacungcap.menu();
                dsnhacungcap.thuchien();
                menu();
                break;
            }
            case 7:{
                dschitietphieunhap.menu();
                dschitietphieunhap.thuchien();
                menu();
                break;
            }
            case 8:{
                dsphieunhap.menu();
                dsphieunhap.thuchien();
                menu();
                break;
            }
        }
    }
}