package src;
import java.util.Scanner;
public class NhanVien 
{
    private String Manhanvien, chucvu, ho, ten, diachi;
    private long luong;
   
    public NhanVien() {
    }
    public NhanVien(String Manhanvien, String ho, String ten, String chucvu, long luong, String diachi) 
    {
        this.Manhanvien = Manhanvien;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.luong = luong;
    }
    public NhanVien(NhanVien nv1){
        Manhanvien = nv1.Manhanvien;
        ho = nv1.ho;
        ten = nv1.ten;
        diachi = nv1.diachi;
        chucvu =  nv1.chucvu;
        luong = nv1.luong;
    }
    //Ham nhap
    public void nhap()
    {
        Scanner a = new Scanner(System.in); 
        System.out.println("Nhap ma nhan vien: ");
        Manhanvien = a.nextLine();
        System.out.println("Nhap ho nhan vien: ");
        ho = a.nextLine();
        System.out.println("Nhap ten nhan vien: ");
        ten = a.nextLine();
        System.out.println("Nhap chuc vu cua nhan vien: ");
        chucvu = a.nextLine();
        System.out.println("Nhap luong cua nhan vien: ");
        luong = Long.parseLong(a.nextLine());
        System.out.println("Nhap dia chi: ");
        diachi = a.nextLine();
        //a.close();
    }
    // Ham xuat
    public void xuat() 
    {
        System.out.print("Ma nhan vien: " + Manhanvien + ", Ho: " + ho + ", Ten: "+ten +"Chuc vu: "+chucvu+", luong: "+luong+", Dia chi: "+diachi+"\n");
    }
    // Get, set
    public String getMaNhanVien() 
    {
        return Manhanvien;
    }
    public void setMaNhanVien(String Manhanvien) 
    {
        this.Manhanvien = Manhanvien;
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
 
    public void setTen(String ten) 
    {
        this.ten = ten;
    }
    public String getDiaChi() 
    {
        return diachi;
    }
    public void setDiachi(String diachi){
        this.diachi = diachi;
    }
    public void setLuong(long luong) 
    {
        this.luong = luong;
    }
    public long getLuong() 
    {
        return luong;
    }
    public String getChucvu() 
    {
        return chucvu;
    }
    public void setChucvu(String chucvu) 
    {
        this.chucvu = chucvu;
    }
    public String getHoten(){
        String s_hoten1 = ho.concat(" ");
        String s_hoten2 = s_hoten1.concat(ten);
        return s_hoten2;
    }
    //File
    public String getFileLine() {
        return Manhanvien+ ", "+ ho +", "+ ten +", "+chucvu+", "+ luong+", "+ diachi+"\n" ;
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        try{
            Manhanvien = param[0];
            ho = param[1];
            ten = param[2];
            chucvu = param[3];
            luong = Long.parseLong(param[4]);
            diachi = param[5];
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{
            
        }
    }
}
