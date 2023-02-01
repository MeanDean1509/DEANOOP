package src;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.LineNumberInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;
public class DanhSachHoaDon implements RangBuocClassDanhSach{
    public static Scanner scanner = new Scanner(System.in);
    static HoaDon[] dshd = new HoaDon[0];
    int n;
    public DanhSachHoaDon()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong hoa don ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dshd = Arrays.copyOf(dshd, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu hoa don thu "+(i+1)+":\n");
            dshd[i] = new HoaDon();
            dshd[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dshd[i].getMaHoaDon(), dshd[j].getMaHoaDon())){
                        System.out.print("\nHoa don vua nhap co ma trung voi hoa don truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dshd[i].nhap();
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
        System.out.println("Nhap so hoa don can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dshd.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu hoa don thu "+(n+1)+":\n");
            dshd = Arrays.copyOf(dshd, n+1);
            dshd[n] = new HoaDon();
            dshd[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dshd[n-1].getMaHoaDon(), dshd[j].getMaHoaDon())){
                    System.out.print("\nHoa don vua nhap co ma trung voi hoa don truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dshd = Arrays.copyOf(dshd, n-1);
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
    public  HoaDon timkiem(String makh_ss){
        n = dshd.length;
        //KhachHang [] luukhachhang = new KhachHang[1];
        for ( int i=0; i<n; i++){
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(makh_ss)){
                //luukhachhang[0] =  dskh[i];
                return dshd[i];
            }
        }
        return null;
    }
    //Ham sua thong tin hoa don
    public void sua() throws Exception
    {
        
        System.out.println("nhap ma hoa don can sua: ");
        String ma = scanner.nextLine();
        int dem=0;
        n = dshd.length;
        for ( int i=0; i<n; i++){
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(ma)){     
                dshd[i] = new HoaDon();
                dshd[i].nhap();
                int j =0;
                dem++;
                    while (j< n){
                        if ( Check_PrimaryKey( dshd[i].getMaHoaDon(), dshd[j].getMaHoaDon()) && j!=i){
                            System.out.print("\nHoa don vua nhap co ma trung voi hoa don truoc do.");
                            System.out.print("\nNhap lai!!!\n");
                            dshd[i].nhap();
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
            System.out.print("\nMa hoa don khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa()
    {
        System.out.println("nhap ma hoa don can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dshd.length;
        for ( int i=0; i<n; i++){
            if (dshd[i].getMaHoaDon().equals(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dshd[i]=dshd[i+1];
                }
                dshd = Arrays.copyOf(dshd, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa hoa don khong trung khop voi du lieu trong danh sach!!!");
        }
        
    }
    public void thongke(int num){
        switch(num){
            //THONG KE TONG TIEN THEO NHAN VIEN
            case 1:{
                System.out.print("DANH SACH THONG KE TONG TIEN THEO NHAN VIEN");
                n = dshd.length;
                String []ArrMANV = {"NVBH001","NVBH002","NVBH003","NVBH004","NVBH005","NVBH006","NVBH007"};
                String TenNV = new String();
                long TongtienNV = 0;
                int n1 = ArrMANV.length;
                for ( int i =0; i<n1 ; i++){
                    for ( int j =0; j<n; j++){
                        if (dshd[j].getMaNhanVien().equals(ArrMANV[i])){
                            TongtienNV = TongtienNV +  dshd[j].getTongtien();
                            TenNV = dshd[j].getTenNV();
                        }
                    }
                    System.out.print("\n"+(i+1)+"\nMa Nhan Vien:"+ArrMANV[i]+"\n");
                    System.out.print("Ten Nhan Vien:"+TenNV+"\n");
                    System.out.print("Tong tien :"+TongtienNV+"VND\n");
                    TongtienNV = 0;
                }
            }
            case 2:{

            }
        }
    }
    public void xuat() 
    {
        n = dshd.length;
        System.out.print("\nDANH SACH HOA DON LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dshd[i].xuat();
            System.out.print("\n");
        }
    }
    public int soluongkh()
    {
        return dshd.length;
    }
    public void ghifile() throws IOException 
    {
        FileOutputStream fos = null;
        n = dshd.length;
        try {
            fos = new FileOutputStream("file\\hoadon.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dshd[i].getFileLine();
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
        n = dshd.length;
        try{
            fis = new FileInputStream("file\\hoadon.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dshd = Arrays.copyOf(dshd, n+1);
                dshd[n] = new HoaDon();
                dshd[n].parse(line);
                dshd[n].getinfo();
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
            fis = new FileInputStream("file\\hoadon.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    continue;
                }
                dshd = Arrays.copyOf(dshd, n+1);
                dshd[n] = new HoaDon();
                dshd[n].parse(line);
                dshd[n].getinfo();
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

