package src;
import java.util.Scanner;
public class KhachHang 
{
    private String  ho, ten, diachi, MaKhachHang, sdt;
   
    public KhachHang() {
    }
    public KhachHang(String maKhachHang, String ho, String ten, String diachi, String sdt) 
    {
        this.MaKhachHang = maKhachHang;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public KhachHang(KhachHang kh1){
        MaKhachHang = kh1.MaKhachHang;
        ho = kh1.ho;
        ten = kh1.ten;
        diachi = kh1.diachi;
        sdt = kh1.sdt;
    }
    //Ham nhap
    public void nhap()
    {
        Scanner a = new Scanner(System.in); 
        System.out.println("Nhap ma khach hang: ");
        MaKhachHang = a.nextLine();
        System.out.println("Nhap ho khach hang: ");
        ho = a.nextLine();
        System.out.println("Nhap ten khach hang: ");
        ten = a.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi = a.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt = a.nextLine();
        //a.close();
    }
    // Ham xuat
    public void xuat() 
    {
        System.out.print("Ma khach hang: " + MaKhachHang + ", Ho: " + ho + ", Ten: "+ten +", Dia chi: "+diachi+ ", SDT: "+ sdt +"\n");
    }
    // Get, set
    public String getMaKhachHang() 
    {
        return MaKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) 
    {
        this.MaKhachHang = maKhachHang;
    }
    public String getHo() 
    {
        return ho;
    }
    public void setHo(String ho) 
    {
        this.ho = ho;
    }
    public String getTen() 
    {
        return ten;
    }
    public String getHoten(){
        String s_hoten1 = ho.concat(" ");
        String s_hoten2 = s_hoten1.concat(ten);
        return s_hoten2;
    }
    public void setTen(String ten) 
    {
        this.ten = ten;
    }
    public String getDiaChi() 
    {
        return diachi;
    }
 
    public void setDiaChi(String diachi) 
    {
        this.diachi = diachi;
    }
    public String getSDT() 
    {
        return sdt;
    }
    public void setSDT(String sdt) 
    {
        this.sdt = sdt;
    }
    //File
    public String getFileLine() {
        return MaKhachHang+ ", "+ ho +", "+ ten +", "+ diachi+", "+sdt +"\n" ;
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        try{
            MaKhachHang = param[0];
            ho = param[1];
            ten = param[2];
            diachi = param[3];
            sdt = param[4];
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{
            
        }
    }
}