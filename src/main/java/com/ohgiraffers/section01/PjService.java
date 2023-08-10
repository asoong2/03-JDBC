package com.ohgiraffers.section01;

import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;
import com.ohgiraffers.common.Template;
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
}
