package org.simpleframework.core;

import com.dion.controller.DispatcherServlet;
import com.dion.controller.frontend.MainPageController;
import com.dion.service.combine.HeadLineShopCategoryService;
import com.dion.service.combine.impl.HeadLineShopCategoryServiceImpl;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/08
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载Beans：loadBeansTest")
    @Order(1)
    @Test
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.dion");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @DisplayName("根据类获取实例：getBeanTest")
    @Order(2)
    @Test
    public void getBeanTest() {
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, mainPageController instanceof MainPageController);

        DispatcherServlet dispatcherServlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        Assertions.assertEquals(null, dispatcherServlet);
    }

    @DisplayName("根据注解获取对应的实例: getBeanByAnnotationTest")
    @Order(3)
    @Test
    public void getBeanByAnnotationTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(3, beanContainer.getClassByAnnotation(Controller.class).size());
    }

    @DisplayName("根据接口获取实现类：getClassBySuperTest")
    @Order(4)
    @Test
    public void getClassBySuperTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(HeadLineShopCategoryService.class)
                .contains(HeadLineShopCategoryServiceImpl.class));
    }
}
