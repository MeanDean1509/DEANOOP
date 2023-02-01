package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class ChiTietPhieuNhap {
    Scanner sc = new Scanner(System.in);
    String maPN, maSP[] = new String[100], TenSP[] = new String[100];
    int soLuong[] = new int[100];
    int n;
    long donGia[] = new long[100];
    long thanhTien[] = new long[100]; 
    public ChiTietPhieuNhap(){}
    public ChiTietPhieuNhap(String maHD, String maSP[],String TenSP[], int soLuong[], long donGia[], long thanhTien[]){
        this.maPN = maHD;
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    public ChiTietPhieuNhap(ChiTietPhieuNhap d){
        maPN = d.maPN;
        maSP = d.maSP;
        TenSP = d.TenSP;
        soLuong = d.soLuong;
        donGia = d.donGia;
        thanhTien = d.thanhTien;
    }
    public void getinfo(int n) throws Exception{
        int i=0;
        DanhSachSanPham danhsachcheck = new DanhSachSanPham();  
        danhsachcheck.docFile(0);
        while(i<n){
            TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
            danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() + soLuong[i]);
            thanhTien[i] = 0;
            thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
            i++;           
        }
        danhsachcheck.ghifile();
    }  
    public void getinfoNULLChange(int n) throws Exception{
        int i=0;
        DanhSachSanPham danhsachcheck = new DanhSachSanPham();  
        danhsachcheck.docFile(0);
        while(i<n){
            TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
           // danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() + soLuong[i]);
            thanhTien[i] = 0;
            thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
            i++;           
        }
        danhsachcheck.ghifile();
    }  
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap ma phieu nhap: "); maPN = sc.nextLine();
        System.out.println("Nhap vao so luong ma san pham trong phieu nhap:");
        DanhSachSanPham danhsachcheck = new DanhSachSanPham();  
        n = Integer.parseInt(in.readLine());
        danhsachcheck.docFile(0);
        int i =0;
        while(i<n){
            System.out.println("Nhap ma san pham: ");maSP[i] = in.readLine();
            if ( danhsachcheck.timkiem(maSP[i]) != null){
                TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
                System.out.println("Ten san pham: "+ danhsachcheck.timkiem(maSP[i]).getTENSANPHAM()+" ");
                System.out.println("Nhap vao Don gia cua san pham(VND): ");
                donGia[i] = Long.parseLong(in.readLine());
                System.out.println("Nhap so luong: ");soLuong[i] = Integer.parseInt(in.readLine());
                danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() + soLuong[i]);
                thanhTien[i] = 0;
                thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
                System.out.println("Thanh tien: "+thanhTien[i]+"VND");    
                i++;           
            }
            else{
                System.out.print("\nKhong tim thay ma san pham tren.");
                System.out.print("\nNhap lai!!!\n");
            }
        }
        danhsachcheck.ghifile();
    }
    public void xuat(){
        System.out.print("Ma phieu nhap: "+maPN+"\n");
        for ( int i =0; i<n; i++ ){
            System.out.print("Ma san pham: "+maSP[i]+"; ");
            System.out.print(TenSP[i]+"; ");
            System.out.print("Don gia: "+donGia[i]+ "VND; ");
            System.out.print("So luong: "+soLuong[i]+"; ");
            System.out.print("Thanh tien: "+thanhTien[i]+"VND\n");
        }
    }
    public long tinhtongtien(){
        long tt=0;
        for ( int i =0; i<n; i++){
            tt +=thanhTien[i];
        }
        return tt;
    }
    //get--set
    public String getMAPN(){return maPN;}
    public String[] getMASP(){
        return maSP;
    }
    public int[] getSOLUONG(){return soLuong;}
    public long[] getDONGIA(){return donGia;}
    public long[] getTHANHTIEN(){return thanhTien;}
    public int getN() {
        return n;
    }

    public void setMAPN(String maHD){this.maPN = maHD;}
    public void setMASP(String []maSP){this.maSP = maSP;}
    public void setSOLUONG(int []soLuong){this.soLuong = soLuong;}
    public void setDONGIA(long []donGia){this.donGia = donGia;}
    public void setTHANHTIEN(long []thanhTien){this.thanhTien = thanhTien;}
    //file 
    public String getFileLinearr(){
        String arr = new String();
        for ( int i=0; i<n; i++){
            arr =arr + (", "+maSP[i]+", "+ soLuong[i]+ ", "+donGia[i]);
        }
        return arr;
    }
    public String getFileLine() {
        return maPN+ ", "+ n + getFileLinearr()+"\n";
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        int k1 =-1;
        int k2 = 0;
        int k3 = 1;
        try{
            maPN = param[0];
            n = Integer.parseInt(param[1]);
            for ( int i =0; i<n; i++){
                maSP[i] = param[k1+3];
                soLuong[i] = Integer.parseInt(param[k2+3]);
                donGia[i] = Integer.parseInt(param[k3+3]);
                k1+=3;
                k2+=3;
                k3+=3;
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{

        }
    }
}