package com.example.taskmaster.service;

import com.example.taskmaster.entity.Team;
import com.example.taskmaster.entity.User;
import com.example.taskmaster.exception.ResourceNotFoundException;
import com.example.taskmaster.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team", "id", teamId));
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long teamId, Team teamDetails) {
        Team team = getTeamById(teamId);
        team.setName(teamDetails.getName());
        team.setDescription(teamDetails.getDescription());
        return teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        Team team = getTeamById(teamId);
        teamRepository.delete(team);
    }

    public Team addMemberToTeam(Long teamId, Long userId) {
        Team team = getTeamById(teamId);
        User user = userService.getUserById(userId);
        team.getMembers().add(user);
        user.getTeams().add(team);
        return teamRepository.save(team);
    }

    public Team removeMemberFromTeam(Long teamId, Long userId) {
        Team team = getTeamById(teamId);
        User user = userService.getUserById(userId);
        team.getMembers().remove(user);
        user.getTeams().remove(team);
        return teamRepository.save(team);
    }

    public List<Team> getTeamsByUser(Long userId) {
        return teamRepository.findByMembersId(userId);
    }
}