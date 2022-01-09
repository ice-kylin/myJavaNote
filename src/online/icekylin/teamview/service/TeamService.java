package online.icekylin.teamview.service;

import online.icekylin.teamview.domain.Architect;
import online.icekylin.teamview.domain.Designer;
import online.icekylin.teamview.domain.Employee;
import online.icekylin.teamview.domain.Programmer;

public class TeamService {
    private static int counter = 1;
    private static final int MAX_MEMBER = 5;
    private final Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public Programmer[] getTeam() {
        Programmer[] currentTeam = new Programmer[total];
        System.arraycopy(team, 0, currentTeam, 0, total);
        return currentTeam;
    }

    public void addMember(Employee employee) throws TeamException {
        boolean isSame = false;
        int programmerNum = 0;
        int designerNum = 0;
        int architectNum = 0;
        Programmer newProgrammer;

        if (total == MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }

        if (employee instanceof Programmer) {
            newProgrammer = (Programmer) employee;
        } else {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        for (Programmer programmer : team) {
            if (programmer.getId() == employee.getId()) {
                isSame = true;
                break;
            }

            if (programmer instanceof Architect) {
                architectNum++;
            } else if (programmer instanceof Designer) {
                designerNum++;
            } else {
                programmerNum++;
            }
        }

        if (isSame) {
            throw new TeamException("该员工已在本开发团队中");
        } else if (newProgrammer.getStatus().getNAME().equals("BUSY")) {
            throw new TeamException("该员工已是某团队成员");
        } else if (newProgrammer.getStatus().getNAME().equals("VOCATION")) {
            throw new TeamException("该员工正在休假，无法添加");
        } else if (architectNum == 1) {
            if (newProgrammer instanceof Architect) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (designerNum == 2) {
            if (newProgrammer instanceof Designer) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (programmerNum == 3) {
            throw new TeamException("团队中至多只能有三名程序员");
        }

        newProgrammer.setMemberId(counter++);
        newProgrammer.setStatus(Status.BUSY);
        team[total++] = newProgrammer;
    }

    public void removeMember(int memberId) throws TeamException {
        boolean isExist = false;
        int deleteIndex = 0;

        for (int i = 0; i < team.length; i++) {
            if (team[i].getMemberId() == memberId) {
                isExist = true;
                deleteIndex = i;
                break;
            }
        }

        if (isExist) {
            team[deleteIndex].setStatus(Status.FREE);
            team[deleteIndex].setMemberId(0);

            for (int i = deleteIndex; i < total; i++) {
                if (i == total - 1) {
                    team[i] = null;
                } else {
                    team[i] = team[i + 1];
                }
            }
        } else {
            throw new TeamException("成员不存在");
        }

        total--;
    }
}
