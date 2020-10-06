package demo.pattern.factory.method;

import demo.pattern.factory.entity.Mouse;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class FactoryMethodDemo {
    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        Mouse mouse = mf.createMouse();
        mouse.sayHi();
    }
}
