package demo.pattern.factory.entity;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class LenovoMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("我是联想鼠标");
    }
}
