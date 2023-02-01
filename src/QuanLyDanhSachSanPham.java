package src;
import java.io.*;
class QuanLyDanhSachSanPham{
    DanhSachSanPham d_sach1 = new DanhSachSanPham();  
    int chucnang;
    public void nhap() throws Exception{
        d_sach1.nhap(); 
    }
    public void menu() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n=================================================================================================================================================");
        System.out.print("\nCAC CHUC NANG THAO TAC VOI DANH SACH SAN PHAM:");
        System.out.print("\n    0.Thoat");
        System.out.print("\n    1.Doc file san pham.");
        System.out.print("\n    2.Xem danh sach san pham.");
        System.out.print("\n    3.Them 1 hoac nhieu san pham.");
        System.out.print("\n    4.Xoa san pham.");
        System.out.print("\n    5.Sua thong tin san pham.");
        System.out.print("\n    6.Tim kiem san pham.");
        System.out.print("\n    7.Thong ke .");
        System.out.print("\n    8.Luu ket qua thao tac len file .");
        System.out.print("\n=================================================================================================================================================");
        System.out.print("\nNhap vao chuc nang muon thuc hien (Tu 0 cho den 8): ");
        chucnang = Integer.parseInt(in.readLine());
        while (chucnang<0 || chucnang>8){
            System.out.print("\nBan da nhap sai ma so chuc nang!");
            System.out.print("\nMoi nhap lai( Tu 0 cho den 6):");
            chucnang = Integer.parseInt(in.readLine());
        }
    }
    public void thuchien() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        switch(chucnang){
            case 0:{
                System.out.print("\nBan da thoat.");
                
                break;
            }
            case 1:{
                d_sach1.docFile();
                System.out.print("\nDoc file san pham");
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 2:{
                
                d_sach1.xuat();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 3:{
                d_sach1.them();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 4:{
                d_sach1.xoa();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 5:{
                d_sach1.sua();
                in.readLine();
                menu();
                thuchien();
                break; 
            }
            case 6:{
                System.out.print("\nCac thuoc tinh tim kiem:");
                System.out.print("\n1. Tim kiem theo ma san pham.");
                System.out.print("\n2. Tim kiem theo ten san pham (Co the nhap gan dung).");
                System.out.print("\n3. Tim kiem san pham theo gia.");
                System.out.print("\n4. Tim kiem theo loai su dung thuc an( Danh cho san pham thuc an ).");
                System.out.print("\n5. Tim kiem theo dang thuc an (Danh cho san pham thuc an).");
                System.out.print("\nChon thuoc tinh tim kiem: ");
                d_sach1.timkiem();
                in.readLine();
                menu();
                thuchien();
                break;   
            }
            case 7:{
                System.out.print("\nCac thuoc tinh thong ke:");
                System.out.print("\n1. Thong ke so luong cac san pham la thuc an.");
                System.out.print("\n2. Thong ke  so luong cac san pham la phu kien.");
                System.out.print("\nChon so thu tu thong ke: ");
                d_sach1.thongke();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 8:{
                d_sach1.ghifile();
                System.out.print("\nBan da cap nhat file thanh cong.");
                in.readLine();
                menu();
                thuchien();
                break;
            }
        }
    }
    

}