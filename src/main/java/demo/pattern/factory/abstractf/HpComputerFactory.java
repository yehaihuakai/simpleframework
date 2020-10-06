package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.HpKeyBoard;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyBoard();
    }
}
