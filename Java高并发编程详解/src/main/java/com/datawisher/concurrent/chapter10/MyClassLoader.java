package com.datawisher.concurrent.chapter10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    private final static Path DEFAULT_CLASS_DIR = Paths.get("D:", "classloader1");

    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 读取class的二进制数据
        byte[] classBytes = this.readClassBytes(name);
        // 如果数据为null，或者没有读到任何信息，则抛出ClassNotFoundException异常
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("Can not load the class" + name);
        }

        // 调用defineClass方法定义class
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    // 将class文件读入内存
    private byte[] readClassBytes(String name) throws ClassNotFoundException {

        // 将包名分隔符转换为文件路径分隔符
        String classPath = name.replace(".","/");

        // TODO
        return null;
    }



}
