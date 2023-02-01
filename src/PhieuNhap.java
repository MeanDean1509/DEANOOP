package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;
public class PhieuNhap
{
    private String  maPhieuNhap, maNhanVien, maNhaCC,TenNV,TenNCC;
    private LocalDate ngaylapPN;
    private Long tongtien;
    public PhieuNhap() {
    }
    public PhieuNhap(String maPN, String maNhanVien, String maNhaCC, LocalDate ngaylapPN, Long tongtien) 
    {
        this.maNhaCC =  maNhaCC;
        this.maPhieuNhap = maPN;
        this.maNhanVien = maNhanVien;
        this.ngaylapPN = ngaylapPN;
        this.tongtien = tongtien;
    }
    public PhieuNhap(PhieuNhap pn1){
        maNhaCC =  pn1.maNhaCC;
        this.maPhieuNhap = pn1.maPhieuNhap;
        this.maNhanVien = pn1.maNhanVien;
        this.ngaylapPN = pn1.ngaylapPN;
        this.tongtien = pn1.tongtien;
        
    }
    //Ham nhap
    public void nhap() throws Exception
    {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Nhap ma phieu nhap: ");
        maPhieuNhap = in.readLine();
        System.out.println("Nhap ma nha cung cap: ");
        maNhaCC = in.readLine();
        DanhSachNCC danhsachncccheck = new DanhSachNCC();
        danhsachncccheck.docFile(0);
        TenNCC = danhsachncccheck.timkiem(maNhaCC).getTENNCC();
        System.out.print("Ten Nha cung cap: "+ TenNCC+"\n");
        System.out.println("Nhap ma nhan vien: ");
        maNhanVien = in.readLine();
        DanhSachNhanVien danhsachnvcheck = new DanhSachNhanVien();
        danhsachnvcheck.docFile(0);
        TenNV = danhsachnvcheck.timkiem(maNhanVien).getHoten();
        System.out.print("Ten Nhan vien: "+ TenNV+"\n");
        System.out.println("Nhap ngay lap phieu nhap(vd 2012-12-06): ");
        ngaylapPN = LocalDate.parse(in.readLine());
        DanhSachCTPhieuNhap danhsachctpncheck = new DanhSachCTPhieuNhap();
        if (danhsachctpncheck.timkiem(maPhieuNhap)!= null){

            tongtien = danhsachctpncheck.timkiem(maPhieuNhap).tinhtongtien();
            System.out.print("\nTong tien: ");
            System.out.print(tongtien+"VND");
        }
        else{
            System.out.print("Nhap vao tong tien cua phieu nhap: \n");
            tongtien = Long.parseLong(in.readLine());
        }
        danhsachncccheck.ghifile();
        danhsachnvcheck.ghifile();
        danhsachctpncheck.ghifile();
    }
    public void getinfo() throws Exception{
        DanhSachCTPhieuNhap danhsachctpncheck = new DanhSachCTPhieuNhap();
        // danhsachctpncheck.docFile(0);
        DanhSachNCC danhsachncccheck = new DanhSachNCC();
        danhsachncccheck.docFile(0);
        DanhSachNhanVien danhsachnvcheck = new DanhSachNhanVien();
        danhsachnvcheck.docFile(0);
        TenNCC = danhsachncccheck.timkiem(maNhaCC).getTENNCC();
        TenNV = danhsachnvcheck.timkiem(maNhanVien).getHoten();
        tongtien=danhsachctpncheck.timkiem(maPhieuNhap).tinhtongtien();
        danhsachncccheck.ghifile();
        danhsachnvcheck.ghifile();
        danhsachctpncheck.ghifile();
    }
    // Ham xuat
    public void xuat() 
    {
        System.out.print("Ma hoa don: " + maPhieuNhap +"\n");
        System.out.print("Ma nha cung cap: "+maNhaCC +" ;Ten NCC: "+ TenNCC+"\n");
        System.out.print("Ma nhan vien: "+maNhanVien +" ; Ten NV: "+ TenNV+"\n");
        System.out.print("Ngay lap hoa don: "+ ngaylapPN+"\n");
        System.out.print("Tong tien: "+ tongtien+"\n");
    }
    // Get, set
    public String getMaNhaCC() 
    {
        return maNhaCC;
    }
    public void setMaNhaCC(String maKhachHang) 
    {
        this.maNhaCC = maKhachHang;
    }
    public String getMaPhieuNhap() 
    {
        return maPhieuNhap;
    }
    public void setMaPhieuNHap(String maHoaDon) 
    {
        this.maPhieuNhap = maHoaDon;
    }
    public String getMaNhanVien() 
    {
        return maNhanVien;
    }
 
    public void setMaNhanVien(String maNhanVien) 
    {
        this.maNhanVien = maNhanVien;
    }
    public LocalDate getNgayLapPN() 
    {
        return ngaylapPN;
    }
    public void setNgayLapPN(LocalDate ngaylapHD) 
    {
        this.ngaylapPN = ngaylapHD;
    }
    public long getTongtien(){
        return tongtien;
    }
    public String getHoTenNV(){
        return TenNV;
    }
    //File
    public String getFileLine() {
        return maPhieuNhap+ ", "+ maNhaCC +", "+ maNhanVien +", "+ ngaylapPN +"\n" ;
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        try{
            maPhieuNhap = param[0];
            maNhaCC = param[1];
            maNhanVien = param[2];
            ngaylapPN = LocalDate.parse(param[3]);
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{
            
        }
    }
}
