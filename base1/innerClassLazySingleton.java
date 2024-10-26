package base1;

public class innerClassLazySingleton {
    private innerClassLazySingleton() {
        System.out.println("innerClassLazySingleton constructor");
    }

    private static class LazyHolder {
        private static final innerClassLazySingleton INSTANCE = new innerClassLazySingleton();
    }

    public static innerClassLazySingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("other method");
    }
    public static void main(String[] args) {
        innerClassLazySingleton.otherMethod();
        innerClassLazySingleton instance = innerClassLazySingleton.getInstance();
        innerClassLazySingleton instance2 = innerClassLazySingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance==instance2);
    }
}
