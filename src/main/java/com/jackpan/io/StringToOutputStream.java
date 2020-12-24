package com.jackpan.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author jackpan
 * @version v1.0 2020/12/24 16:41
 */
public class StringToOutputStream {

    public static void main(String[] args) throws IOException {
        String initialString = "text111";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes(
                StandardCharsets.UTF_8));
        OutputStream outputStream = new FileOutputStream("/Users/jackpan/Downloads/jack-test.txt");
        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = targetStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        targetStream.close();
        outputStream.close();
    }
}
