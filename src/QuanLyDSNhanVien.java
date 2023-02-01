package src;
import java.io.*;
class QuanLyDSNhanVien{
    DanhSachNhanVien d_sachnv = new DanhSachNhanVien();  
    int chucnang;
    public void nhap() throws Exception{
        d_sachnv.nhap(); 
    }
    public void menu() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n=================================================================================================================================================");
        System.out.print("\nCAC CHUC NANG THAO TAC VOI DANH SACH NHAN VIEN:");
        System.out.print("\n    0.Thoat.");
        System.out.print("\n    1.Doc file nhan vien.");
        System.out.print("\n    2.Xem danh sach nhan vien.");
        System.out.print("\n    3.Them 1 hoac nhieu nhan vien.");
        System.out.print("\n    4.Xoa nhan vien.");
        System.out.print("\n    5.Sua thong tin nhan vien.");
        System.out.print("\n    6.Tim kiem nhan vien.");
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
                d_sachnv.docFile();
                System.out.print("\nDoc file nhan vien");
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 2:{
                
                d_sachnv.xuat();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 3:{
                d_sachnv.them();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 4:{
                d_sachnv.xoa();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 5:{
                d_sachnv.sua();
                in.readLine();
                menu();
                thuchien();
                break; 
            }
            case 6:{
                System.out.print("\nCac thuoc tinh tim kiem:");
                System.out.print("\n1. Tim kiem theo ma nhan vien.");
                System.out.print("\n2. Tim kiem theo ten khach hang (Co the nhap gan dung). \n");
                int num = Integer.parseInt(in.readLine());
                switch(num){
                    case 1:{
                        System.out.print("\nNhap vao ma khach hang: ");
                        String ma = in.readLine();
                        System.out.print("\nKet qua tim kiem: ");
                        if (d_sachnv.timkiem(ma)!= null){

                            d_sachnv.timkiem(ma).xuat();
                        } 
                        else System.out.print("\nKhong tim thay\n");
                        in.readLine();
                        menu();
                        thuchien();
                        break;
                    }
                    case 2:{
                        d_sachnv.timkiem();
                        in.readLine();
                        menu();
                        thuchien();
                        break;
                    }
                
                }
                
                break;   
            }
            case 7:{
                d_sachnv.thongke();
                in.readLine();
                menu();
                thuchien();
                break;
            }
            case 8:{
                d_sachnv.ghifile();
                System.out.print("\nBan da cap nhat file thanh cong.");
                in.readLine();
                menu();
                thuchien();
                break;
            }
        }
    }
}
