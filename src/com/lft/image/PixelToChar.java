package com.lft.image;

/**
 * Class Name:      MapToChar
 * Package Name:    com.lft.image
 * <p>
 * Function: 		A {@code MapToChar} object With Some FUNCTION.
 * Date:            2021-05-18 13:36
 * <p>
 * @author Laifengting / E-mail:laifengting@foxmail.com
 * @version 1.0.0
 * @since JDK 8
 */
public class PixelToChar {
    
    /**
     * 映射到字符,遍历选择的字符集
     * @param asciiChar
     * @param rgbValue
     * @return
     */
    public static String mapperChar(Integer asciiChar, Integer rgbValue) {
        String ascii = null;
        switch (asciiChar) {
            case 1:
                ascii = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/*-+`!@#$%^&,.;:'\"{}[]<>~";
                break;
            case 2:
                ascii = "@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
                break;
            case 3:
                ascii = " #,.0123456789:;@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz$";
                break;
            case 4:
                ascii = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
            case 5:
                ascii = " 1234567890";
                break;
            case 6:
                ascii = "M@WB08Za2SX7r;i:;. ";
                break;
            case 7:
                ascii = "@#MBHAGh93X25Sisr;:, ";
                break;
            case 8:
                ascii = "█▓▒░ ";
                break;
            default:
                ascii = ".^-*`~=\" ';:,";
                break;
        }
        return mapperChar(ascii, rgbValue);
    }
    
    /**
     * 映射到字符,传入自定义字符
     * @param asciiChar
     * @param rgbValue
     * @return
     */
    public static String mapperChar(String asciiChar, Integer rgbValue) {
        int r = (rgbValue & 0xff0000) >> 16;
        int g = (rgbValue & 0x00ff00) >> 8;
        int b = (rgbValue & 0x0000ff);
        // 灰度值计算公式 1
        int grayValue1 = (int) (r * 0.2126 + g * 0.7152 + b * 0.0722);
        // 灰度值计算公式 2
        // int grayValue2 = (int) (r * 0.299 + g * 0.587 + b * 0.114);
        int length = asciiChar.length();
        double unit = (256.0 + 1) / length;
        int index = (int) (grayValue1 / unit);
        return String.valueOf(asciiChar.charAt(index));
    }
    
    /**
     * 映身到字符 传入 Object 对象 用于判断是字符集，还是字符集选项
     * @param asciiChar
     * @param rgbValue
     * @return
     */
    public static String mapperChar(Object asciiChar, Integer rgbValue) {
        String ascii = null;
        if (asciiChar instanceof Integer) {
            return mapperChar((Integer) asciiChar, rgbValue);
        } else if (asciiChar instanceof String) {
            return mapperChar((String) asciiChar, rgbValue);
        } else {
            throw new IllegalArgumentException("只能传入 数字 或者 自定义字符集的字符串");
        }
    }
    
    /**
     * 没传字符 什么都没传选择默认 1 字符
     * @param asciiChar
     * @param rgbValue
     * @return
     */
    public static String mapperChar(Integer rgbValue) {
        return mapperChar(1, rgbValue);
    }
}
