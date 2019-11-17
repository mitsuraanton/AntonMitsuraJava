package lesson13.homeWork.exceptionsList;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class ExceptionsList {
    public static void main(String[] args) throws AccessDeniedException {
        try {
            throwException(Status.ACCESS_DENIED);
        } catch (JarException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            throw new AccessDeniedException("newFile2");
        }
    }

    public static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException {
        switch (status){
            case FILE_NOT_FOUND:
                throw new FileNotFoundException();
            case ACCESS_DENIED:
                throw new AccessDeniedException("newFile");
            case JAR_ERROR:
                throw new JarException();
        }
    }

    enum Status{
        FILE_NOT_FOUND,
        ACCESS_DENIED,
        JAR_ERROR,
        }
}
