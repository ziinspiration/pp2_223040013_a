package Sesi8.src.dao;

import Sesi8.src.model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class JenisMemberDao {

    private final SqlSessionFactory sqlSessionFactory;

    public JenisMemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // Insert
    public int insert(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.insert("mapper.JenisMemberMapper.insert", jenisMember);
        }
    }

    // Update
    public int update(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.update("mapper.JenisMemberMapper.update", jenisMember);
        }
    }

    // Delete
    public int delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.delete("mapper.JenisMemberMapper.delete", id);
        }
    }

    // Find all
    public List<JenisMember> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.JenisMemberMapper.findAll");
        }
    }
}
