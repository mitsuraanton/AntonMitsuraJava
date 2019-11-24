package lesson14.homeWork;

import java.io.*;

public class SeparateFileIntoTwoPartsAndGatherTwoFilesIntoOne {
    public static void main(String[] args) {
        ClassLoader loader = SeparateFileIntoTwoPartsAndGatherTwoFilesIntoOne.class.getClassLoader();
        File file = new File(loader.getResource("lesson14inputFile.txt").getFile());
        separateFileIntoTwoParts(file);
        File file2 = new File(loader.getResource("lesson14inputFile2.txt").getFile());
        gatherTwoFilesIntoOne(file, file2);
    }

    public static void separateFileIntoTwoParts(File file){
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(new File("lesson14outputFile1.txt"));
             FileOutputStream fileOutputStream2 = new FileOutputStream(new File("lesson14outputFile2.txt"))
            ){
            for (int i = 0; i < (file.length()/2); i++) {
                fileOutputStream.write(fileInputStream.read());
            }
            int currentSymbol;
            while ((currentSymbol = fileInputStream.read()) > 0){
                fileOutputStream2.write(currentSymbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gatherTwoFilesIntoOne(File file1, File file2){
        try (FileInputStream fileInputStream1 = new FileInputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("lesson14outputFile.txt"))){
            int currentSymbol;
            while ((currentSymbol = fileInputStream1.read()) > 0){
                fileOutputStream.write(currentSymbol);
            }
            while ((currentSymbol = fileInputStream2.read()) > 0){
                fileOutputStream.write(currentSymbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
