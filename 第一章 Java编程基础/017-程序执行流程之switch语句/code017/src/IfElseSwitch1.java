import java.util.Scanner;

public class IfElseSwitch1 {

    public static void main(String[] args) {

        boolean end = false;
        String string = "对应汉字为：";

        while (!end) {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入正整数：");
            try {
                int n = in.nextInt();
                switch (n) {
                    case 1:
                        string = n + string + "壹";
                        end = true;
                        break;
                    case 2:
                        string = n + string + "貳";
                        end = true;
                        break;
                    case 3:
                        string = n + string + "叁";
                        end = true;
                        break;
                    case 4:
                        string = n + string + "肆";
                        end = true;
                        break;
                    case 5:
                        string = n + string + "伍";
                        end = true;
                        break;
                    case 6:
                        string = n + string + "陆";
                        end = true;
                        break;
                    case 7:
                        string = n + string + "柒";
                        end = true;
                        break;
                    case 8:
                        string = n + string + "仈";
                        end = true;
                        break;
                    case 9:
                        string = n + string + "玖";
                        end = true;
                        break;
                    case 10:
                        string = n + string + "拾";
                        end = true;
                        break;
                    default:
                        System.out.println("错误的输入，请输入[1-10]之间的整数！");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("请按照要求输入！！！");
            }
        }
        System.out.println(string);
    }
}
