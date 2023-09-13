package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.druzhinin_ri.task4.model.User;
import ru.aston.druzhinin_ri.task4.repository.RepositoryData;
import ru.aston.druzhinin_ri.task4.repository.RepositoryImplUser;

import java.util.List;

public class MockUserTest {

    private static User user = new User("Roman Dru", "+7(999)000-00-00" , "roman@mail.ru", 1);

    @Test
    void usersDAOImlMockitoTest(){
        RepositoryImplUser userImpl = Mockito.mock(RepositoryImplUser.class);
        RepositoryData data = Mockito.mock(RepositoryData.class);
        Mockito.when(data.scriptRun()).thenReturn(true);
        Mockito.when(userImpl.findEntityById(1)).thenReturn(user);
        Mockito.when(userImpl.findAll()).thenReturn(List.of(new User(1,"Roman Dru", "+7(999)000-00-00" , "roman@mail.ru", 1)));
        Mockito.when(userImpl.update(new User(1,"Roman Druz", "+7(999)111-00-00" , "roman@mail.ru", 1))).thenReturn(new User());
        Mockito.when(userImpl.delete(1)).thenReturn(true);

        Assertions.assertAll(
                () -> Assertions.assertTrue(data.scriptRun()),
                () -> Assertions.assertInstanceOf(user.getClass(), userImpl.findEntityById(1)),
                () -> Assertions.assertNotNull(userImpl.findAll()),
                () -> Assertions.assertInstanceOf(User.class, userImpl.update(new User(1,"Roman Druz", "+7(999)111-00-00" , "roman@mail.ru", 1))),
                () -> Assertions.assertTrue(userImpl.delete(1))
        );
    }
}
