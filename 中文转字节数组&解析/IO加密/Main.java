package IO加密;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        try {
            byte[] bys=new byte[1000];
            FileInputStream fis = new FileInputStream("C:\\Users\\小翰翰\\Desktop\\Code\\txt\\ins.txt");
//            fis.read(bys);
            FileOutputStream outs=new FileOutputStream("C:\\Users\\小翰翰\\Desktop\\Code\\txt\\outs.txt");
            int len;
            while((len=fis.read())!=-1){
                System.out.print(len+" ");
                outs.write(len);
            }
            fis.close();
            outs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
