package base1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public enum SingletonEnum {
    //如何定义一个通用的枚举类，对于枚举编写
    //1、举值，构造，遍历

    //举值
    INSTANCE;

    private SingletonEnum(){
        System.out.println("private constructor");
    }

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + Integer.toHexString(hashCode());
    }

    //遍历
    public static SingletonEnum getInstance(){
        for (SingletonEnum value : SingletonEnum.values()) {
            return value;
        }
        return INSTANCE;
    }

    public static void otherMethod(){
        System.out.println("other method");
    }

    //构造

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        SingletonEnum.otherMethod();

        System.out.println(SingletonEnum.getInstance());
        System.out.println(SingletonEnum.getInstance());
        System.out.println(SingletonEnum.INSTANCE);


        //TestSingleton.EnumreflectionDestroy(SingletonEnum.class);
        TestSingleton.serializableDestroy(SingletonEnum.INSTANCE);
        //TestSingleton.unsafeDestroy(SingletonEnum.class);
    }

}
