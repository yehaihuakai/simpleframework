package demo.annotation;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
@CourseInfoAnnotation(courseName = "剑指java面试", courseTag = "面试", courseProfile = "这里是课程介绍")
public class ImoocCourse {

    @PersonInfoAnnotation(name = "张三", language = {"java", "pyhton"})
    private String author;

    @CourseInfoAnnotation(courseName = "论一个演员的自我修养", courseTag = "表演", courseIndex = 111, courseProfile = "这是一门表演课")
    public void getCourseInfo() {

    }
}
