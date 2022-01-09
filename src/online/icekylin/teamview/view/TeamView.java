package online.icekylin.teamview.view;

import online.icekylin.teamview.domain.Employee;
import online.icekylin.teamview.domain.Programmer;
import online.icekylin.teamview.service.NameListService;
import online.icekylin.teamview.service.TeamService;
import online.icekylin.teamview.util.TSUtility;

public class TeamView {
    public static void main(String[] args) {
        new TeamView().enterMainMenu();
    }

    private static final String EMPLOYEES_HEADER;

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
                    printSeparator();
                    getTeam();

                    ifDisplayEmployees = false;

                    break;
                case "2":
                    printSeparator();
                    addMember();
                    break;
                case "3":
                    printSeparator();
                    deleteMember();
                    break;
                case "4":
                    printSeparator();

                    if (!TSUtility.readConfirmSelection()) {
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
            System.out.println("没有成员信息...");
        }
    }

    private void getTeam() {
        Programmer[] team = teamSvc.getTeam();
    }

    private void addMember() {

    }

    private void deleteMember() {

    }

    private void printSeparator() {
        System.out.println("---------------- >8 ----------------");
    }

    private void printEmployeesHeader() {
        System.out.println(EMPLOYEES_HEADER);
    }
}
