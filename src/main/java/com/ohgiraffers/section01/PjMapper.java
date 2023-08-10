package com.ohgiraffers.section01;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;

import java.util.List;

public interface PjMapper {
    List<TeamMemberDTO> selectAllTeamMember();
    List<TaskDTO> selectAllTask();

}
