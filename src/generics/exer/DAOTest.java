package generics.exer;

import org.junit.Test;

public class DAOTest {
    @Test
    public void test1() {
        DAO<User> userDAO = new DAO<>();

        userDAO.save("1", new User(1, 18, "acker"));
        userDAO.save("2", new User(2, 19, "isaac"));
        userDAO.save("3", new User(3, 20, "dupi"));

        for (User user : userDAO.list()) {
            System.out.println(user);
        }

        userDAO.update("1", new User(1, 19, "icekylin"));
        System.out.println(userDAO.list());

        userDAO.delete("3");
        System.out.println(userDAO.list());
    }
}
