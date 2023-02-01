package src;
import java.util.*;
import java.io.*;
public class NhaCungCap
{
    Scanner sc = new Scanner(System.in);
    String mancc, tenncc;
    //ham thiet lap
    public NhaCungCap(){};
    public NhaCungCap(String mancc, String tenncc)
    {   
        this.mancc = mancc;
        this.tenncc = tenncc;
    }
    public NhaCungCap(NhaCungCap d)
    {
        mancc = d.mancc;
        tenncc =  d.tenncc;
    }
    public void nhap() throws Exception
    {  
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Nhap ma nha cung cap: ");
        mancc = in.readLine();
        System.out.printf("Nhap ten nha cung cap: ");
        tenncc = in.readLine();
    }
    public void xuat()
    {
        System.out.println("Ma nha cung cap: "+ mancc);
        System.out.println("Ten nha cung cap: "+ tenncc);
    }
    public void parse(String line){
        String param[] = line.split(", ");
        try {
            mancc = param[0];
            tenncc = param[1];
        } catch (Exception e) {
        }
    }
    public String getFileLine(){
        return mancc +", "+ tenncc +"\n";
    }
    //get/set
    public String getMANCC()
    {
        return mancc;
    }
    public String getTENNCC()
    {
        return tenncc;
    }
    public void setMANCC(String mancc)
    {
        this.mancc = mancc;
    }
    public void setTENNCC(String tenncc)
    {
        this.tenncc = tenncc;
    }
}
