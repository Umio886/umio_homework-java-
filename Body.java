import java.util.Scanner;
public class Body {
    public static void MassIndex(double height,double weight){
        double bmi= weight/(height * height);

        if (bmi < 18.5){
            System.out.print("体重过轻:低于18.5");
        }else if(bmi >=18.5 && bmi <= 24.9){
            System.out.print("正常:在18.5-255之间");
        }else if(bmi >=25.0 && bmi <= 29.9){
            System.out.print("超重：在25-30之间");
        }else if(bmi >=30.0){
            System.out.print("肥胖：大于30");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        System.out.print("请输入您的身高：");
        double height = scanner.nextDouble();

        System.out.print("请输入体重：");
        double weight = scanner.nextDouble();

        MassIndex(height,weight);
        scanner.close();
    }
}
