package collectionmap.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class EmployeeTest {
    @Test
    public void test1() {
        TreeSet employees = new TreeSet();

        Employee employee1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee employee2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee employee3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee employee4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee employee5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        for (Object employee : employees) {
            System.out.println(employee);
        }

        System.out.println();

        TreeSet employees1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;

                    return employee1.getBirthday().compareTo(employee2.getBirthday());
                } else {
                    throw new IllegalArgumentException();
                }
            }
        });

        employees1.add(employee1);
        employees1.add(employee2);
        employees1.add(employee3);
        employees1.add(employee4);
        employees1.add(employee5);

        for (Object employee : employees1) {
            System.out.println(employee);
        }
    }

    private class Employee implements Comparable {
        private String name;
        private int age;
        private MyDate birthday;

        public Employee() {
        }

        public Employee(String name, int age, MyDate birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public MyDate getBirthday() {
            return birthday;
        }

        public void setBirthday(MyDate birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", myDate=" + birthday +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (age != employee.age) return false;
            if (!Objects.equals(name, employee.name)) return false;
            return Objects.equals(birthday, employee.birthday);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) {
                return 0;
            } else {
                if (o instanceof Employee) {
                    Employee employee = (Employee) o;

                    if (this.equals(employee)) {
                        return 0;
                    } else if (this.name.equals(employee.name)) {
                        if (this.age == employee.age) {
                            return this.birthday.compareTo(employee.birthday);
                        } else {
                            return this.age - employee.age;
                        }
                    } else {
                        return this.name.compareTo(employee.name);
                    }
                } else {
                    throw new IllegalArgumentException("传入的形参类型不一致：不是 Employee");
                }
            }
        }
    }

    private class MyDate implements Comparable {
        private int year;
        private int month;
        private int day;

        public MyDate() {
        }

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            if (month >= 1 && month <= 13) {
                this.month = month;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyDate myDate = (MyDate) o;

            if (year != myDate.year) return false;
            if (month != myDate.month) return false;
            return day == myDate.day;
        }

        @Override
        public int hashCode() {
            int result = year;
            result = 31 * result + month;
            result = 31 * result + day;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) {
                return 0;
            } else {
                if (o instanceof MyDate) {
                    MyDate myDate = (MyDate) o;

                    if (this.equals(myDate)) {
                        return 0;
                    } else if (this.year == myDate.year) {
                        if (this.month == myDate.month) {
                            return Integer.compare(this.day, myDate.day);
                        } else {
                            return Integer.compare(this.month, myDate.month);
                        }
                    } else {
                        return Integer.compare(this.year, myDate.year);
                    }
                } else {
                    throw new IllegalArgumentException("传入的形参类型不一致：不是 MyDate");
                }
            }
        }
    }
}
