package com.example.shelter.generator;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * 基础 mapper 生成器
 *
 * @author pojun
 */
public class MapperGenerator {

    private static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n"
            + "    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n";

    private static final String MAPPER_PREFIX = "<mapper namespace=\"%s\">\n";

    private static final String MAPPER_IMPL_MAPPER = ".impl.mapper";

    private static final String MAPPER_SUFFIX = "</mapper>\n";

    private static final String SAVE_PREFIX =
            " <!-- 插入  -->\n<insert id=\"save\" parameterType=\"%s\"\n"
                    + "        useGeneratedKeys=\"true\"\n"
                    + "        keyProperty=\"id\">\n";

    private static final String SAVE_INSERT = "INSERT INTO %s \n";

    private static final String SAVE_TRIM_PREFIX =
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\","
                    + "\">\n";

    private static final String IF_PREFIX = "<if test=\"%s != null\">\n";

    private static final String IF_SUFFIX = "</if>\n";

    private static final String TRIM_SUFFIX = "</trim>\n";

    private static final String SAVE_SUFFIX = "</insert>\n";

    private static final String GET_BY_ID = "<!-- 根据id获取  -->\n"
            + "    <select id=\"getById\" parameterType=\"int\"\n"
            + "        resultType=\"%s\">\n"
            + "        SELECT *\n"
            + "        FROM %s\n"
            + "        WHERE id = #{id}\n"
            + "    </select>";

    private static final String LIST_BY_FILTER_PREFIX = "<!-- 根据查询条件获取(精确查询) -->\n"
            + "    <select id=\"listByFilter\" parameterType=\"Map\"\n"
            + "        resultType=\"%s\">\n"
            + "        SELECT *\n"
            + "        FROM %s\n <trim prefix=\"where\" prefixOverrides=\"and \" "
            + "suffixOverrides=\",\">\n";

    private static final String LIST_BY_FILTER_TRIM_ID = "  <if test=\"id != null\">\n"
            + "                and id = #{id}\n"
            + "            </if>\n";

    private static final String LIST_BY_FILTER_TRIM = " <if test=\"%s != null\">\n"
            + "                and %s = #{%s}\n"
            + "            </if>\n";

    private static final String LIST_BY_FILTER_SUFFIX = "  </trim>\n"
            + "        limit #{offset},#{limit}\n"
            + "    </select>\n";

    private static final String UPDATE_PREFIX = "<!-- 更新 -->\n"
            + "    <update id=\"update\" parameterType=\"%s\">\n"
            + "        UPDATE %s\n"
            + "        <set>\n";

    private static final String UPDATE_TRIM = "<if test=\"%s != null\">\n"
            + "                %s = #{%s},\n"
            + "            </if>\n";

    private static final String UPDATE_SUFFIX = " </set>\n"
            + "        WHERE id = #{id}\n"
            + "    </update>";

    private static final String COUNT_PREFIX = "<!-- 根据精确查询count -->\n"
            + "    <select id=\"countByFilter\" parameterType=\"%s\"\n"
            + "        resultType=\"Long\">\n"
            + "        SELECT count(id)\n"
            + "        FROM %s\n"
            + "        <trim prefix=\"where\" prefixOverrides=\"and \" suffixOverrides=\",\">";

    private static final String COUNT_SUFFIX = " </trim>\n"
            + "    </select>\n";

    // todo 表名前缀
    private static final String TABLE_PREFIX = "ota";
    // 除id外的field
    private static List<String> FIELDS = new LinkedList<String>();
    // 除id外的column
    private static List<String> COLUMNS = new LinkedList<String>();
    private static String TABLE_NAME;

    public static String generateMapper(Class clazz) {
        init(clazz);
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER);
        sb.append(String.format(MAPPER_PREFIX, getMapperName(clazz)));
        sb.append("\n");

        sb.append(genSave(clazz));
        sb.append("\n");

        sb.append(genGetById(clazz));
        sb.append("\n\n");

        sb.append(genListByFilter(clazz));
        sb.append("\n");

        sb.append(genCount(clazz));
        sb.append("\n");

        sb.append(genUpdate(clazz));
        sb.append("\n\n");

        sb.append(MAPPER_SUFFIX);

        return sb.toString();
    }

    /**
     * 生成save mapper
     */
    private static String genSave(Class clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(SAVE_PREFIX, clazz.getName()));

        sb.append(String.format(SAVE_INSERT, TABLE_NAME));

        sb.append(SAVE_TRIM_PREFIX);
        for (int i = 0; i < FIELDS.size(); i++) {
            sb.append(String.format(IF_PREFIX, FIELDS.get(i)));
            sb.append(COLUMNS.get(i) + ",\n");
            sb.append(IF_SUFFIX);
        }
        sb.append(TRIM_SUFFIX);

        sb.append("VALUES\n");

        sb.append(SAVE_TRIM_PREFIX);
        for (int i = 0; i < FIELDS.size(); i++) {
            sb.append(String.format(IF_PREFIX, FIELDS.get(i)));
            sb.append(String.format("#{%s},\n", FIELDS.get(i)));
            sb.append(IF_SUFFIX);
        }
        sb.append(TRIM_SUFFIX);

        sb.append(SAVE_SUFFIX);
        return sb.toString();
    }

    /**
     * 生成 getById mapper
     */
    private static String genGetById(Class clazz) {
        return String.format(GET_BY_ID, clazz.getName(), TABLE_NAME);
    }

    /**
     * 生成 listByFilter mapper
     */
    private static String genListByFilter(Class clazz) {
        return genList(clazz, LIST_BY_FILTER_PREFIX, LIST_BY_FILTER_SUFFIX);
    }

    /**
     * 生成 countByFilter mapper
     */
    private static String genCount(Class clazz) {
        return genList(clazz, COUNT_PREFIX, COUNT_SUFFIX);
    }

    private static String genList(Class clazz, String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(prefix, clazz.getName(), TABLE_NAME));

        sb.append(LIST_BY_FILTER_TRIM_ID);

        for (int i = 0; i < FIELDS.size(); i++) {
            sb.append(String.format(LIST_BY_FILTER_TRIM, FIELDS.get(i), COLUMNS.get(i),
                    FIELDS.get(i)));
        }

        sb.append(suffix);
        return sb.toString();
    }

    /**
     * 生成 update mapper
     */
    private static String genUpdate(Class clazz) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(UPDATE_PREFIX, clazz.getName(), TABLE_NAME));

        for (int i = 0; i < FIELDS.size(); i++) {
            sb.append(String.format(UPDATE_TRIM, FIELDS.get(i), COLUMNS.get(i), FIELDS.get(i)));
        }

        sb.append(UPDATE_SUFFIX);

        return sb.toString();
    }

    /**
     * 获取domain fileds及columns
     */
    private static void init(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String columnName = ConvertUtil.convertColumn(
                    fieldName);
            if (!"id".equals(fieldName)) {
                FIELDS.add(fieldName);
                COLUMNS.add(columnName);
            }
        }
        String clazzName = clazz.getSimpleName();
        TABLE_NAME = TABLE_PREFIX + ConvertUtil.convertColumn(clazzName);
    }

    /**
     * 获取对应mapperName
     */
    private static String getMapperName(Class clazz) {
        return clazz.getName().replace("entity", "mapper").concat("Mapper");
    }

    // public static void main(String[] args) {
    //     System.out.println(MapperGenerator.generateMapper(Test.class));
    // }
}
