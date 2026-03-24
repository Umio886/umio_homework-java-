import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        double balance = 1000.0;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM菜单 =====");
            System.out.println("1.查询余额");
            System.out.println("2.取款");
            System.out.println("3.存款");
            System.out.println("0.退出");
            System.out.println("请选择操作: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("您当前的余额为：%.1f 个单位%n", balance);
                    break;

                case 2:
                    System.out.printf("请输入取款金额： ");
                    double withdrawAmount = scanner.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.printf("错误：请输入正确金额数！");
                    } else if (withdrawAmount % 100 != 0) {
                        System.out.printf("错误，金额必须是100的倍数");
                    }else if (withdrawAmount > balance) {
                        System.out.printf("错误：资金不足。当前可用余额： %.1f%n",balance);
                    }else {
                        balance -= withdrawAmount;
                        System.out.printf("取款成功！已取出：%.1f个单位。新余额：%.1f%n",withdrawAmount,balance);
                    }
                    break;
                case 3:
                    System.out.print("请输入存款金额： ");
                    double deposirAmount = scanner.nextDouble();

                    if (deposirAmount <= 0) {
                        System.out.println("错误：请输入正数金额！");
                    }else {
                        balance += deposirAmount;
                        System.out.printf("存款成功！已存入：%.1f个单位。新余额： %.1f%n",deposirAmount,balance);
                    }
                    break;
                case 0:
                    System.out.println("感谢使用ATM再见。");
                    break;
                default:
                    System.out.println("无效选择！请选择 0 到 3 之间的数字。" );

            }


        }while (choice != 0);
        scanner.close();

    }
}