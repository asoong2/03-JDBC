package com.ohgiraffers.section01;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

    public void registTeam(Map<String, String> parameter) {
        String name = parameter.get("name");
        String email = parameter.get("email");
        String phone = parameter.get("phone");
        int taskCode = Integer.parseInt(parameter.get("taskCode"));

        TeamMemberDTO team = new TeamMemberDTO();
        team.setName(name);
        team.setEmail(email);
        team.setPhone(phone);
        team.setTaskCode(taskCode);

        if (pjService.registTeam(team)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyTeam(Map<String, String> parameter) {
        int id = Integer.parseInt(parameter.get("id"));
        String name = parameter.get("name");
        String email = parameter.get("email");
        String phone = parameter.get("phone");
        int taskCode = Integer.parseInt(parameter.get("taskCode"));

        TeamMemberDTO team = new TeamMemberDTO();
        team.setId(id);
        team.setName(name);
        team.setEmail(email);
        team.setPhone(phone);
        team.setTaskCode(taskCode);

        if (pjService.modifyTeam(team)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteTeam(Map<String, String> parameter) {

        int id = Integer.parseInt(parameter.get("id"));

        if (pjService.deleteTeam(id)){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }
}

