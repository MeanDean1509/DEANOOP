package src;
import java.io.*;
abstract class SanPham{
	private String masanpham;
	private String tensanpham;
    private long dongia;
    private String donvitinh;
    private int soluong;
    //---------------------------------------------HAM THIET LAP------------------------------------------------------------------//
    public SanPham(){}
    public SanPham(String masanpham, String tensanpham, long dongia, String donvitinh, int soluong){
        this.masanpham = masanpham;
        this.tensanpham = tensanpham ;
        this.dongia = dongia;
        this.donvitinh = donvitinh;
        this.soluong = soluong;
    }
    public SanPham(SanPham sp){
        masanpham = sp.masanpham;
        tensanpham = sp.tensanpham;
        dongia = sp.dongia;
        donvitinh =sp.donvitinh;
        soluong = sp.soluong;
    }
    //-------------------------------------------------HAM NHAP--------------------------------------------------------------------//
	public void nhap() throws Exception{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("  Nhap ma san pham: ");
        masanpham = in.readLine();
        System.out.print("  Nhap ten san pham: ");
        tensanpham = in.readLine();
        System.out.print("  Nhap don gia cua san pham: ");
        dongia = Long.parseLong(in.readLine());
        System.out.print("  Nhap don vi tinh cua san pham: ");
        donvitinh = in.readLine();
        System.out.print("  Nhap so luong cua san pham: ");
        soluong = Integer.parseInt(in.readLine());
    }
    //---------------------------------------------------HAM XUAT------------------------------------------------------------------ /
    public void xuat() {
        System.out.print("\nMa san pham: "+masanpham);
        System.out.print("; Ten san pham: "+tensanpham);
        System.out.print("; Don gia: "+dongia);
        System.out.print("; Don vi tinh: "+donvitinh);
        System.out.print("; So luong: "+soluong);
    }
    //---------------------------------------------------HAM GET--------------------------------------------------------------------//
    public String getMASANPHAM(){
        return masanpham;
    }
    public String getTENSANPHAM(){
        return tensanpham;
    }
    public long getDONGIA(){
        return dongia;
    }
    public String getDONVITINH(){
        return donvitinh;
    }
    public int getSOLUONG(){
        return soluong;
    }
    //----------------------------------------------------HAM SET------------------------------------------------------------------//
    public void setMASANPHAM(String masanpham){
        this.masanpham = masanpham;
    }
    public void setTENSANPHAM(String tensanpham){
        this.tensanpham = tensanpham;
    }
    public void setDONGIA(long dongia){
        this.dongia = dongia;
    }
    public void setDONVITINH(String donvitinh){
        this.donvitinh = donvitinh;
    }
    public void setSOLUONG(int soluong){
        this.soluong = soluong;
    }
    //-------------------------------------------------------FILE------------------------------------------------------------//
    public String getFileLine() {
        return masanpham+ ", "+ tensanpham +", "+ dongia +", "+ donvitinh +", "+ soluong ;
    }
    public void parse(String line)
    {
        String[] param = line.split(", ");
        try{
            masanpham = param[0];
            tensanpham = param[1];
            dongia = Long.parseLong(param[2]);
            donvitinh = param[3];
            soluong = Integer.parseInt(param[4]);
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{

        }
    }
    //--------------------------------------------------Ham Truu Tuong---------------------------------------------------------//
    abstract public String decription();
}
    
