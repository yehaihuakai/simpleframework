package demo.pattern.factory.entity;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class HpKeyBoard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("我是惠普键盘");
    }
}
