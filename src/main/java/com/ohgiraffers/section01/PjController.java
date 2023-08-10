package com.ohgiraffers.section01;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class PjController {

    private final PjService pjService;
    private final PrintResult printResult;
    private DynamicSqlMapper mapper;

    public PjController() {
        pjService = new PjService();
        printResult = new PrintResult();

    }
    public void selectAllTeamMember() {
        List<TeamMemberDTO> teamList = pjService.selectAllTeamMember();

        if(teamList != null) {
            printResult.printTeamList(teamList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectAllTask() {
        List<TaskDTO> taskList = pjService.selectAllTask();
        if(taskList != null) {
            printResult.printTaskList(taskList);
        } else {
            printResult.printErrorMessage("selectTaskList");
        }
    }

    public void searchName(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<TeamMemberDTO> teamList = mapper.searchName(searchCriteria);

        if(teamList != null && teamList.size() > 0) {
            teamList.forEach(System.out::println);
        } else {
            printResult.printErrorMessage("searchName");
        }

        sqlSession.close();

    }
}
