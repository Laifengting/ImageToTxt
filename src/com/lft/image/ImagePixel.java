package com.lft.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
public class ImagePixel {
    /**
     * 读取图片像素  指定输出 宽 高 对比度，亮度
     * @param imagePath
     * @return
     */
    public static int[][] getImagePixel(Image srcImage, Integer outPutWidth, Integer outPutHeight, float contrastRatio,
                                        float brightnessRatio) throws Exception {
        // 创建新的输出图片
        BufferedImage bufferedImage = new BufferedImage(outPutWidth, outPutHeight, BufferedImage.TYPE_INT_RGB);
        
        // 将输入图片转换大小
        bufferedImage.getGraphics().drawImage(
                srcImage.getScaledInstance(outPutWidth, outPutHeight, Image.SCALE_SMOOTH),
                0,
                0,
                null);
        
        ContrastBightNessAdjust contrastBightNessAdjust = new ContrastBightNessAdjust();
        contrastBightNessAdjust.setContrast(contrastRatio);
        contrastBightNessAdjust.setBrightness(brightnessRatio);
        bufferedImage = contrastBightNessAdjust.adjust(bufferedImage, null);
        
        /* 用于输出图片测试亮度对比度调节 */
        File out = new File("D:\\N04.jpg");
        ImageIO.write(bufferedImage, "jpg", out);
        
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int minX = bufferedImage.getMinX();
        int minY = bufferedImage.getMinY();
        
        int[][] rgb = new int[width][height];
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int imageRGB = bufferedImage.getRGB(i, j);
                rgb[i][j] = imageRGB;
            }
        }
        return rgb;
    }
    
    /**
     * 读取图片像素  指定输出 宽 对比度,亮度
     * @param imagePath
     * @return
     */
    public static int[][] getImagePixel(Image srcImage, Integer outPutWidth, float contrastRatio,
                                        float brightnessRatio) throws Exception {
        return getImagePixel(srcImage, outPutWidth, outPutWidth * srcImage.getHeight(null) / srcImage
                .getWidth(null), contrastRatio, brightnessRatio);
    }
    
    /**
     * 读取图片像素  指定 对比度,亮度
     * @param imagePath
     * @return
     */
    public static int[][] getImagePixel(Image srcImage, float contrastRatio, float brightnessRatio) throws Exception {
        return getImagePixel(srcImage, srcImage.getWidth(null), srcImage.getHeight(null), contrastRatio, brightnessRatio);
    }
    
    /**
     * 读取图片像素  指定 亮度
     * @param imagePath
     * @return
     */
    public static int[][] getImagePixel(Image srcImage, float brightnessRatio) throws Exception {
        return getImagePixel(srcImage, srcImage.getWidth(null), srcImage.getHeight(null), brightnessRatio);
    }
    
    /**
     * 读取图片像素
     * @param imagePath
     * @return
     */
    public static int[][] getImagePixel(Image srcImage) throws Exception {
        return getImagePixel(srcImage, srcImage.getWidth(null), srcImage.getHeight(null), 1.0F, 1.0F);
    }
}
