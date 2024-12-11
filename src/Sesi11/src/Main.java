package Sesi11.src;

import Sesi11.src.model.MyBatisUtil;
import Sesi11.src.model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import Sesi11.src.view.UserView;
import Sesi11.src.controller.UserController;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserView view = new UserView();
        new UserController(view, mapper);

        view.setVisible(true);
    }
}
