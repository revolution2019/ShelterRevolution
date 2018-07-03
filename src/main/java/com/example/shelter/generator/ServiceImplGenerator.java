package com.example.shelter.generator;

/**
 * serivce 基本实现生成工具类
 *
 * @author pojun
 */
public class ServiceImplGenerator {

    private static final String SERVICE_IMPL_SUFFIX = " @Resource\n"
            + "    private %s %s;\n"
            + "\n";

    private static final String UPSERT = "    @Override\n"
            + "    public Integer upsert(%s %s) {\n"
            + "        log.debug(\"==插入或更新%s== description:{}\", %s);\n"
            + "        if (%s.getId() == null || getById(%s.getId()) == null)"
            + " {\n"
            + "            log.debug(\"==插入或更新%s，插入%s== description:{}\", %s);\n"
            + "            return %s.save(%s);\n"
            + "        } else {\n"
            + "            log.debug(\"==插入或更新%s，更新%s== description:{}\", %s);\n"
            + "            return %s.update(%s);\n"
            + "        }\n"
            + "    }\n"
            + "\n";

    public static final String GET_BY_ID = "    @Override\n"
            + "    public %s getById(Integer id) {\n"
            + "        log.debug(\"==根据id获取%s== id:{}\", id);\n"
            + "        return %s.getById(id);\n"
            + "    }\n"
            + "\n";

    public static final String LIST_BY_FILTER = "    @Override\n"
            + "    public List<%s> listByFilter(%s %s, Integer "
            + "page, Integer limit){\n"
            + "        log.debug(\"==精准查询%s== description:{},page:{},limit:{}\",%s,page,limit);\n"
            + "        Map<String, Object> params = new HashMap<>();\n"
            + "        Integer offset = (page - 1) * limit;\n"
            + "        params.put(\"offset\", offset);\n"
            + "        params.put(\"limit\", limit);\n"
            + "        params.putAll(JSONObject.parseObject(JSONObject.toJSONString(%s)"
            + "));\n"
            + "        return %s.listByFilter(params);\n"
            + "    }\n";

    public static final String COUNT_BY_FILTER = " @Override\n"
            + "    public Long countByFilter(%s %s) {\n"
            + "        return %s.countByFilter(%s);\n"
            + "    }\n";

    private static String simpleName;
    private static String param;
    private static String mapperType;
    private static String mapper;
    private static String description;

    public static String generateServiceImpl(Class clazz, String name) {
        init(clazz, name);
        StringBuilder sb = new StringBuilder();

        sb.append(genSufix());
        sb.append("\n");

        sb.append(genUpsert());
        sb.append("\n");

        sb.append(genGeyById());
        sb.append("\n");

        sb.append(genListByFilter());
        sb.append("\n");

        sb.append(genCountByFilter());
        sb.append("\n");

        return sb.toString();
    }

    private static void init(Class clazz, String name) {
        simpleName = clazz.getSimpleName();
        param = ConvertUtil.convertParam(simpleName);
        mapperType = simpleName + "Mapper";
        mapper = param + "Mapper";
        description = name;
    }

    /**
     * 生成注入
     */
    private static String genSufix() {
        return String.format(SERVICE_IMPL_SUFFIX, mapperType, mapper);
    }

    /**
     * 生成 upsert
     */
    private static String genUpsert() {
        return String.format(UPSERT, simpleName, param, description, param,
                param, param, description, description, param, mapper, param, description,
                description, param, mapper, param);
    }

    /**
     * 生成 getById
     */
    private static String genGeyById() {
        return String.format(GET_BY_ID, simpleName, description, mapper);
    }

    /**
     * 生成 listByFilter
     */
    private static String genListByFilter() {
        return String.format(LIST_BY_FILTER, simpleName, simpleName, param, description, param,
                param,
                mapper);
    }

    /**
     * 生成 countByFilter
     */
    private static String genCountByFilter() {
        return String.format(COUNT_BY_FILTER, simpleName, param, mapper, param);
    }

    // public static void main(String[] args) {
    //     System.out.println(ServiceImplGenerator.generateServiceImpl(Test.class, "测试"));
    // }
}
