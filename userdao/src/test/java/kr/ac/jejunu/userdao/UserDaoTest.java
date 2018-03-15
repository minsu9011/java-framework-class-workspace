package kr.ac.jejunu.userdao;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {
    private UserDao userDao;
    private int id;
    private String name;
    private String password;
    private String addName;
    private String addPassword;

    @Before
    public void setup() {
        this.userDao = new UserDao();
        this.id = 1;
        this.name = "허윤호";
        this.password = "1234";
        this.addName = "헐크";
        this.addPassword = "1111";
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(addName);
        user.setPassword(addPassword);
        user = userDao.add(user);

        User resultUser = userDao.get(user.getId());
        assertThat(resultUser.getId(), is(user.getId()));
        assertThat(resultUser.getName(), is(user.getName()));
        assertThat(resultUser.getPassword(), is(user.getPassword()));
    }
}
