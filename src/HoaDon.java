package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;
public class HoaDon
{
    private String  maHoaDon, maNhanVien, maKhachHang,TenNV,TenKH;
    private LocalDate ngaylapHD;
    private Long tongtien ;
    public HoaDon() {
    }
    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, LocalDate ngaylapHD, Long tongtien) 
    {
        this.maKhachHang = maKhachHang;
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.ngaylapHD = ngaylapHD;
        this.tongtien = tongtien;
    }
    public HoaDon(HoaDon hd1){
        maKhachHang = hd1.maKhachHang;
        maHoaDon = hd1.maHoaDon;
        maNhanVien = hd1.maNhanVien;
        ngaylapHD = hd1.ngaylapHD;
        tongtien = hd1.tongtien;
    }
    //Ham nhap
    public void nhap() throws Exception
    {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Nhap ma hoa don: ");
        maHoaDon = in.readLine();
        DanhSachCTHoaDon danhsachcthdcheck = new DanhSachCTHoaDon();
        danhsachcthdcheck.docFile(0);
        System.out.println("Nhap ma khach hang: ");
        maKhachHang = in.readLine();
        DanhSachKhachHang danhsachkhcheck = new DanhSachKhachHang();
        danhsachkhcheck.docFile(0);
        TenKH = danhsachkhcheck.timkiem(maKhachHang).getHoten();
        System.out.print("Ten Khach Hang: "+ TenKH+"\n");
        System.out.println("Nhap ma nhan vien: ");
        maNhanVien = in.readLine();
        DanhSachNhanVien danhsachnvcheck = new DanhSachNhanVien();
        danhsachnvcheck.docFile(0);
        TenNV = danhsachnvcheck.timkiem(maNhanVien).getHoten();
        System.out.print("Ten Nhan vien: "+ TenNV+"\n");
        System.out.println("Nhap ngay lap hoa don(vd 2012-12-06): ");
        ngaylapHD = LocalDate.parse(in.readLine());
        if (danhsachcthdcheck.timkiem(maHoaDon)!= null){

            tongtien=danhsachcthdcheck.timkiem(maHoaDon).tinhtongtien();
            System.out.print("\nTong tien: ");
            System.out.print(tongtien);
        }
        else{
            System.out.print("Nhap vao tong tien cua hoa don: \n");
            tongtien = Long.parseLong(in.readLine());
        }
        danhsachkhcheck.ghifile();
        danhsachnvcheck.ghifile();
        danhsachcthdcheck.ghifile();
    }
    public void getinfo() throws Exception{
        DanhSachCTHoaDon danhsachcthdcheck = new DanhSachCTHoaDon();
        danhsachcthdcheck.docFile(0);
        DanhSachKhachHang danhsachkhcheck = new DanhSachKhachHang();
        danhsachkhcheck.docFile(0);
        DanhSachNhanVien danhsachnvcheck = new DanhSachNhanVien();
        danhsachnvcheck.docFile(0);
        TenKH = danhsachkhcheck.timkiem(maKhachHang).getHoten();
        TenNV = danhsachnvcheck.timkiem(maNhanVien).getHoten();
        tongtien=danhsachcthdcheck.timkiem(maHoaDon).tinhtongtien();
        danhsachkhcheck.ghifile();
        danhsachnvcheck.ghifile();
        danhsachcthdcheck.ghifile();
    }
    // Ham xuat
    public void xuat() 
    {
        System.out.print("Ma hoa don: " + maHoaDon +"\n");
        System.out.print("Ma khach hang: "+maKhachHang +" ;Ten KH: "+ TenKH+"\n");
        System.out.print("Ma nhan vien: "+maNhanVien +" ; Ten NV: "+ TenNV+"\n");
        System.out.print("Ngay lap hoa don: "+ ngaylapHD+"\n");
        System.out.print("Tong tien: "+ tongtien+"VND\n");
    }
    // Get, set
    public String getMaKhachHang() 
    {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) 
    {
        this.maKhachHang = maKhachHang;
    }
    public String getMaHoaDon() 
    {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) 
    {
        this.maHoaDon = maHoaDon;
    }
    public String getMaNhanVien() 
    {
        return maNhanVien;
    }
 
    public void setMaNhanVien(String maNhanVien) 
    {
        this.maNhanVien = maNhanVien;
    }
    public LocalDate getNgayLapHD() 
    {
        return ngaylapHD;
    }
    public void setNgayLapHoaDon(LocalDate ngaylapHD) 
    {
        this.ngaylapHD = ngaylapHD;
    }
    public String getTenNV(){
        return TenNV;
    }
    public long getTongtien(){
        return tongtien;
    }
    //File
    public String getFileLine() {
        return maHoaDon+ ", "+ maKhachHang +", "+ maNhanVien +", "+ ngaylapHD +"\n" ;
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        try{
            maHoaDon = param[0];
            maKhachHang = param[1];
            maNhanVien = param[2];
            ngaylapHD = LocalDate.parse(param[3]);
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{
            
        }
    }
}