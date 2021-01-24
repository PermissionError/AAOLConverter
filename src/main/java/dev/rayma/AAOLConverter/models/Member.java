package dev.rayma.AAOLConverter.models;

import dev.rayma.AAOLConverter.Role;

public class Member {
    private String discord;
    private String battleTag;
    private String srScreenshotLink;

    private int tankSr;
    private int damageSr;
    private int supportSr;

    private Role nominatedRole;

    public Member(String discord, String battleTag, String srScreenshotLink, Role nominatedRole) {
        //Init non-verified member
        this.discord = discord;
        this.battleTag = battleTag;
        this.srScreenshotLink = srScreenshotLink;
        this.nominatedRole = nominatedRole;
    }

    public int getTankSr() {
        return tankSr;
    }

    public void setTankSr(int tankSr) {
        this.tankSr = tankSr;
    }

    public int getDamageSr() {
        return damageSr;
    }

    public void setDamageSr(int damageSr) {
        this.damageSr = damageSr;
    }

    public int getSupportSr() {
        return supportSr;
    }

    public void setSupportSr(int supportSr) {
        this.supportSr = supportSr;
    }

    public String getDiscord() {
        return discord;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public String getSrScreenshotLink() {
        return srScreenshotLink;
    }

    public Role getNominatedRole() {
        return nominatedRole;
    }
}
