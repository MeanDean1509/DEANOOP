package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class ChiTietHoaDon {
    Scanner sc = new Scanner(System.in);
    String maHD, maSP[] = new String[100], TenSP[] = new String[100];
    int soLuong[] = new int[100];
    int n;
    long donGia[] = new long[100];
    long thanhTien[] = new long[100];
    DanhSachSanPham danhsachcheck = new DanhSachSanPham();   
    public ChiTietHoaDon(){}
    public ChiTietHoaDon(String maHD, String maSP[],String TenSP[], int soLuong[], long donGia[], long thanhTien[]){
        this.maHD = maHD;
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    public ChiTietHoaDon(ChiTietHoaDon d){
        maHD = d.maHD;
        maSP = d.maSP;
        TenSP = d.TenSP;
        soLuong = d.soLuong;
        donGia = d.donGia;
        thanhTien = d.thanhTien;
    }
    public void getinfo(int n) throws Exception{
        int i=0;
        danhsachcheck.docFile(0);
        while(i<n){
            TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
            donGia[i] = danhsachcheck.timkiem(maSP[i]).getDONGIA();
            danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() - soLuong[i]);
            thanhTien[i] = 0;
            thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
            i++;           
        }
        danhsachcheck.ghifile();
    }  
    public void getinfoNULLChange(int n) throws Exception{
        int i=0;
        danhsachcheck.docFile(0);
        while(i<n){
            TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
            donGia[i] = danhsachcheck.timkiem(maSP[i]).getDONGIA();
           // danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() - soLuong[i]);
            thanhTien[i] = 0;
            thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
            i++;           
        }
        danhsachcheck.ghifile();
    }  
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap ma hoa don: "); maHD = sc.nextLine();
        System.out.println("Nhap vao so luong ma san pham da mua:");
        n = Integer.parseInt(in.readLine());
        danhsachcheck.docFile(0);
        int i =0;
        while(i<n){
            System.out.println("Nhap ma san pham: ");maSP[i] = in.readLine();
            if ( danhsachcheck.timkiem(maSP[i]) != null){
                TenSP[i] = danhsachcheck.timkiem(maSP[i]).getTENSANPHAM();
                System.out.println("Ten san pham: "+ danhsachcheck.timkiem(maSP[i]).getTENSANPHAM()+" ");
                donGia[i] = danhsachcheck.timkiem(maSP[i]).getDONGIA();
                System.out.println("Don gia: "+donGia[i]+"VND");
                System.out.println("Nhap so luong: ");soLuong[i] = Integer.parseInt(in.readLine());
                while(soLuong[i]>danhsachcheck.timkiem(maSP[i]).getSOLUONG()){
                    System.out.print("So luong mua lon hon so luong san pham san co!!!\n");
                    System.out.print("Nhap lai!!!\n");
                    System.out.println("Nhap so luong: ");soLuong[i] = Integer.parseInt(in.readLine());
                }
                danhsachcheck.timkiem(maSP[i]).setSOLUONG(danhsachcheck.timkiem(maSP[i]).getSOLUONG() - soLuong[i]);
                thanhTien[i] = 0;
                thanhTien[i] = thanhTien[i]+ (donGia[i]*soLuong[i]);
                System.out.println("Thanh tien: "+thanhTien[i]+"VND");    
                i++;           
            }
            else{
                System.out.print("\nKhong tim thay ma san pham tren.");
                System.out.print("\nNhap lai");
            }
        }
        danhsachcheck.ghifile();
    }
    public void xuat(){
        System.out.print("Ma hoa don: "+maHD+"\n");
        for ( int i =0; i<n; i++ ){
            System.out.print("Ma san pham: "+maSP[i]+"; ");
            System.out.print(TenSP[i]+"   ");
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
    public String getMAHD(){return maHD;}
    public String[] getMASP(){
        return maSP;
    }
    public int[] getSOLUONG(){return soLuong;}
    public long[] getDONGIA(){return donGia;}
    public long[] getTHANHTIEN(){return thanhTien;}
    public int getN() {
        return n;
    }

    public void setMAHD(String maHD){this.maHD = maHD;}
    public void setMASP(String []maSP){this.maSP = maSP;}
    public void setSOLUONG(int []soLuong){this.soLuong = soLuong;}
    public void setDONGIA(long []donGia){this.donGia = donGia;}
    public void setTHANHTIEN(long []thanhTien){this.thanhTien = thanhTien;}
    //file 
    public String getFileLinearr(){
        String arr = new String();
        for ( int i=0; i<n; i++){
            arr =arr + (", "+maSP[i]+", "+ soLuong[i]);
        }
        return arr;
    }
    public String getFileLine() {
        return maHD+ ", "+ n + getFileLinearr()+"\n";
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        int k1 =0;
        int k2 = 1;
        try{
            maHD = param[0];
            n = Integer.parseInt(param[1]);
            for ( int i =0; i<n; i++){
                maSP[i] = param[k1+2];
                soLuong[i] = Integer.parseInt(param[k2+2]);
                k1+=2;
                k2+=2;
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{

        }
    }
}
// chinh sua
// tiep tuc chinh sua
