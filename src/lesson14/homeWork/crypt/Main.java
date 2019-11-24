package lesson14.homeWork.crypt;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ClassLoader loader = Main.class.getClassLoader();
        File file = new File(loader.getResource("lesson14inputFile.txt").getFile());
        File outputFile = new File("lesson14outputFile.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             OutputStream outputStream = new OutputStream(new FileOutputStream(outputFile))){
            int currentSymbol;
            while ((currentSymbol = fileInputStream.read()) > 0){
                outputStream.write(currentSymbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream fileInputStream = new InputStream(new FileInputStream(outputFile))){
            int currentSymbol;
            while ((currentSymbol = fileInputStream.read()) > 0){
                System.out.print((char)currentSymbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
