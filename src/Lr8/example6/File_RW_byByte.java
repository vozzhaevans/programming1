package Lr8.example6;

import java.io.*;

public class File_RW_byByte {
    public static void main(String[] args) throws IOException {
        Reader in=null;
        Writer out=null;

        try {
        in =  new FileReader("c:\\MyFile1.txt");
        out= new FileWriter("c:\\MyFile2.txt", true);

            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.write((char)oneByte);
                out.append((char)oneByte);
                System.out.print((char)oneByte);
            }
        } catch (IOException e) { System.out.println("Ошибка!!!! ");
        }
        finally{
            in.close();
            out.close();
        } }

}
