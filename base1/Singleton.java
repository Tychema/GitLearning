package base1;

import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton(){
        if(instance!=null) throw new RuntimeException("单例对象不能反复创建");
        System.out.println("private constructor");
    }

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

    public static void otherMethod(){
        System.out.println("other method");
    }

    public Object readResolve(){
        return instance;
    }

}
