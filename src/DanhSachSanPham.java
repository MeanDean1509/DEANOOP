package src;
import java.io.*;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
public class DanhSachSanPham implements RangBuocClassDanhSach{
    int n;
    static SanPham[] dssp = new SanPham[0];
    public DanhSachSanPham(){}
    
    //Ham kiem tra trung khoa chinh
    public boolean Check_PrimaryKey( String pr_key_input, String pr_key_saved){
        if ( pr_key_input.equalsIgnoreCase(pr_key_saved)) return true;
        else return false;
    }
    //Ghi File
    public void ghifile() throws IOException 
    {

        FileOutputStream fos = null;
        n = dssp.length;
        try {
            fos = new FileOutputStream("file\\sanpham.txt", false);
            for ( int i =0; i< n; i++)
            {
                String line = dssp[i].getFileLine();
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
    //Doc file
    public void docFile(int num) throws Exception
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = num;
        try{
            fis = new FileInputStream("file\\sanpham.txt");
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
                if ( param.length == 7){
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new ThucAn();
                    dssp[n].parse(line);
                    n++;
                }
                if ( param.length == 6){
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new PhuKien();
                    dssp[n].parse(line);
                    n++;
                }
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
    public void docFile() throws Exception
    {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        n = dssp.length;
        try{
            fis = new FileInputStream("file\\sanpham.txt");
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
                if ( param.length == 7){
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new ThucAn();
                    dssp[n].parse(line);
                    n++;
                }
                if ( param.length == 6){
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new PhuKien();
                    dssp[n].parse(line);
                    n++;
                }
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
    //Ham nhap n phan tu dau tien.
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong san pham ban dau: ");
        int number = Integer.parseInt(in.readLine());
        n = number;
        dssp = Arrays.copyOf(dssp, n);
        for ( int i =0; i<n; i++){
            System.out.print("\nLoai san pham :");
            System.out.print("\n1. Thuc An.");
            System.out.print("\n2. Phu Kien.");
            System.out.print("\nChon loai san pham can nhap vao (1 hoac 2):");
            int num;
            num = Integer.parseInt(in.readLine());
            switch(num){
                case 1:{
                    System.out.print("\nNhap vao du lieu san pham thu "+(i+1)+":\n");
                    dssp[i] = new ThucAn();
                    dssp[i].nhap();
                    int j =0;
                    if( i!= 0){
                        while (j< i){
                            if ( Check_PrimaryKey( dssp[i].getMASANPHAM(), dssp[j].getMASANPHAM())){
                                System.out.print("\nSan pham vua nhap co ma san pham trung voi san pham truoc do.");
                                System.out.print("\nNhap lai!!!\n");
                                dssp[i].nhap();
                                j=0;    
                            }
                            else{
                                j++;
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.print("\nNhap vao du lieu san pham thu "+(i+1)+":\n");
                    dssp[i] = new PhuKien();
                    dssp[i].nhap();
                    int j =0;
                    if( i!= 0){
                        while (j< i){
                            if ( Check_PrimaryKey( dssp[i].getMASANPHAM(), dssp[j].getMASANPHAM())){
                                System.out.print("\nSan pham vua nhap co ma san pham trung voi san pham truoc do.");
                                System.out.print("\nNhap lai!!!\n");
                                dssp[i].nhap();
                                j=0;    
                            }
                            else{
                                j++;
                            }
                        }
                    }
                    break;
                }
            }
        }
       
    }
    //Xuat danh sach
    public void xuat(){
        n = dssp.length;
        System.out.print("\nDANH SACH SAN PHAM LA: \n");
        for ( int i=0; i<n; i++){
            System.out.print((i+1)+". "+ dssp[i].decription());
            dssp[i].xuat();
            System.out.print("\n");
        }
    }
    //Ham them moi 1 hoac k phan tu moi
    public void them() throws Exception{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("\nNhap vao so luong san pham can them moi: ");
        int soluong = Integer.parseInt(in.readLine());
        int dem = 0;
        while(dem < soluong){
            System.out.print("\nLoai san pham :");
            System.out.print("\n1. Thuc An.");
            System.out.print("\n2. Phu Kien.");
            System.out.print("\nChon loai san pham can them vao (1 hoac 2):");
            int num;
            num = Integer.parseInt(in.readLine());
            switch(num){
                case 1:{
                    n = dssp.length;
                    System.out.print("\nNhap vao du lieu san pham thu "+(n+1)+":\n");
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new ThucAn();
                    dssp[n].nhap();
                    n++;
                    dem++;
                    for ( int j =0; j<n-1 ; j++){
                        if ( Check_PrimaryKey( dssp[n-1].getMASANPHAM(), dssp[j].getMASANPHAM())){
                            System.out.print("\nSan pham vua nhap co ma san pham trung voi san pham truoc do.");
                            System.out.print("\nNhap lai!!!");
                            dssp = Arrays.copyOf(dssp, n-1);
                            n--;
                            dem--;
                            break;
                        }
                        
                    }
                    break;
                }
                case 2:{
                    n = dssp.length;
                    System.out.print("\nNhap vao du lieu san pham thu "+(n+1)+":\n");
                    dssp = Arrays.copyOf(dssp, n+1);
                    dssp[n] = new PhuKien();
                    dssp[n].nhap();
                    n++;
                    dem++;
                    for ( int j =0; j < n-1 ; j++){
                        if ( Check_PrimaryKey( dssp[n-1].getMASANPHAM(), dssp[j].getMASANPHAM())){
                            System.out.print("\nSan pham vua nhap co ma san pham trung voi san pham truoc do.");
                            System.out.print("\nNhap lai!!!");
                            dssp = Arrays.copyOf(dssp, n-1);
                            n--;
                            dem--;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (dem == soluong){
            System.out.print("\nDa them thanh cong.");
        }
    }
    
    //Xoa phan tu theo ma san pham
    public void xoa() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nNhap vao ma cua san pham can xoa: ");
        String masanpham_ss = in.readLine();
        int dem=0;
        n = dssp.length;
        for ( int i=0; i<n; i++){
            if (dssp[i].getMASANPHAM().equals(masanpham_ss)){
                dem+=1;
                for ( int j=i; j< n-1; j++){
                    dssp[i]=dssp[i+1];
                }
                dssp = Arrays.copyOf(dssp, n-1);
                n--;
            }
        }
        if (dem>0){
            System.out.print("\nXoa thanh cong!!!");
        }
        else{
            System.out.print("\nMa san pham khong trung khop voi du lieu trong danh sach!!!");
        }
    }

    //Sua phan tu theo ma san pham
    public void sua() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nNhap vao ma cua san pham can sua du lieu: ");
        String masanpham_ss = in.readLine();
        int dem=0;
        n = dssp.length;
        for ( int i=0; i<n; i++){
            if (dssp[i].getMASANPHAM().equalsIgnoreCase(masanpham_ss)){
                if(dssp[i] instanceof ThucAn){
                    dssp[i] = new ThucAn();
                    dssp[i].nhap();
                    dem++;
                }
                if(dssp[i] instanceof PhuKien){
                    dssp[i] = new PhuKien();
                    dssp[i].nhap();
                    dem++;
                }
                int j =0;
                while (j< n){
                    if ( Check_PrimaryKey( dssp[i].getMASANPHAM(), dssp[j].getMASANPHAM()) && j!=i){
                        System.out.print("\nSan pham vua nhap co ma trung voi san pham truoc do.");
                        System.out.print("\nNhap lai!!!\n");
                        dssp[i].nhap();
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
            System.out.print("\nMa san pham khong trung khop voi du lieu trong danh sach!!!");
        }
    }
    //Tim kiem theo ma san pham
    public  SanPham timkiem(String masp_ss){
        // System.out.print("\nKet qua tim kiem:\n");
        n = dssp.length;
        //SanPham [] luusanPham = new SanPham[1];
        for ( int i=0; i<n; i++){
            if (dssp[i].getMASANPHAM().equalsIgnoreCase(masp_ss)){
                //luusanPham[0] =  dssp[i];
                return dssp[i];
            }
        }
        return null;
    }
    //Tim kiem
    public void timkiem() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int mstimkiem= Integer.parseInt(in.readLine());
        if (mstimkiem<1 || mstimkiem>6){
            System.out.print("\nBan da nhap sai ma so.");
        }
        else
        {
            switch(mstimkiem){
                case 1:{
                    System.out.print("\nNhap vao ma san pham: ");
                    String masanpham_ss = in.readLine();
                    System.out.print("\nKet qua tim kiem: \n");
                    if(timkiem(masanpham_ss)!= null){
                        timkiem(masanpham_ss).xuat();
                    }
                    else System.out.print("\nKhong tim thay");
                    break;
                }
                case 2:{
                    System.out.print("\nNhap vao ten cua san pham (Co the nhap gan dung): ");
                    String tensanpham_ss = in.readLine();
                    tensanpham_ss = tensanpham_ss.toLowerCase();
                    n = dssp.length;
                    System.out.print("\nKet qua tim kiem:\n");
                    int dem=0;
                    for ( int i=0; i<n; i++){
                        String Tensanpham_lowercase = dssp[i].getTENSANPHAM().toLowerCase();
                        if (Tensanpham_lowercase.indexOf(tensanpham_ss)!=-1){
                            dem++;
                            dssp[i].xuat();
                            System.out.print("\n");
                        }
                    }
                    if (dem==0) System.out.print("\nTen san pham khong trung voi du lieu trong danh sach");
                    break;
                }
                case 3:{
                    System.out.print("\nLua chon de thong ke: ");
                    System.out.print("\n1. San pham co gia lon hon 1 trieu vnd");
                    System.out.print("\n2. San pham co gia thap hon hoac bang 1 trieu vnd");
                    int luachon = Integer.parseInt(in.readLine());
                    System.out.print("\nKet qua tim kiem:\n");
                    n = dssp.length;
                    switch(luachon){
                        case 1:{
                            for ( int i=0; i<n; i++){
                                if (dssp[i].getDONGIA()>1000000)
                                {
                                    dssp[i].xuat();
                                }
                            }  
                            break;  
                        }
                        case 2:{
                            for ( int i=0; i<n; i++){
                                if (dssp[i].getDONGIA()<=1000000)
                                {
                                    dssp[i].xuat();
                                }
                            }  
                            break;  
                        }
                       
                    }
                    break;
                }
                case 4:{
                    System.out.print("\nNhap vao loai su dung thuc an:");
                    String loaisudung_ss = in.readLine();
                    n = dssp.length;
                    System.out.print("\nKet qua tim kiem:\n");
                    for ( int i=0; i<n; i++){
                        if (dssp[i] instanceof ThucAn){
                            ThucAn ta = new ThucAn();
                            ta = (ThucAn)dssp[i];
                            if (ta.getLOAISUDUNG().equalsIgnoreCase(loaisudung_ss))
                            ta.xuat();
                            System.out.print("\n");
                        }
                    }
                    break;
                }
                case 5:{
                    System.out.print("\nNhap vao dang thuc an can tim kiem: ");
                    String dangthucan_ss = in.readLine();
                    n = dssp.length;
                    System.out.print("\nKet qua tim kiem:\n");
                    for ( int i=0; i<n; i++){
                        if (dssp[i] instanceof ThucAn){
                            ThucAn t_an = new ThucAn();
                            t_an = (ThucAn)dssp[i];
                            if (t_an.getDANG().equalsIgnoreCase(dangthucan_ss))
                            t_an.xuat();
                            System.out.print("\n");
                        }
                    }
                    break;
                }
            }
        }
    }
    //Thong ke
    public void thongke() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int msthongke= Integer.parseInt(in.readLine());
        switch(msthongke){
            case 1:{
                n = dssp.length;
                int dem =0;
                for ( int i=0; i<n; i++){
                    if (dssp[i] instanceof ThucAn){
                        dem++;
                    }
                }
                System.out.print("\nSo luong san pham thuc an la:" + dem);
                break;
            }
            case 2:{
                n = dssp.length;
                int dem =0;
                for ( int i=0; i<n; i++){
                    if (dssp[i] instanceof PhuKien){
                        dem++;
                    }
                }
                System.out.print("\nSo luong san pham phu kien la:" + dem);
                break;
            }
        }
    }
}