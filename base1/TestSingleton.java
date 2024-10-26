package base1;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();
        Singleton otherInstance = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance == otherInstance);


        //反射破坏单例
        //reflectionDestroy(Singleton.class);

        //反序列化破坏单例
        serializableDestroy(instance);

        unsafeDestroy(Singleton.class);

    }

    public static void unsafeDestroy(Class<?> singletonClass) {
        //spring下的一个工具，也不会走构造方法，暂无解决方法
        //Object o =UnsafeUtils.getUnsafe().allocateInstance(Singleton.class);
        //System.out.println("unsafe create instance:"+o);
    }

    public static void serializableDestroy(Object instance) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(instance);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        System.out.println(objectInputStream.readObject());
    }

    public static void reflectionDestroy(Class<?> singletonClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton = (Singleton) constructor.newInstance();
        System.out.println(singleton);

    }

    public static void EnumreflectionDestroy(Class<?> singletonClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = singletonClass.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        Singleton singleton = (Singleton) constructor.newInstance("INSTANCE",1);
        System.out.println(singleton);

    }

}
