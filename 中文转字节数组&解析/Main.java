package IO解析;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       try{
           FileOutputStream outs=new FileOutputStream("C:\\Users\\小翰翰\\Desktop\\Code\\txt\\outs.txt");
//           C:\\Users\\小翰翰\\Desktop\\Code\\txt\\ins.txt
           System.out.println("请输入编码：");
           Scanner in=new Scanner(System.in);
           String input=in.nextLine();
           String[] arry=input.split(" ");
           byte[] bys=new byte[arry.length];
           for(int i=0;i<arry.length;i++)
           {
               bys[i]=(byte)Integer.parseInt(arry[i]);
           }
           outs.write(bys);
           outs.close();
           System.out.println(bys);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
