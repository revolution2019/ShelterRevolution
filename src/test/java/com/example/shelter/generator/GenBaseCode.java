package com.example.shelter.generator;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 生成基础代码
 *
 * @author pojun
 */
@SpringBootTest
public class GenBaseCode {

    private static final Class clazz = Object.class;

    private static final String name = "对象描述";

    @Test
    public void mapperTest() {
        System.out.println(MapperGenerator.generateMapper(clazz));
    }

    @Test
    public void mapperInterfaceTest() {
        System.out.println(MapperInterfaceGenerator.generateMapperInterface(clazz));
    }

    @Test
    public void serviceTest() {
        System.out.println(ServiceGenerator.generateService(clazz));
    }

    @Test
    public void serviceImplTest() {
        System.out.println(ServiceImplGenerator.generateServiceImpl(clazz, name));
    }
}

