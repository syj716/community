package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApp.class)
public class mapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        System.out.println(userMapper.selectById(101));
        System.out.println(userMapper.selectByName("SYSTEM"));
        System.out.println(userMapper.selectByEmail("nowcoder12@sina.com"));
    }
    @Test
    public void testInsert(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int cow=userMapper.insertUser(user);
        System.out.println(cow);
        System.out.println(user.getId());
    }
    @Test
    public void updateUser(){
        System.out.println(userMapper.updateHeader(101, "1"));
        System.out.println(userMapper.updateHeader(150, "http://www.nowcoder.com/102.png"));
        System.out.println(userMapper.updatePassword(150, "hello"));
    }
    @Test
    public void selectDiscussPostMapper(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(101, 3, 10);
        for(DiscussPost post : discussPosts) {
            System.out.println(post);
        }
        System.out.println(discussPostMapper.selectDiscussPostRows(0));
    }

}
