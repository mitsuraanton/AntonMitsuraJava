package lesson14.homeWork.crypt;

import java.io.FilterInputStream;
import java.io.IOException;

public class InputStream extends FilterInputStream {
    protected InputStream(java.io.InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        char xorKey = 'A';
        return  in.read() ^ xorKey;
    }
}
