package com.zql.utils.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ZxingCode {

    /**
     * 为二维码图片增加logo头像(原理类似于图片加水印)
     * @param imagePath 二维码图片存放路径(含文件名)
     * @param logoPath logo头像存放路径(含文件名)
     * @throws IOException
     */
    private static void overlapImage(String imagePath,String logoPath) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));
        int logoWidth = image.getWidth()/5;     // 设置logo的宽度为二维码的1/5
        int logoHeight = image.getHeight()/5;   // 设置logo的高度为二维码的1/5
        int logoX = (image.getWidth() - logoWidth)/2;   // 设置logo图片的位置，这里设置的是居中
        int logoY = (image.getHeight() - logoHeight)/2; // 设置logo图片的位置，这里设置的是居中
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(ImageIO.read(new File(logoPath)),logoX,logoY,logoWidth,logoHeight,null);
        graphics.dispose();
        ImageIO.write(image,imagePath.substring(imagePath.lastIndexOf(".") + 1),new File(imagePath));
    }

    /**
     * 生成二维码
     * @param content 二维码内容
     * @param charset 编码二维码时采用的字符集
     * @param imagePath 二维码图片存放路径(含文件名)
     * @param width 二维码宽度
     * @param height 二维码高度
     * @param logoPath logo的存放路径
     * @return 生成二维码的结果
     */
    public static boolean encodeQRCodeImage(String content,String charset,String imagePath,int width,int height,String logoPath) {
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
//        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");      // 指定编码格式
        hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.H);        // 指定纠错级别(L---7%,M---15%,Q---25%,H---30%)
        BitMatrix bitMatrix = null;     // 编码内容，编码类型(这里指定为二维码)，生成图片宽度，高度，设置参数
        try {
            bitMatrix = new MultiFormatWriter().encode(new String(content.getBytes(charset==null?"UTF-8":charset),"ISO-8859-1"),
                    BarcodeFormat.QR_CODE,width,height,hints);
        }catch (Exception e) {
            System.out.println("编码待生成二维码图片的文本时发生异常，堆栈轨迹如下");
            e.printStackTrace();
            return false;
        }

        // 生成的二维码图片默认背景为白色，前景为黑色，但是在加入logo图像后会导致logo会变成黑白的，
        // 所以需要将zixing的默认前景色由0xFF000000修改为0xFF000001,背景依然使用白色0xFFFFFFFF，一切都会正常显示
        MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001,0xFFFFFFFF);
        try {
            MatrixToImageWriter.writeToFile(bitMatrix,imagePath.substring(imagePath.lastIndexOf(".") + 1),new File(imagePath),config);
        }catch (Exception e) {
            System.out.println("生成二维码图片上时发生异常！！");
            e.printStackTrace();
            return false;
        }

        // 走到这里二维码已经生成了，但是没有logo
        if (null == logoPath) {
            return true;
        }else {
            try {
                overlapImage(imagePath,logoPath);
                return true;
            }catch (Exception e) {
                System.out.println("添加logo失败！！！");
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * 识别二维码
     * @param imagePath
     * @param charset
     * @return
     */
    public static String decodeQRCodeImage(String imagePath,String charset) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        if (null == image) {
            System.out.println("Could not decode QRCodeImage");
            return "";
        }
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        HashMap<DecodeHintType, String> hints = new HashMap<>();
        hints.put(DecodeHintType.CHARACTER_SET,charset==null?"UTF-8":charset);
        Result result = null;
        try {
            result = new MultiFormatReader().decode(bitmap,hints);
            return result.getText();
        }catch (Exception e) {
            System.out.println("二维码解析失败");
            e.printStackTrace();
            return "";
        }
    }
}
