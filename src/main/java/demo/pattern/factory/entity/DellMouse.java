package demo.pattern.factory.entity;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class DellMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("我是戴尔鼠标");
    }
}
