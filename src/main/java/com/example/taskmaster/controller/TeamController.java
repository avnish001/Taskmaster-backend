package com.example.taskmaster.controller;

import com.example.taskmaster.entity.Team;
import com.example.taskmaster.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        return teamService.updateTeam(id, teamDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/members/{userId}")
    public Team addMemberToTeam(@PathVariable Long id, @PathVariable Long userId) {
        return teamService.addMemberToTeam(id, userId);
    }

    @DeleteMapping("/{id}/members/{userId}")
    public Team removeMemberFromTeam(@PathVariable Long id, @PathVariable Long userId) {
        return teamService.removeMemberFromTeam(id, userId);
    }
}