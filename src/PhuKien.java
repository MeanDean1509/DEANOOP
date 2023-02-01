package src;
import java.io.*;
class PhuKien extends SanPham
{
    private String chucnang;
    //---------------------------------------------HAM THIET LAP------------------------------------------------------------------//
    public PhuKien() {
        chucnang="";
    }
    public PhuKien(String masanpham, String tensanpham, long dongia, String donvitinh, int soluong, String chucnang)
    {
        super(masanpham, tensanpham, dongia, donvitinh, soluong);
        this.chucnang = chucnang;
    }
    public PhuKien(PhuKien pk1){

        super((SanPham)pk1);
        chucnang = pk1.chucnang;
    }
    //-------------------------------------------------HAM NHAP--------------------------------------------------------------------//
    @Override public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        super.nhap();
        System.out.print("  Nhap vao chuc nang cua phu kien :");
        chucnang = in.readLine();
    //---------------------------------------------------HAM XUAT------------------------------------------------------------------ //
    }
    @Override public void xuat(){
        super.xuat();
        System.out.print("; Chuc nang: "+chucnang);
    }
    //----------------------------------------------------HAM GET/SET--------------------------------------------------------------//
    public String getCHUCNANG(){
        return chucnang;
    }
    public void setCHUCNANG(String chucnang){
        this.chucnang = chucnang;
    }
    //---------------------------------------------------FILE-------------------------------------------------------------//
    @Override public String getFileLine() {
        return super.getFileLine()+ ", "+ chucnang+ "\n";
    }
    @Override public void parse(String line)
    {
        super.parse(line);
        String[] param = line.split(", ");
        try{
            chucnang = param[5];
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{

        }
    }
    //-------------------------------------------------Ham truu tuong----------------------------------------------------------
    public String decription(){
        return("(Phu Kien)");
    }
}
