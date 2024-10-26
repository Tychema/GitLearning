package base1;

public class LazySingleton {

    //volatile 保证可见性和有序性
    private static volatile LazySingleton instance;

    private int otherValue;

    private LazySingleton() {
        this.otherValue = otherValue;
        System.out.println("LazySingleton constructor");
    }

    private LazySingleton(int otherValue) {
        this.otherValue = otherValue;
        System.out.println("LazySingleton constructor");
    }

    public static LazySingleton getInstance() {
        if(instance==null){
            synchronized (LazySingleton.class){
                if(instance==null){
                    System.out.println("LazySingleton init");
                    //不加volatile可能会出现指令重排
                    //invokespecial的指令是new对象的时候会调用构造方法，给其他属性赋值
                    //putstatic 给static变量赋值
                    //本来先执行构造方法，再给static赋值，这两个指令可能会发生指令重排，导致instance不为null，但是构造方法还没有执行
                    //在多线程下，一个创建instance，执行了putstatic，但是还没有执行构造方法
                    //另一个线程判断instance不为null，直接返回了instance，但是这个instance还没有执行构造方法，这个属性就没赋值
                    //volatile可以禁止指令重排，先执行构造方法，再instance = new LazySingleton();
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance==instance2);
    }
}
