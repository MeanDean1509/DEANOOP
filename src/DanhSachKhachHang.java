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
public class DanhSachKhachHang implements RangBuocClassDanhSach{
    public static Scanner scanner = new Scanner(System.in);
    static KhachHang[] dskh = new KhachHang[0];
    int n;
    public DanhSachKhachHang()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong khach hang ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dskh = Arrays.copyOf(dskh, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu khach hang thu "+(i+1)+":\n");
            dskh[i] = new KhachHang();
            dskh[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dskh[i].getMaKhachHang(), dskh[j].getMaKhachHang())){
                        System.out.print("\nKhach hang vua nhap co ma khach hang trung voi khach hang truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dskh[i].nhap();
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
        System.out.println("Nhap so khach hang can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dskh.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu khach hang thu "+(n+1)+":\n");
            dskh = Arrays.copyOf(dskh, n+1);
            dskh[n] = new KhachHang();
            dskh[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dskh[n-1].getMaKhachHang(), dskh[j].getMaKhachHang())){
                    System.out.print("\nKhach hang vua nhap co ma khach hang trung voi khach hang truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dskh = Arrays.copyOf(dskh, n-1);
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
    public  KhachHang timkiem(String makh_ss){
        n = dskh.length;
        //KhachHang [] luukhachhang = new KhachHang[1];
        for ( int i=0; i<n; i++){
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(makh_ss)){
                //luukhachhang[0] =  dskh[i];
                return dskh[i];
            }
        }
        return null;
    }
    //Ham tim kiem theo ten
    public void timkiem() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nNhap vao ho va ten cua khach hang (Co the nhap gan dung): ");
        String tenkhachhang_ss = in.readLine();
        tenkhachhang_ss = tenkhachhang_ss.toLowerCase();
        n = dskh.length;
        System.out.print("\nKet qua tim kiem:\n");
        int dem=0;
        for ( int i=0; i<n; i++){
            String space = dskh[i].getHo().concat(" ");
            String Tenkhachhang_lowercase = (space.concat(dskh[i].getTen())).toLowerCase();
            if (Tenkhachhang_lowercase.indexOf(tenkhachhang_ss)!=-1){
                dem++;
                dskh[i].xuat();
                System.out.print("\n");
            }
        }
        if (dem==0) System.out.print("\nTen khach hang khong trung voi du lieu trong danh sach");
    }
    //Ham sua thong tin khach hang
    public void sua()
    {
        
        System.out.println("nhap ma khach hang can sua: ");
        String ma = scanner.nextLine();
        int dem=0;
        n = dskh.length;
        for ( int i=0; i<n; i++){
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(ma)){     
                dskh[i] = new KhachHang();
                dskh[i].nhap();
                int j =0;
                dem++;
                    while (j< n){
                        if ( Check_PrimaryKey( dskh[i].getMaKhachHang(), dskh[j].getMaKhachHang()) && j!=i){
                            System.out.print("\nKhach hang vua nhap co ma khach hang trung voi khach hang truoc do.");
                            System.out.print("\nNhap lai!!!\n");
                            dskh[i].nhap();
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
            System.out.print("\nMa khach hang khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa()
    {
        System.out.println("nhap ma khach hang can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dskh.length;
        for ( int i=0; i<n; i++){
            if (dskh[i].getMaKhachHang().equals(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dskh[i]=dskh[i+1];
                }
                dskh = Arrays.copyOf(dskh, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa khach hang khong trung khop voi du lieu trong danh sach!!!");
        }
        
    }
    public void thongke(){
        System.out.print("So luong khach hang la: "+ dskh.length+"\n");
    }
    public void xuat()
    {
        n = dskh.length;
        System.out.print("\nDANH SACH KHACH HANG LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dskh[i].xuat();
            System.out.print("\n");
        }
    }
    public int soluongkh()
    {
        return dskh.length;
    }
    public void ghifile() throws IOException 
    {
        FileOutputStream fos = null;
        n = dskh.length;
        try {
            fos = new FileOutputStream("file\\khachhang.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dskh[i].getFileLine();
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
        n = dskh.length;
        try{
            fis = new FileInputStream("file\\khachhang.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dskh = Arrays.copyOf(dskh, n+1);
                dskh[n] = new KhachHang();
                dskh[n].parse(line);
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
            fis = new FileInputStream("file\\khachhang.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dskh = Arrays.copyOf(dskh, n+1);
                dskh[n] = new KhachHang();
                dskh[n].parse(line);
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

