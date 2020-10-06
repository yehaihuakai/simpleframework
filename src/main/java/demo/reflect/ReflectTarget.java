package demo.reflect;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class ReflectTarget {

    //---------- 构造函数 ----------
    // 默认的带参构造函数
    ReflectTarget(String str) {
        System.out.println("默认的构造函数，str=" + str);
    }

    // 无参构造函数
    public ReflectTarget() {
        System.out.println("调用了共有的无参构造函数。。。");
    }

    // 有一个参数的构造函数
    public ReflectTarget(char name) {
        System.out.println("调用了一个带有参数的构造方法，参数为：" + name);
    }

    // 有多个参数的构造函数
    public ReflectTarget(String name, int index) {
        System.out.println("调用了带有多个参数的构造方法，参数值为【目标名】：" + name + "");
    }

    // 受保护的构造函数
    protected ReflectTarget(boolean n) {
        System.out.println("受保护的构造方法，n=" + n);
    }

    // 私有的构造函数
    private ReflectTarget(int index) {
        System.out.println("私有的构造函数，序号：" + index);
    }

    //---------- 字段 ----------
    public String name;
    protected int index;
    char type;
    private String targetInfo;

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种方式获取Class对象
        ReflectTarget reflectTarget = new ReflectTarget();
        Class reflectTargetClass1 = reflectTarget.getClass();
        System.out.println("1st:" + reflectTargetClass1.getName());

        // 第二种方式获取Class对象
        Class reflectTargetClass2 = ReflectTarget.class;
        System.out.println("2st" + reflectTargetClass2.getName());

        // 判断第一种方式获取的对象和第二种获取到的是否是同一个
        System.out.println(reflectTargetClass1 == reflectTargetClass2);

        // 第三种方式来获取Class对象
        Class reflectTargetClass3 = Class.forName("demo.reflect.ReflectTarget");
        System.out.println("3rd:" + reflectTargetClass3.getName());

        // 比较第二种和第三种方式产生的是不是同一个对象
        System.out.println(reflectTargetClass2 == reflectTargetClass3);
    }
}
