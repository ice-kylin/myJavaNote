package processcontrol.exer.bookkeeping;

public class FamilyAccount {
    public static void main(String[] args) {
        boolean exitFlag = false;
        StringBuilder incomeAndExpenditureInfo = new StringBuilder();
        double assets = 10000;
        double income;
        String detail;

        do {
            Utility.printMainMenu();

            System.out.print("请选择 (1 - 4)：");
            switch (Utility.readMenuSelection()) {
                case "1":
                    System.out.println("-------- 💰 当前收支明细记录 💸 --------");
                    System.out.println("收支\t\t账户金额\t\t收支金额\t\t说明");
                    System.out.println(incomeAndExpenditureInfo);
                    break;
                case "2":
                    System.out.print("本次收入金额：");
                    income = Utility.readNum();
                    assets += income;
                    System.out.print("本次收入说明：");
                    detail = Utility.readString();
                    incomeAndExpenditureInfo.append("收入\t\t").append(assets).append("\t\t").append(income).append("\t\t").append(detail).append("\n");

                    System.out.println("💰 登记完成！");
                    break;
                case "3":
                    System.out.print("本次支出金额：");
                    income = Utility.readNum();
                    assets -= income;
                    System.out.print("本次支出说明：");
                    detail = Utility.readString();
                    incomeAndExpenditureInfo.append("支出\t\t").append(assets).append("\t\t").append(income).append("\t\t").append(detail).append("\n");

                    System.out.println("💸 登记完成！");
                    break;
                case "4":
                    System.out.print("确认是否退出 (Y/n)：");
                    if (Utility.readConfirmSelection()) {
                        exitFlag = true;
                        System.out.println("💸 Bye!");
                    }
            }
        } while (!exitFlag);
    }
}
