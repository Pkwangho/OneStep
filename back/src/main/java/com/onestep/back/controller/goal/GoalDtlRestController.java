package com.onestep.back.controller.goal;

import com.onestep.back.dto.goal.GoalDTO;
import com.onestep.back.dto.upload.CertificationsDTO;
import com.onestep.back.dto.goal.GoalDtlDTO;
import com.onestep.back.service.goal.GoalDtlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/goals/dtl")
@RequiredArgsConstructor
public class GoalDtlRestController {

    private final GoalDtlService goalDtlService;

    // 목표 정보 조회
    @PostMapping("/{goalId}")
    public GoalDtlDTO getGoalInfo(@PathVariable Long goalId) {
        return goalDtlService.getGoalInfo(goalId);
    }

    // 참가하기
    @PostMapping("/joinGoal")
    public Map<String, GoalDTO> joinGoal(@RequestBody GoalDTO goalDTO) {
        goalDtlService.joinGoal(goalDTO);
        return Map.of("goalDTO", goalDTO);
    }

    // 내보내기, 그만두기
    @PostMapping("/removeMember")
    public Map<String, GoalDTO> removeMember(@RequestBody GoalDTO goalDTO) {
        goalDtlService.removeMember(goalDTO);
        return Map.of("goalDTO", goalDTO);
    }

    // 수정하기
    @PutMapping("/updateGoal")
    public Map<String, GoalDTO> updateGoal(@RequestBody GoalDTO goalDTO) {
        goalDtlService.updateGoal(goalDTO);
        return Map.of("goalDTO", goalDTO);
    }

    // 삭제하기
    @DeleteMapping("/{goalId}")
    public Map<String, Long> deleteGoal(@PathVariable Long goalId) {
        goalDtlService.deleteGoal(goalId);
        return Map.of("goalId", goalId);
    }

    // 최근 인증기록 조회
    @PostMapping("/getRecentCert/{goalId}")
    public List<CertificationsDTO> getRecentCert(@PathVariable Long goalId) {
        return goalDtlService.getRecentCert(goalId);
    }
}
