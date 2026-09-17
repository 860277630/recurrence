package com.example.leetcodedemo.skill;

public class Test_02 extends ClassLoader {

    // TestHelloWorld类名
    public static String TEST_CLASS_NAME = "com.anbai.sec.classloader.TestHelloWorld";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        // 先判断是否已经加载过，避免重复defineClass
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        }

        // 只对 TestHelloWorld 破坏双亲委派，自己优先加载
        if (name.equals(TEST_CLASS_NAME)) {
            return defineClass(TEST_CLASS_NAME, null, 0, TEST_CLASS_NAME.length());
        }

        // 其他类仍然走父类加载器，避免JDK、Spring等类加载混乱
        return super.loadClass(name);
    }

}
