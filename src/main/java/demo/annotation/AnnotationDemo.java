package demo.annotation;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class AnnotationDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ImoocCourse imoocCourse = new ImoocCourse();
        imoocCourse.getCourseInfo();
        System.out.println("finish");
        AnnotationParser.parseClassAnnotation();
    }
}
