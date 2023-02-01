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
public class DanhSachNhanVien implements RangBuocClassDanhSach {
    public static Scanner scanner = new Scanner(System.in);
    static NhanVien[] dsnv = new NhanVien[0];
    int n;
    public DanhSachNhanVien()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong nhan vien ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dsnv = Arrays.copyOf(dsnv, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu nhan vien thu "+(i+1)+":\n");
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dsnv[i].getMaNhanVien(), dsnv[j].getMaNhanVien())){
                        System.out.print("\nNhan vien vua nhap co ma nhan vien trung voi khach hang truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dsnv[i].nhap();
                        j=0;    
                    }
                    else{
                        j++;
                    }
                }
            }
        }
    }
    public void them()
    {
        System.out.println("Nhap so nhan vien can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dsnv.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu nhan vien thu "+(n+1)+":\n");
            dsnv = Arrays.copyOf(dsnv, n+1);
            dsnv[n] = new NhanVien();
            dsnv[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dsnv[n-1].getMaNhanVien(), dsnv[j].getMaNhanVien())){
                    System.out.print("\nNhan vien vua nhap co ma trung voi nhan vien truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dsnv = Arrays.copyOf(dsnv, n-1);
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
    //Ham tim kiem theo ma
    public  NhanVien timkiem(String makh_ss){
        n = dsnv.length;
        //NhanVien [] luunhanvien = new NhanVien[1];
        for ( int i=0; i<n; i++){
            if (dsnv[i].getMaNhanVien().equalsIgnoreCase(makh_ss)){
                //luunhanvien[0] =  dsnv[i];
                return dsnv[i];
            }
        }
        return null;
    }
    //Ham tim kiem theo ten
    public void timkiem() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nNhap vao ho va ten cua nhan vien (Co the nhap gan dung): ");
        String tenkhachhang_ss = in.readLine();
        tenkhachhang_ss = tenkhachhang_ss.toLowerCase();
        n = dsnv.length;
        System.out.print("\nKet qua tim kiem:\n");
        int dem=0;
        for ( int i=0; i<n; i++){
            String space = dsnv[i].getHo().concat(" ");
            String Tenkhachhang_lowercase = (space.concat(dsnv[i].getTen())).toLowerCase();
            if (Tenkhachhang_lowercase.indexOf(tenkhachhang_ss)!=-1){
                dem++;
                dsnv[i].xuat();
                System.out.print("\n");
            }
        }
        if (dem==0) System.out.print("\nTen nhan vien khong trung voi du lieu trong danh sach");
    }
    //Ham sua thong tin khach hang
    public void sua()
    {
        
        System.out.println("nhap ma nhan vien can sua: ");
        String ma = scanner.nextLine();
        int dem=0;
        n = dsnv.length;
        for ( int i=0; i<n; i++){
            if (dsnv[i].getMaNhanVien().equalsIgnoreCase(ma)){     
                dsnv[i] = new NhanVien();
                dsnv[i].nhap();
                int j =0;
                dem++;
                while (j< n){
                    if ( Check_PrimaryKey( dsnv[i].getMaNhanVien(), dsnv[j].getMaNhanVien()) && j!=i){
                        System.out.print("\nNhan vien vua nhap co ma trung voi nhan vien truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dsnv[i].nhap();
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
            System.out.print("\nMa nhan vien khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa()
    {
        System.out.println("nhap ma nhan vien can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dsnv.length;
        for ( int i=0; i<n; i++){
            if (dsnv[i].getMaNhanVien().equalsIgnoreCase(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dsnv[i]=dsnv[i+1];
                }
                dsnv = Arrays.copyOf(dsnv, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa nhan vien khong trung khop voi du lieu trong danh sach!!!");
        }
        
    }
    public void thongke(){
        System.out.print("So luong nhan vien la: "+ dsnv.length+"\n");
    }
    public void xuat()
    {
        n = dsnv.length;
        System.out.print("\nDANH SACH NHAN VIEN LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dsnv[i].xuat();
            System.out.print("\n");
        }
    }
    public int soluongnv()
    {
        return dsnv.length;
    }
    public void ghifile() throws IOException {
        FileOutputStream fos = null;
        n = dsnv.length;
        try {
            fos = new FileOutputStream("file\\nhanvien.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dsnv[i].getFileLine();
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

    public void docFile()
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = dsnv.length;
        try{
            fis = new FileInputStream("file\\nhanvien.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dsnv = Arrays.copyOf(dsnv, n+1);
                dsnv[n] = new NhanVien();
                dsnv[n].parse(line);
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
    public void docFile(int num)
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = num;
        try{
            fis = new FileInputStream("file\\nhanvien.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dsnv = Arrays.copyOf(dsnv, n+1);
                dsnv[n] = new NhanVien();
                dsnv[n].parse(line);
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

