package com.ohgiraffers.section01;

import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class PjService {
    private PjMapper pjMapper;
    public List<TeamMemberDTO> selectAllTeamMember() {
        SqlSession sqlSession = getSqlSession();

        pjMapper = sqlSession.getMapper(PjMapper.class);
        List<TeamMemberDTO> teamList = pjMapper.selectAllTeamMember();

        sqlSession.close();

        return teamList;

    }

    public List<TaskDTO> selectAllTask() {
        SqlSession sqlSession = getSqlSession();

        pjMapper = sqlSession.getMapper(PjMapper.class);
        List<TaskDTO> taskList = pjMapper.selectAllTask();

        sqlSession.close();

        return taskList;

    }

    public boolean registTeam(TeamMemberDTO team) {
        SqlSession sqlSession = getSqlSession();
        pjMapper = sqlSession.getMapper(PjMapper.class);

        int result = pjMapper.insertTeam(team);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;

    }

    public boolean modifyTeam(TeamMemberDTO team) {

        SqlSession sqlSession = getSqlSession();
        pjMapper = sqlSession.getMapper(PjMapper.class);

        int result = pjMapper.modifyTeam(team);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteTeam(int id) {
        SqlSession sqlSession = getSqlSession();
        pjMapper = sqlSession.getMapper(PjMapper.class);

        int result = pjMapper.deleteTeam(id);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }
}
