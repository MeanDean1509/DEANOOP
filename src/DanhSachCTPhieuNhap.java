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
public class DanhSachCTPhieuNhap implements RangBuocClassDanhSach{
    public static Scanner scanner = new Scanner(System.in);
    static ChiTietPhieuNhap[] dsctpn = new ChiTietPhieuNhap[0];
    int n;
    public DanhSachCTPhieuNhap()
    {}
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong chi tiet phieu nhap ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dsctpn = Arrays.copyOf(dsctpn, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nNhap vao du lieu chi tiet phieu nhap thu "+(i+1)+":\n");
            dsctpn[i] = new ChiTietPhieuNhap();
            dsctpn[i].nhap();
            int j =0;
            if( i!= 0){
                while (j< i){
                    if ( Check_PrimaryKey( dsctpn[i].getMAPN(), dsctpn[j].getMAPN())){
                        System.out.print("\nChi tiet phieu nhap vua nhap co ma trung voi chi tiet phieu nhap truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dsctpn[i].nhap();
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
        n = dsctpn.length;
        System.out.print("\nDANH SACH CHI TIET HOA DON LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". ");
            dsctpn[i].xuat();
            System.out.print("\n");
        }
    }
    public void them () throws Exception
    {
        System.out.println("Nhap so chi tiet hoa don can them: ");
        int num = Integer.parseInt(scanner.nextLine());
        n = dsctpn.length;
        int dem =0;
        while(dem < num){
            System.out.print("\nNhap vao du lieu chi tiet hoa don thu "+(n+1)+":\n");
            dsctpn = Arrays.copyOf(dsctpn, n+1);
            dsctpn[n] = new ChiTietPhieuNhap();
            dsctpn[n].nhap();
            n++;
            dem++;
            for ( int j =0; j<n-1 ; j++){
                if ( Check_PrimaryKey( dsctpn[n-1].getMAPN(), dsctpn[j].getMAPN())){
                    System.out.print("\nChi tiet phieu nhap vua nhap co ma trung voi phieu nhap truoc do.");
                    System.out.print("\nNhap lai!!!");
                    dsctpn = Arrays.copyOf(dsctpn, n-1);
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
    public  ChiTietPhieuNhap timkiem(String mahd_ss){
        n = dsctpn.length;
        for ( int i=0; i<n; i++){
            if (dsctpn[i].getMAPN().equalsIgnoreCase(mahd_ss)){
                return dsctpn[i];
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
        n = dsctpn.length;
        for ( int i=0; i<n; i++){
            if (dsctpn[i].getMAPN().equalsIgnoreCase(ma)){     
                dsctpn[i] = new ChiTietPhieuNhap();
                dsctpn[i].nhap();
                int j =0;
                dem++;
                while (j< n){
                    if ( Check_PrimaryKey( dsctpn[i].getMAPN(), dsctpn[j].getMAPN()) && j!=i){
                        System.out.print("\nChi tiet phieu vua nhap co ma trung voi phieu nhap truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dsctpn[i].nhap();
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
            System.out.print("\nMa phieu nhap khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    public void xoa() throws Exception
    {
        System.out.println("nhap ma phieu nhap can xoa: ");
        String ma =scanner.nextLine();
        int dem=0;
        n = dsctpn.length;
        for ( int i=0; i<n; i++){
            if (dsctpn[i].getMAPN().equalsIgnoreCase(ma)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dsctpn[i]=dsctpn[i+1];
                }
                dsctpn = Arrays.copyOf(dsctpn, n-1);
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
        System.out.print("So luong chi tiet phieu nhap la: "+ dsctpn.length+"\n");
    }
    public void ghifile() throws IOException 
    {
        FileOutputStream fos = null;
        n = dsctpn.length;
        try {
            fos = new FileOutputStream("file\\chitietphieunhap.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dsctpn[i].getFileLine();
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
        n = dsctpn.length;
        try{
            fis = new FileInputStream("file\\chitietphieunhap.txt");
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
                dsctpn = Arrays.copyOf(dsctpn, n+1);
                dsctpn[n] = new ChiTietPhieuNhap();
                dsctpn[n].parse(line);
                dsctpn[n].getinfo(Integer.parseInt(param[1]));
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
                dsctpn = Arrays.copyOf(dsctpn, n+1);
                dsctpn[n] = new ChiTietPhieuNhap();
                dsctpn[n].parse(line);
                dsctpn[n].getinfoNULLChange(Integer.parseInt(param[1]));
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

