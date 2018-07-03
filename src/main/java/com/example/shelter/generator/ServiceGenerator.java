package com.example.shelter.generator;

/**
 * 基础 service 生成工具
 *
 * @author pojun
 */
public class ServiceGenerator {

    private static final String UPSERT = " /**\n"
            + "     * 创建或更新\n"
            + "     */\n"
            + "    Integer upsert(%s %s);\n";

    private static final String GET_BY_ID = "/**\n"
            + "     * 根据id获取\n"
            + "     */\n"
            + "    %s getById(Integer id);\n";

    private static final String LIST_BY_FILTER = "  /**\n"
            + "     * 根据查询条件分页获取(精确查询)\n"
            + "     */\n"
            + "    List<%s> listByFilter(%s %s, Integer page, Integer limit);\n";

    private static final String COUNT_BY_FILTER = " /**\n"
            + "     * 根据精确查询 count\n"
            + "     */\n"
            + "    Long countByFilter(%s %s);\n";

    // 类名
    private static String simpleName;
    // 参数名
    private static String param;

    public static String generateService(Class clazz) {
        simpleName = clazz.getSimpleName();
        param = ConvertUtil.convertParam(simpleName);

        StringBuilder sb = new StringBuilder();

        sb.append(genUpset());
        sb.append("\n");

        sb.append(genGetById());
        sb.append("\n");

        sb.append(genListByFilter());
        sb.append("\n");

        sb.append(genCountByFilter());
        sb.append("\n");

        return sb.toString();
    }

    /**
     * 生成 upsert
     */
    private static String genUpset() {
        return String.format(UPSERT, simpleName, param);
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
    private static String genListByFilter() {
        return String.format(LIST_BY_FILTER, simpleName, simpleName, param);
    }

    /**
     * 生成 countById
     */
    private static String genCountByFilter() {
        return String.format(COUNT_BY_FILTER, simpleName, param);
    }

    // public static void main(String[] args) {
    //     System.out.println(ServiceGenerator.generateService(Test.class));
    // }
}
