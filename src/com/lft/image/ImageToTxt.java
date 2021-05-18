package com.lft.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;

/**
 * Class Name:      ImageToTxt
 * Package Name:    com.lft.image
 * <p>
 * Function: 		A {@code ImageToTxt} object With Some FUNCTION.
 * Date:            2021-05-18 8:30
 * <p>
 * @author Laifengting / E-mail:laifengting@foxmail.com
 * @version 1.0.0
 * @since JDK 8
 */
public class ImageToTxt {
    
    /**
     * 转换 指定图片 宽 高 亮度 对比度 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Integer imageHeight, float contrastRatio,
                                  float brightnessRatio, Object asciiChar) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, imageHeight, contrastRatio, brightnessRatio);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 宽 亮度 对比度 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, Object asciiChar, String txtPath, Integer imageWidth, float contrastRatio,
                                  float brightnessRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, contrastRatio, brightnessRatio);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 亮度 对比度 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(Object asciiChar, String imagePath, String txtPath, float brightnessRatio, float contrastRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, contrastRatio, brightnessRatio);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 亮度 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, float brightnessRatio, Object asciiChar) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, brightnessRatio);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 宽 高 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Integer imageHeight, Object asciiChar) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, imageHeight);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 宽 字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Object asciiChar) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth);
        execute(txtPath, imagePixel, asciiChar);
    }
    
    /**
     * 转换 指定图片 宽 高 亮度对比度
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Integer imageHeight, float contrastRatio,
                                  float brightnessRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, imageHeight, contrastRatio, brightnessRatio);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 转换 指定图片 宽 亮度对比度
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, float contrastRatio,
                                  float brightnessRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, contrastRatio, brightnessRatio);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 转换 指定图片 宽 高 亮度
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Integer imageHeight, float brightnessRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, imageHeight, brightnessRatio);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 转换 指定图片 宽 亮度
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, float brightnessRatio) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, brightnessRatio);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 转换 指定图片 宽 高
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth, Integer imageHeight) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth, imageHeight);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 转换 指定图片 宽
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath, Integer imageWidth) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc, imageWidth);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 没有指定
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @throws Exception
     */
    public static void imageToTxt(String imagePath, String txtPath) throws Exception {
        Image imagesrc = ImageIO.read(new File(imagePath));
        int[][] imagePixel = ImagePixel.getImagePixel(imagesrc);
        execute(txtPath, imagePixel);
    }
    
    /**
     * 指定不明字符集
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @param imagePixel
     * @throws Exception
     */
    public static void execute(String txtPath, int[][] imagePixel, Object asciiChar) throws Exception {
        File file = new File(txtPath);
        // 文件如果存在，删除
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 设置偏移量
        raf.seek(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < imagePixel[0].length; i++) {
            for (int j = 0; j < imagePixel.length; j++) {
                stringBuilder.append(PixelToChar.mapperChar(asciiChar, imagePixel[j][i]));
            }
            stringBuilder.append("\n");
        }
        raf.seek(stringBuilder.length());
        raf.write(stringBuilder.toString().getBytes());
        raf.close();
        System.out.println("============ 创建 Txt 结束 ============");
    }
    
    /**
     * 没有指定
     * @param asciiChar
     * @param imagePath
     * @param txtPath
     * @param imagePixel
     * @throws Exception
     */
    public static void execute(String txtPath, int[][] imagePixel) throws Exception {
        execute(txtPath, imagePixel, 1);
    }
}
