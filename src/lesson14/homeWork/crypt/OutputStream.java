package lesson14.homeWork.crypt;

import java.io.FilterOutputStream;
import java.io.IOException;

public class OutputStream extends FilterOutputStream {
    public OutputStream(java.io.OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        char xorKey = 'A';
        out.write(b ^ xorKey);
    }
}
