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
public class DanhSachNCC implements RangBuocClassDanhSach{
    public static Scanner scanner = new Scanner(System.in);
    static NhaCungCap[] dsncc = new NhaCungCap[0];
    int n;
    public DanhSachNCC()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong nha cung cap ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dsncc = Arrays.copyOf(dsncc, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu nha cung cap thu "+(i+1)+":\n");
            dsncc[i] = new NhaCungCap();
            dsncc[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dsncc[i].getMANCC(), dsncc[j].getMANCC())){
                        System.out.print("\nNha cung cap vua nhap co ma trung voi nha cung cap truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dsncc[i].nhap();
                        j=0;    
                    }
                    else{
                        j++;
                    }
                }
            }
        }
    }
    public void them() throws Exception
    {
        System.out.println("Nhap so nha cung cap can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dsncc.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu nha cung cap thu "+(n+1)+":\n");
            dsncc = Arrays.copyOf(dsncc, n+1);
            dsncc[n] = new NhaCungCap();
            dsncc[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dsncc[n-1].getMANCC(), dsncc[j].getMANCC())){
                    System.out.print("\nNha cung cap vua nhap co ma trung voi nha cung cap truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dsncc = Arrays.copyOf(dsncc, n-1);
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
    public  NhaCungCap timkiem(String makh_ss){
        n = dsncc.length;
        //KhachHang [] luukhachhang = new KhachHang[1];
        for ( int i=0; i<n; i++){
            if (dsncc[i].getMANCC().equalsIgnoreCase(makh_ss)){
                //luukhachhang[0] =  dskh[i];
                return dsncc[i];
            }
        }
        return null;
    }
    //Ham tim kiem theo ten
    public void timkiem() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nNhap vao ten cua nha cung cap (Co the nhap gan dung): ");
        String ten_ss = in.readLine();
        ten_ss = ten_ss.toLowerCase();
        n = dsncc.length;
        System.out.print("\nKet qua tim kiem:\n");
        int dem=0;
        for ( int i=0; i<n; i++){
           
            String Ten_lowercase = ((dsncc[i].getTENNCC())).toLowerCase();
            if (Ten_lowercase.indexOf(ten_ss)!=-1){
                dem++;
                dsncc[i].xuat();
                System.out.print("\n");
            }
        }
        if (dem==0) System.out.print("\nTen Nha cung cap khong trung voi du lieu trong danh sach");
    }
    //Ham sua thong tin khach hang
    public void sua() throws Exception
    {
        
        System.out.println("nhap ma nha cung cap can sua: ");
        String ma = scanner.nextLine();
        int dem=0;
        n = dsncc.length;
        for ( int i=0; i<n; i++){
            if (dsncc[i].getMANCC().equalsIgnoreCase(ma)){     
                dsncc[i] = new NhaCungCap();
                dsncc[i].nhap();
                int j =0;
                dem++;
                    while (j< n){
                        if ( Check_PrimaryKey( dsncc[i].getMANCC(), dsncc[j].getMANCC()) && j!=i){
                            System.out.print("\nNha cung cap vua nhap co ma trung voi nha cung cap truoc do.");
                            System.out.print("\nNhap lai!!!\n");
                            dsncc[i].nhap();
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
            System.out.print("\nMa nha cung cap khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa()
    {
        System.out.println("Nhap ma nha cung cap can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dsncc.length;
        for ( int i=0; i<n; i++){
            if (dsncc[i].getMANCC().equals(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dsncc[i]=dsncc[i+1];
                }
                dsncc = Arrays.copyOf(dsncc, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa nha cung cap khong trung khop voi du lieu trong danh sach!!!");
        }
        
    }
    public void thongke(){
        System.out.print("So luong nha cung cap la: "+ dsncc.length+"\n");
    }
    public void xuat()
    {
        n = dsncc.length;
        System.out.print("\nDANH SACH NHA CUNG CAP LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dsncc[i].xuat();
            System.out.print("\n");
        }
    }
    public int soluongkh()
    {
        return dsncc.length;
    }
    public void ghifile() throws IOException 
    {
        FileOutputStream fos = null;
        n = dsncc.length;
        try {
            fos = new FileOutputStream("file\\nhacungcap.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dsncc[i].getFileLine();
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
        n = dsncc.length;
        try{
            fis = new FileInputStream("file\\nhacungcap.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dsncc = Arrays.copyOf(dsncc, n+1);
                dsncc[n] = new NhaCungCap();
                dsncc[n].parse(line);
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
            fis = new FileInputStream("file\\nhacungcap.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dsncc = Arrays.copyOf(dsncc, n+1);
                dsncc[n] = new NhaCungCap();
                dsncc[n].parse(line);
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


