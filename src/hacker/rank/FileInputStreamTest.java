package hacker.rank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int readFirstByte(final File f) throws IOException {
        int bytes;
        try (FileInputStream inStream = new FileInputStream(f)) {
            bytes = inStream.read();
        }
        return bytes;
    }

}
