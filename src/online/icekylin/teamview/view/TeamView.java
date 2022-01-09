package online.icekylin.teamview.view;

import online.icekylin.teamview.domain.Employee;
import online.icekylin.teamview.domain.Programmer;
import online.icekylin.teamview.service.NameListService;
import online.icekylin.teamview.service.TeamException;
import online.icekylin.teamview.service.TeamService;
import online.icekylin.teamview.util.TSUtility;

public class TeamView {
    public static void main(String[] args) {
        new TeamView().enterMainMenu();
    }

    private static final String EMPLOYEES_HEADER;
    private static final String TEAM_HEADER;

    static {
        EMPLOYEES_HEADER = String.format("%2s", "ID") +
                "\t\t" + String.format("%4s", "姓名") +
                "\t\t" + String.format("%2s", "年龄") +
                "\t\t" + String.format("%7s", "工资") +
                "\t\t" + String.format("%3s", "职位") +
                "\t\t" + String.format("%7s", "状态") +
                "\t\t" + String.format("%7s", "奖金") +
                "\t\t" + String.format("%4s", "股票") +
                "\t\t" + "领用设备";

        TEAM_HEADER = String.format("%5s", "TID/ID") +
                "\t\t" + String.format("%4s", "姓名") +
                "\t\t" + String.format("%2s", "年龄") +
                "\t\t" + String.format("%7s", "工资") +
                "\t\t" + String.format("%3s", "职位") +
                "\t\t" + String.format("%7s", "奖金") +
                "\t\t" + String.format("%4s", "股票");
    }

    private final NameListService listSvc = new NameListService();
    private final TeamService teamSvc = new TeamService();
    private boolean isExit;

    public void enterMainMenu() {
        boolean ifDisplayEmployees = true;

        System.out.println("---------- 开发团队调度软件 ----------");

        do {
            if (ifDisplayEmployees) {
                printEmployeesHeader();
                listAllEmployees();
                printSeparator();
            }

            ifDisplayEmployees = true;

            switch (TSUtility.readMenuSelection()) {
                case "1":
                    System.out.println("------------ 团队成员列表 ------------");
                    getTeam();
                    printSeparator();

                    ifDisplayEmployees = false;

                    break;
                case "2":
                    System.out.println("------------ 添加团队成员 ------------");
                    addMember();
                    printSeparator();

                    break;
                case "3":
                    System.out.println("------------ 删除团队成员 ------------");
                    deleteMember();
                    printSeparator();

                    break;
                case "4":
                    printSeparator();

                    if (!TSUtility.readConfirmSelection("确认是否退出 (y / N)：",
                            "选择错误，请重新输入 (y / N)：")) {
                        printSeparator();
                        continue;
                    }

                    System.out.println("Bye~~");
                    isExit = true;

                    break;
            }
        } while (!isExit);
    }

    private void listAllEmployees() {
        Employee[] employees = listSvc.getAllEmployees();

        if (employees.length > 0) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("没有员工信息...");
        }
    }

    private void getTeam() {
        Programmer[] team = teamSvc.getTeam();

        if (team.length > 0) {
            printTeamHeader();

            for (Programmer programmer : team) {
                printTeamMemberInfo(programmer);
            }
        } else {
            System.out.println("没有成员信息...");
        }
    }

    private void addMember() {
        if (listSvc.getAllEmployees().length > 0) {
            while (true) {
                try {
                    Employee addedEmployee = listSvc.getEmployee(TSUtility.readInt("请输入需要添加的成员 ID：",
                            "输入错误，请重新输入："
                    ));

                    if (TSUtility.readConfirmSelection("确认是否添加 (y / N)：",
                            "选择错误，请重新输入 (y / N)："
                    )) {
                        teamSvc.addMember(addedEmployee);
                        System.out.println("添加成功！");
                    }

                    break;
                } catch (TeamException e) {
                    System.out.println(e.getMessage());

                    if (!TSUtility.readConfirmSelection("是否重新输入 (y / N)：",
                            "选择错误，请重新输入 (y / N)："
                    )) {
                        break;
                    }
                } finally {
                    TSUtility.readReturn();
                }
            }
        } else {
            System.out.println("无任何员工信息，无法添加");
        }
    }

    private void deleteMember() {
        if (teamSvc.getTeam().length > 0) {
            while (true) {
                try {
                    int tid = TSUtility.readInt("请输入需要删除的成员 TID：",
                            "输入错误，请重新输入："
                    );

                    if (TSUtility.readConfirmSelection("确认是否删除 (y / N)：",
                            "选择错误，请重新输入 (y / N)："
                    )) {
                        teamSvc.removeMember(tid);
                        System.out.println("删除成功！");
                    }

                    break;
                } catch (TeamException e) {
                    System.out.println(e.getMessage());

                    if (!TSUtility.readConfirmSelection("是否重新输入 (y / N)：",
                            "选择错误，请重新输入 (y / N)："
                    )) {
                        break;
                    }
                } finally {
                    TSUtility.readReturn();
                }
            }
        } else {
            System.out.println("无团队成员信息，无法删除");
        }
    }

    private void printSeparator() {
        System.out.println("---------------- >8 ----------------");
    }

    private void printEmployeesHeader() {
        System.out.println(EMPLOYEES_HEADER);
    }

    private void printTeamHeader() {
        System.out.println(TEAM_HEADER);
    }

    private void printTeamMemberInfo(Programmer programmer) {
        System.out.println(programmer.toTeamInfoString());
    }
}
