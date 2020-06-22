package com.sj.f_1_designpatterns;

/**
 * Created by SJ on 2019/3/1.
 */
public class PatternSingleton {


}

//饿汉式
class SingletonOne {
    private static SingletonOne singletonOne = new SingletonOne();

    private SingletonOne() {

    }

    public static SingletonOne getInstance() {
        return singletonOne;
    }
}

//静态内部类
class SingletonTwo {
    private SingletonTwo() {
    }

    private static class SingletonHolder {
        private static SingletonTwo singletonTwo = new SingletonTwo();
    }

    public static SingletonTwo getInstance() {
        return SingletonHolder.singletonTwo;
    }
}

//枚举方式
enum SingletonThree {
    INSTANCE;
    public void doSomething() {
    }
}

//不推荐方式
// 懒汉式-1
class SingletonF_1 {
    private static SingletonF_1 singletonF_1;

    private SingletonF_1() {
    }

    public static SingletonF_1 getInstance() {
        singletonF_1 = new SingletonF_1();
        return singletonF_1;
    }
}

// 懒汉式-2
class SingletonF_2 {
    private static SingletonF_2 singletonF_2;

    private SingletonF_2() {
    }

    public static synchronized SingletonF_2 getInstance() {
        singletonF_2 = new SingletonF_2();
        return singletonF_2;
    }
}

// 懒汉式-3
class SingletonF_3 {

    private static SingletonF_3 singletonF_3;

    private SingletonF_3() {
    }

    public static SingletonF_3 getInstance() {
        if (singletonF_3 == null) {
            synchronized (SingletonF_3.class) {
                singletonF_3 = new SingletonF_3();
            }
        }
        return singletonF_3;
    }
}

// 懒汉式-4
class SingletonF_4 {
    private static SingletonF_4 singletonF_4;

    private SingletonF_4() {
    }

    public static SingletonF_4 getInstance() {
        if (singletonF_4 != null) {
            synchronized (SingletonF_4.class) {
                if (singletonF_4 == null) {
                    singletonF_4 = new SingletonF_4();
                }
            }
        }
        return singletonF_4;
    }
}

// 懒汉式-5
class SingletonF_5 {
    private volatile static SingletonF_5 singletonF_5;

    private SingletonF_5() {
    }

    public static SingletonF_5 getInstance() {
        if (singletonF_5 != null) {
            synchronized (SingletonF_5.class) {
                if (singletonF_5 == null) {
                    singletonF_5 = new SingletonF_5();
                }
            }
        }
        return singletonF_5;
    }
}

// 懒汉式-6
class SingletonF_6 {
    private static SingletonF_6 singletonF_6;
    private SingletonF_6() {
    }
    public static SingletonF_6 getInstance() {
        if (singletonF_6 != null) {
            synchronized (SingletonF_6.class) {
                SingletonF_6 temp = null;
                try {
                    temp = new SingletonF_6();
                } catch (Exception e) {
                }
                if (temp != null){
                    //为什么要做这个看似无用的操作，因为这一步是为了让虚拟机执行到这一步的时会才对singleton赋值，
                    // 虚拟机执行到这里的时候，必然已经完成类实例的初始化。
                    // 所以这种写法的DCL(Double Check LockDCL双重检查锁)是安全的。
                    // 由于try的存在，虚拟机无法优化temp是否为null
                    singletonF_6 = temp;
                }
            }
        }
        return singletonF_6;
    }
}