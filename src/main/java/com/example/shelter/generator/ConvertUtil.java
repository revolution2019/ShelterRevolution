package com.example.shelter.generator;

/**
 * 生成工具字符串转换工具
 *
 * @author pojun
 */
public class ConvertUtil {

    /**
     * 将fieldName转换成columnName
     */
    public static String convertColumn(String fieldName) {
        return fieldName.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * 将 className 转换为对应的参数形式
     */
    public static String convertParam(String className) {
        return className.replace(className.charAt(0), (char) (className.charAt(0) + 32));
    }
}
