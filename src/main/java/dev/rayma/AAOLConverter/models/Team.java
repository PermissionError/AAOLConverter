package dev.rayma.AAOLConverter.models;

import dev.rayma.AAOLConverter.TeamStatus;

import java.util.List;

public class Team {
    private String name;
    private String captainDiscord;
    private String managerDiscord;

    private TeamStatus teamStatus;

    private List<Member> members;

    public Team(String name, String captainDiscord, String managerDiscord, TeamStatus teamStatus, List<Member> members) {
        this.name = name;
        this.captainDiscord = captainDiscord;
        this.managerDiscord = managerDiscord;
        this.teamStatus = teamStatus;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public String getCaptainDiscord() {
        return captainDiscord;
    }

    public String getManagerDiscord() {
        return managerDiscord;
    }

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public List<Member> getMembers() {
        return members;
    }
}
