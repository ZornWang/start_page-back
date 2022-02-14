package com.zorn.startpage.base.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class FileUtils {

    public static String getBase64(InputStream inputStream){
        byte[] data = null;
        try {
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Base64.Encoder encoder=Base64.getEncoder();
        return encoder.encodeToString(data);
    }

    public static String getBase64(byte[] data){
        // 加密
        Base64.Encoder encoder=Base64.getEncoder();
        return encoder.encodeToString(data);
    }



    public static void base64ToFile(String base64, String fileName, String savePath) {
        File file = null;
        //创建文件目录
        String filePath = savePath;
        File dir = new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64);
            file=new File(filePath + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void base64ToFile(String base64,OutputStream outputStream) {
            try {
            byte[] bytes = Base64.getDecoder().decode(base64);
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将BufferedImage转换为InputStream
     * @param image
     * @return
     */
    public static InputStream bufferedImageToInputStream(BufferedImage image){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", os);
            InputStream input = new ByteArrayInputStream(os.toByteArray());
            return input;
        } catch (IOException e) {
        }
        return null;
    }

    public static byte[] bufferedImageToByte(BufferedImage image){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", os);
            return os.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }
}
