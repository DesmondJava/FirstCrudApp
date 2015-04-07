package com.desmond.testing;


import com.desmond.crud.UserService;
import com.desmond.entity.User;

import org.junit.Test;



import java.util.Date;
import java.util.List;

/**
 * Created by Vadym on 10.11.2014.
 */
public class UserServiceTest {

    UserService service = new UserService();

    @Test
    public void testSaveRecord() throws Exception {
        User userTest = new User();
        userTest.setAdmin(true);
        userTest.setAge(22);
        userTest.setCreatedDate(new Date());
        userTest.setName("Vadym");

        User user = service.add(userTest);

        System.out.println(user);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        User userTest = new User();
        userTest.setAdmin(false);
        userTest.setAge(15);
        userTest.setCreatedDate(new Date());
        userTest.setName("Alex");

        User user = service.add(userTest);

        service.delete(user.getId());
    }

    @Test
    public void testUpdateRecord() throws Exception {
        User userTest = new User();
        userTest.setAdmin(false);
        userTest.setAge(17);
        userTest.setCreatedDate(new Date());
        userTest.setName("Arnold");

        User user = service.add(userTest);

        service.update(user);
    }

    @Test
    public void testGetAll() throws Exception {
        User userTest1 = new User();
        userTest1.setAdmin(false);
        userTest1.setAge(82);
        userTest1.setCreatedDate(new Date());
        userTest1.setName("OldMan");

        User userTest2 = new User();
        userTest2.setAdmin(true);
        userTest2.setAge(2);
        userTest2.setCreatedDate(new Date());
        userTest2.setName("Child");

        User userTest3 = new User();
        userTest3.setAdmin(false);
        userTest3.setAge(22);
        userTest3.setCreatedDate(new Date());
        userTest3.setName("NiceMan");

        service.add(userTest1);
        service.add(userTest2);
        service.add(userTest3);

        List<User> users = service.getAll();

        for(User user : users)
        {
            System.out.println(user);
        }
    }

}
