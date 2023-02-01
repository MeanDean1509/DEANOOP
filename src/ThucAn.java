package src;
import java.io.*;
class ThucAn extends SanPham
{
    private String dang;
    private String loaisudung;
    //---------------------------------------------HAM THIET LAP------------------------------------------------------------------//
    public ThucAn() {
        dang = "";
        loaisudung = "";
    }
    public ThucAn(String masanpham, String tensanpham, long dongia, String donvitinh, int soluong, String dang, String loaisudung)
    {
        super(masanpham, tensanpham, dongia, donvitinh, soluong);
        this.dang =  dang;
        this.loaisudung = loaisudung;
    }
    public ThucAn(ThucAn ta1){

        super((SanPham)ta1);
        dang = ta1.dang;
        loaisudung = ta1.loaisudung;

    }
    //-------------------------------------------------HAM NHAP--------------------------------------------------------------------//
    @Override public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        super.nhap();
        System.out.print("  Nhap vao dang cua thuc an :");
        dang = in.readLine();
        System.out.print("  Nhap vao loai dong vat dung thuc an :");
        loaisudung = in.readLine();
    //---------------------------------------------------HAM XUAT------------------------------------------------------------------ //
    }
    @Override public void xuat(){
        super.xuat();
        System.out.print("; Dang: "+dang);
        System.out.print("; Loai su dung: "+loaisudung);
    }
    //----------------------------------------------------HAM GET/SET--------------------------------------------------------------//
    public String getDANG(){
        return dang;
    }
    public String getLOAISUDUNG(){
        return loaisudung;
    }
    public void setDANG(String dang){
        this.dang = dang;
    }
    public void setLOAISUDUNG(String loaisudung){
        this.loaisudung = loaisudung;
    }    
     //----------------------------------------------------FILE-------------------------------------------------------------//
    @Override public String getFileLine() {
        return super.getFileLine()+ ", "+ dang + ", "+loaisudung+"\n";
    }
    @Override public void parse(String line)
    {
        super.parse(line);
        String[] param = line.split(", ");
        try{
            dang = param[5];
            loaisudung = param[6];
        }catch(ArrayIndexOutOfBoundsException e){
        }finally{

        }
    }
    //----------------------------------------------Ham truu tuong------------------------------------------------------------//
    public String decription(){
        return("(Thuc an)");
    }
}