package src;
import java.io.*;
class QuanLyDSKhachHang{
    DanhSachKhachHang d_sach1 = new DanhSachKhachHang();  
    int chucnang;
    public void nhap() throws Exception{
        d_sach1.nhap(); 
    }
    public void menu() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n=================================================================================================================================================");
        System.out.print("\nCAC CHUC NANG THAO TAC VOI DANH SACH KHACH HANG:");
        System.out.print("\n    0.Thoat.");
        System.out.print("\n    1.Doc file khach hang.");
        System.out.print("\n    2.Xem danh sach khach hang.");
        System.out.print("\n    3.Them 1 hoac nhieu khach hang.");
        System.out.print("\n    4.Xoa khach hang.");
        System.out.print("\n    5.Sua thong tin khach hang.");
        System.out.print("\n    6.Tim kiem khach hang.");
        System.out.print("\n    7.Thong ke so luong khach hang.");
        System.out.print("\n    8.Luu ket qua thao tac len file .");
        System.out.print("\n=================================================================================================================================================");
        System.out.print("\nNhap vao chuc nang muon thuc hien (Tu 0 cho den 8): ");
        chucnang = Integer.parseInt(in.readLine());
        while (chucnang<0 || chucnang>8){
            System.out.print("\nBan da nhap sai ma so chuc nang!");
            System.out.print("\nMoi nhap lai( Tu 0 cho den 8):");
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
                System.out.print("\nDoc file khach hang");
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
                System.out.print("\n1. Tim kiem theo ma khach hang.");
                System.out.print("\n2. Tim kiem theo ten khach hang (Co the nhap gan dung). \n");
                int num = Integer.parseInt(in.readLine());
                switch(num){
                    case 1:{
                        System.out.print("\nNhap vao ma khach hang: ");
                        String ma = in.readLine();
                        System.out.print("\nKet qua tim kiem: ");
                        if(d_sach1.timkiem(ma)!= null){
                            d_sach1.timkiem(ma).xuat();
                        }
                        else System.out.print("\nKhong tim thay ");
                        in.readLine();
                        menu();
                        thuchien();
                        break;
                    }
                    case 2:{
                        d_sach1.timkiem();
                        in.readLine();
                        menu();
                        thuchien();
                        break;
                    }
                
                }
                
                break;   
            }
            case 7:{
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