package com.example.shelter.generator;

/**
 * Mapper 接口生成工具
 *
 * @author pojun
 */
public class MapperInterfaceGenerator {

    private static final String SAVE = " /**\n"
            + "     * 插入\n"
            + "     */\n"
            + "    Integer save(%s %s);\n";

    private static final String GET_BY_ID = "/**\n"
            + "     * 根据id获取\n"
            + "     */\n"
            + "    %s getById(Integer id);\n";

    private static final String LIST_BY_FILTER = "/**\n"
            + "     * 根据查询条件获取（精确查询）\n"
            + "     *\n"
            + "     * @param params 字段、分页字段（offset、limit）\n"
            + "     */\n"
            + "    List<%s> listByFilter(Map params);\n";

    private static final String COUNT_BY_FILTER = "/**\n"
            + "     * 根据精确查询 count\n"
            + "     */\n"
            + "    Long countByFilter(%s %s);\n";

    private static final String UPDATE = " /**\n"
            + "     * 更新\n"
            + "     */\n"
            + "    Integer update(%s %s);\n";

    // 类名
    private static String simpleName;
    // 参数名
    private static String param;

    public static String generateMapperInterface(Class clazz) {
        simpleName = clazz.getSimpleName();
        param = ConvertUtil.convertParam(simpleName);

        StringBuilder sb = new StringBuilder();
        sb.append(genSave());
        sb.append("\n");

        sb.append(genGetById());
        sb.append("\n");

        sb.append(genListByFitler());
        sb.append("\n");

        sb.append(genCountByFilter());
        sb.append("\n");

        sb.append(genUpdate());
        sb.append("\n");

        return sb.toString();
    }

    /**
     * 生成保存
     */
    private static String genSave() {
        return String.format(SAVE, simpleName, param);
    }

    /**
     * 生成 getById
     */
    private static String genGetById() {
        return String.format(GET_BY_ID, simpleName);
    }

    /**
     * 生成 listByFilter
     */
    private static String genListByFitler() {
        return String.format(LIST_BY_FILTER, simpleName);
    }

    /**
     * 生成 countByFilter
     */
    private static String genCountByFilter() {
        return String.format(COUNT_BY_FILTER, simpleName, param);
    }

    /**
     * 生成 update
     */
    private static String genUpdate() {
        return String.format(UPDATE, simpleName, param);
    }

    // public static void main(String[] args) {
    //     System.out.println(MapperInterfaceGenerator.generateMapperInterface(Test.class));
    // }
}
