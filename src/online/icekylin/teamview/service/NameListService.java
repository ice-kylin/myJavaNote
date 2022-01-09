package online.icekylin.teamview.service;

import online.icekylin.teamview.domain.*;

public class NameListService {
    private final Employee[] employees;

    public NameListService() {
        Equipment equipment = null;
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            if (Data.EQUIPMENTS[i].length > 0) {
                switch (Data.EQUIPMENTS[i][0]) {
                    case "" + Data.PC:
                        equipment = new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                        break;
                    case "" + Data.NOTEBOOK:
                        equipment = new NoteBook(Data.EQUIPMENTS[i][1], Double.parseDouble(Data.EQUIPMENTS[i][2]));
                        break;
                    case "" + Data.PRINTER:
                        equipment = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                        break;
                }
            }

            switch (Data.EMPLOYEES[i][0]) {
                case "" + Data.EMPLOYEE:
                    employees[i] = new Employee(
                            Integer.parseInt(Data.EMPLOYEES[i][1]),
                            Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]),
                            Double.parseDouble(Data.EMPLOYEES[i][4])
                    );
                    break;
                case "" + Data.PROGRAMMER:
                    employees[i] = new Programmer(
                            Integer.parseInt(Data.EMPLOYEES[i][1]),
                            Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]),
                            Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment
                    );
                    break;
                case "" + Data.DESIGNER:
                    employees[i] = new Designer(
                            Integer.parseInt(Data.EMPLOYEES[i][1]),
                            Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]),
                            Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment,
                            Double.parseDouble(Data.EMPLOYEES[i][5])
                    );
                    break;
                case "" + Data.ARCHITECT:
                    employees[i] = new Architect(
                            Integer.parseInt(Data.EMPLOYEES[i][1]),
                            Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]),
                            Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment,
                            Double.parseDouble(Data.EMPLOYEES[i][5]),
                            Integer.parseInt(Data.EMPLOYEES[i][6])
                    );
                    break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        throw new TeamException("找不到 ID 对应的员工");
    }
}
