package com.example.mybais;

import com.example.mybais.mybatis.*;
import com.example.mybais.util.IDUtil;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybaisApplicationTests {

    @Resource
    UserMapper userMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    BlogMapper blogMapper;


    @Test
   public void contextLoads() {
        List<User> users = userMapper.selectUser();
        List<User> user2 = userMapper.selectUser();
        System.out.println(users.size());
    }

    @Test
    public void contextLoads1() {
    User user=userMapper.getUser(1);
        System.out.println(user.toString());
    }

    @Test
    public void contextLoads2() {
        User user=userMapper.selectUserByNP("张三","abcdef");
        System.out.println(user.toString());
    }

    @Test
    public void contextLoads3() {
        Map map=new HashMap();
        map.put("a","张三");
        map.put("b","abcdef");
        User user=userMapper.selectUserByNP2(map);
        System.out.println(user.toString());
    }

    @Test
    public void contextLoads4() {
        for (int i = 100; i < 200; i++) {
            User user1 = new User(i, "tom"+i, "xxxx");
            userMapper.addUser(user1);
        }

    }

    @Test
    public void contextLoads5() {
        User user1 = new User(5, "tom", "xxxxx");
        int i = userMapper.updateUser(user1);
        System.out.println(i);
    }

    @Test
    public void contextLoads6() {

        int i = userMapper.deleteUser(5);
        System.out.println(i);
    }

    @Test
    public void contextLoads7() {
        List<User> users = userMapper.type1("%123%");
        System.out.println(users.size());
    }

    @Test
    public void contextLoads8() {
        List<User> users = userMapper.type2("123");
        System.out.println(users.size());
    }

    @Test
    public void contextLoad9() {
        List<User2> users = userMapper.selectUser2();
        for (User2 u :users
                ) {
            System.out.println(u.toString());
        }
    }



    @Test
    public void contextLoad10() {
        int currentPage = 8;  //第几页
        int pageSize = 5;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<User> users = userMapper.selectUserLimit(map);

        for (User user: users){
            System.out.println(user);
        }
    }


    @Test
    public void contextLoad11() {
        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);
     List<User> users = userMapper.selectUserRowB("com.example.mybais.mybatis.UserMapper.selectUserRowB", null, rowBounds);

        for (User user: users){
            System.out.println(user);
        }
    }



    @Test
    public void contextLoad12() {
        List<Map> maps = studentMapper.selectAll1();
        System.out.println(maps.size());
    }

    @Test
    public void contextLoad13() {
        List<Student> students = studentMapper.getStudents();
        for (Student s:students
             ) {
            System.out.println(s);
        }
    }

    @Test
    public void contextLoad14() {
        List<Student> students = studentMapper.getStudents2();
        for (Student s:students
        ) {
            System.out.println(s);
        }
    }

    @Test
    public void contextLoad15() {
        List<Student> students = studentMapper.getStudents3();
        for (Student s:students
        ) {
            System.out.println(s);
        }
    }


    @Test
    public void contextLoad16() {
        Teacher2 teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher.toString());
    }

    @Test
    public void contextLoad17() {
        Teacher2 teacher = teacherMapper.getTeacher2(1);
        System.out.println(teacher.toString());
    }



    @Test
    public void contextLoad18() {

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blogMapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);
    }

    @Test
    public void contextLoad19() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = blogMapper.queryBlogIf(map);
        System.out.println(blogs.toString());
    }



}
