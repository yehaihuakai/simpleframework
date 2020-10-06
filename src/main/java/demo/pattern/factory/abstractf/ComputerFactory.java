package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public interface ComputerFactory {
    Mouse createMouse();

    Keyboard createKeyboard();
}
