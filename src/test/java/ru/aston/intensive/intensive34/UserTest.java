package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.druzhinin_ri.task4.model.User;
import ru.aston.druzhinin_ri.task4.repository.RepositoryData;
import ru.aston.druzhinin_ri.task4.repository.RepositoryImplUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {


    static RepositoryData repositoryData = new RepositoryData();
    static RepositoryImplUser userImpl;

        @BeforeAll
        static void init() {
            //repositoryData.scriptRun();
            userImpl = new RepositoryImplUser();
        }

        @Test
        void findAll() {
            List<User> list = userImpl.findAll();
            assertEquals(list.get(0).getFullName(), "Roman Dru");
        }

        @Test
        void findEntityById() {
            User user = new User(1, "Roman Dru", "+7(999)000-00-00", "roman@mail.ru", 1);
            assertEquals(userImpl.findEntityById(user.getId()).getFullName(), "Roman Dru");
        }

        @Test
        void delete() {
            User user = new User(2, "Alex Mag", "+7(999)111-00-22", "alex@mail.ru", 2);
            assertTrue(userImpl.delete(user.getId()));
         }
        @Test
        void create() {
            User user = new User(3, "Alex Mage", "+7(999)111-00-22", "alex@mail.ru", 2);
            assertTrue(userImpl.create(user));
        }

        @Test
        void update() {
            User user = new User(3, "Alex Mager", "+7(999)111-00-22", "alex@mail.ru", 2);
            assertEquals(userImpl.update(user).getFullName(), "Alex Mager");
        }

    @Test
    void findUsersOrders() {
        String result = "Клиент: Roman Dru" + "Заказ: 111";
        assertEquals(userImpl.findUsersOrders().get(0), result);
    }
    }