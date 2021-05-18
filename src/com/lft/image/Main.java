package com.lft.image;

/**
 * Class Name:      Main
 * Package Name:    com.lft.image
 * <p>
 * Function: 		A {@code Main} object With Some FUNCTION.
 * Date:            2021-05-18 15:07
 * <p>
 * @author Laifengting / E-mail:laifengting@foxmail.com
 * @version 1.0.0
 * @since JDK 8
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 图片路径
        String imagePath = "D:\\04.jpg";
        // 转换后的文本路径
        String textPath = "D:\\code04.txt";
        // 输出宽度大小
        Integer outWidth = 50;
        /* 对比度 */
        float contrastRatio = 1.0f;
        /* 亮度 */
        float brightnessRatio = 1.0f;
        ImageToTxt.imageToTxt(imagePath, 2, textPath, outWidth, contrastRatio, brightnessRatio);
    }
}
