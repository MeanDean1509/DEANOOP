package src;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;
public class DanhSachCTHoaDon implements RangBuocClassDanhSach{
    public static Scanner scanner = new Scanner(System.in);
    static ChiTietHoaDon[] dscthd = new ChiTietHoaDon[0];
    int n;
    public DanhSachCTHoaDon()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong chi tiet hoa don ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dscthd = Arrays.copyOf(dscthd, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu chi tiet hoa don thu "+(i+1)+":\n");
            dscthd[i] = new ChiTietHoaDon();
            dscthd[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dscthd[i].getMAHD(), dscthd[j].getMAHD())){
                        System.out.print("\nChi tiet hoa don vua nhap co ma trung voi chi tiet hoa don truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dscthd[i].nhap();
                        j=0;    
                    }
                    else{
                        j++;
                    }
                }
            }
        }
    }
    public void xuat()
    {
        n = dscthd.length;
        System.out.print("\nDANH SACH CHI TIET HOA DON LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dscthd[i].xuat();
            System.out.print("\n");
        }
    }
    public void them () throws Exception
    {
        System.out.println("Nhap so chi tiet hoa don can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dscthd.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu chi tiet hoa don thu "+(n+1)+":\n");
            dscthd = Arrays.copyOf(dscthd, n+1);
            dscthd[n] = new ChiTietHoaDon();
            dscthd[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dscthd[n-1].getMAHD(), dscthd[j].getMAHD())){
                    System.out.print("\nChi tiet vua nhap co ma trung voi hoa don truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dscthd = Arrays.copyOf(dscthd, n-1);
                    n--;
                    dem--;
                    break;
                }
                
            }
        }
        if (dem == num){
            System.out.print("\nDa them thanh cong.");
        }
    }
    // //Ham tim kiem theo ma
    public  ChiTietHoaDon timkiem(String mahd_ss){
        n = dscthd.length;
        for ( int i=0; i<n; i++){
            if (dscthd[i].getMAHD().equalsIgnoreCase(mahd_ss)){
                return dscthd[i];
            }
        }
        return null;
    }
    // //Ham sua thong tin khach hang
    public void sua() throws Exception
    {
        
        System.out.println("nhap ma chi tiet hoa don can sua: ");
        String ma = scanner.nextLine();
        int dem=0;
        n = dscthd.length;
        for ( int i=0; i<n; i++){
            if (dscthd[i].getMAHD().equalsIgnoreCase(ma)){     
                dscthd[i] = new ChiTietHoaDon();
                dscthd[i].nhap();
                int j =0;
                dem++;
                while (j< n){
                    if ( Check_PrimaryKey( dscthd[i].getMAHD(), dscthd[j].getMAHD()) && j!=i){
                        System.out.print("\nChi tiet hoa don vua nhap co ma trung voi hoa don truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dscthd[i].nhap();
                        j=0;    
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        if (dem>0){
            System.out.print("\nSua thanh cong!!!");
        }
        else{
            System.out.print("\nMa khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa() throws Exception
    {
        System.out.println("nhap ma hoa don can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dscthd.length;
        for ( int i=0; i<n; i++){
            if (dscthd[i].getMAHD().equalsIgnoreCase(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dscthd[i]=dscthd[i+1];
                }
                dscthd = Arrays.copyOf(dscthd, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa khong trung khop voi du lieu trong danh sach!!!");
        }
        
    }
    public void thongke(){
        System.out.print("So luong chi tiet hoa don la: "+ dscthd.length+"\n");
    }
    public void ghifile() throws IOException 
    {
        FileOutputStream fos = null;
        n = dscthd.length;
        try {
            fos = new FileOutputStream("file\\chitiethoadon.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dscthd[i].getFileLine();
                byte[] b = line.getBytes("utf8");
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally{
            if(fos != null)
            {
                try{
                    fos.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void docFile() throws Exception
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = dscthd.length;
        try{
            fis = new FileInputStream("file\\chitiethoadon.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                String[] param = line.split(", ");
                dscthd = Arrays.copyOf(dscthd, n+1);
                dscthd[n] = new ChiTietHoaDon();
                dscthd[n].parse(line);
                dscthd[n].getinfo(Integer.parseInt(param[1]));
                n++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        }
    }
    public void docFile(int num) throws Exception
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = num;
        try{
            fis = new FileInputStream("file\\chitiethoadon.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                String[] param = line.split(", ");
                dscthd = Arrays.copyOf(dscthd, n+1);
                dscthd[n] = new ChiTietHoaDon();
                dscthd[n].parse(line);
                dscthd[n].getinfoNULLChange(Integer.parseInt(param[1]));
                n++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        }
    }
   
}

