package study.yan.thinking.in.spring.ioc.overview.dependecy.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import study.yan.thinking.in.spring.ioc.overview.annotation.Super;
import study.yan.thinking.in.spring.ioc.overview.domain.Hobby;
import study.yan.thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 依赖查找示例
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 1、配置 xml 文件
        // dependency-lookup-context.xml

        // 2、启动Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");

        // 3、通过名称查找
        // 3-1、实时查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println("通过名称实时查找: " + user);
        // 3-2、延时查找
        ObjectFactory<User> objectFactory = beanFactory.getBean("objectFactory", ObjectFactory.class);
        User userLazy = objectFactory.getObject();
        System.out.println("通过名称延时查找: " + userLazy);

        // 4、通过类型查找
        // 4-1、查找单个对象
        User userByType = beanFactory.getBean(User.class);
        System.out.println("通过类型查找单个实例: " + userByType);
        // 4-2、查找集合对象
        if (beanFactory instanceof ListableBeanFactory) {
            // map 的 key 是 beanName， value 是 bean 对象
            Map<String, Hobby> hobbyMap = ((ListableBeanFactory) beanFactory).getBeansOfType(Hobby.class);
            System.out.println("通过类型查找集合实例: " + hobbyMap);
        }

        // 5、通过注解查找
        if (beanFactory instanceof ListableBeanFactory) {
            // map 的 key 是 beanName， value 是 bean 对象
            Map<String, Object> superMan = ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);
            System.out.println("通过注解查找: " + superMan);
        }
    }
}
