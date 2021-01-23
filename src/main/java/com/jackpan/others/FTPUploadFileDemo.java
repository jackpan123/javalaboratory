package com.jackpan.others;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jackpan
 * @version v1.0 2021/1/12 14:14
 */
public class FTPUploadFileDemo {

    public static void main(String[] args) {
        String server = "192.168.89.6";
        int port = 21;
        String user = "lczy";
        String pass = "lczy";
        Map<String, Integer> map = new ConcurrentHashMap<>();

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println(ftpClient.changeToParentDirectory());

            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("/Users/jackpan/Downloads/功能点确认.txt");

            String firstRemoteFile = "/home/lczy/Projects.zip";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            System.out.println(ftpClient.getReplyString());
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }

            // APPROACH #2: uploads second file using an OutputStream
//            File secondLocalFile = new File("E:/Test/Report.doc");
//            String secondRemoteFile = "test/Report.doc";
//            inputStream = new FileInputStream(secondLocalFile);
//
//            System.out.println("Start uploading second file");
//            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
//            byte[] bytesIn = new byte[4096];
//            int read = 0;
//
//            while ((read = inputStream.read(bytesIn)) != -1) {
//                outputStream.write(bytesIn, 0, read);
//            }
//            inputStream.close();
//            outputStream.close();
//
//            boolean completed = ftpClient.completePendingCommand();
//            if (completed) {
//                System.out.println("The second file is uploaded successfully.");
//            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
