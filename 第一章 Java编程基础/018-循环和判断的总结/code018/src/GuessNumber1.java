import com.sun.tools.corba.se.idl.UnionGen;

import java.util.Scanner;

public class GuessNumber1 {

    public static void main(String[] args) {

        //初始化猜字范围
        int randStart = 0;
        int randEnd = 0;

        //游戏设置
        int totalCount = 5;
        boolean stopGame = false;
        int round = 0;

        //汇总游戏信息
        int totalGuessCount = 0;
        int correctGuessCount = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("==================猜数字游戏==================");
        System.out.println("请分别输入两个正整数，作为一个数字范围边界值");
        while (true) {
            System.out.println("请输入猜测数字范围的左边界值：");
            randStart = in.nextInt();
            System.out.println("请输入猜测数字范围的右边界值：");
            randEnd = in.nextInt();
            if (randEnd - randStart > 1) {
                break;
            } else {
                System.out.println("请重新输入。。。。");
            }
        }
        while (!stopGame) {
            //生成随机目标数字
            int mod = randEnd - randStart;
            int bigRand = (int) (Math.random() * randStart * 100);
            int numToGuess = (bigRand % mod) + randStart;
            if (numToGuess <= randStart) {
                numToGuess = randStart + 1;
            } else if (numToGuess > randEnd) {
                numToGuess = randEnd - 1;
            }

            int guessCount = 0;
            int leftCount = totalCount;

            System.out.println("*******************************************************************************");
            System.out.println("第" + (round + 1) + "轮游戏即将开始。。。。。。");

            while (leftCount > 0) {
                System.out.println("*******************************************************************************");
                System.out.println("猜测的目标数字范围在(" + randStart + "," + randEnd + ")之间,如果输入-1，则代表退出游戏：");
                System.out.println("*******************************************************************************");
                int guessNum = in.nextInt();

                if (guessNum == -1) {
                    stopGame = true;
                    break;
                }

                if (guessNum <= randStart || guessNum >= randEnd) {
                    System.out.println("请输入在" + randStart + "到" + randEnd + "之间，的数字，不包括这两个数。");
                    continue;
                }

                guessCount++;
                leftCount--;

                if (guessNum > numToGuess) {
                    totalGuessCount++;
                    System.out.println("输入的数字比随机数字大👆🏻");
                    System.out.println("本轮还有" + (totalCount - guessCount) + "次机会，请继续输入猜测的数字。");
                } else if (guessNum < numToGuess) {
                    totalGuessCount++;
                    System.out.println("输入的数字比随机数字小👇🏻");
                    System.out.println("本轮还有" + (totalCount - guessCount) + "次机会，请继续输入猜测的数字。");
                } else {
                    round++;
                    correctGuessCount++;
                    totalGuessCount++;
                    System.out.println("🎉🎉🎉恭喜，猜中了随机数字🎉🎉🎉");
                    System.out.println("统计信息如下：第" + round + "轮猜数一共用了" + guessCount + "次,猜中概率为：" + (1.0 / guessCount) * 100 + "%");
                    break;
                }
                if (leftCount == 0) {
                    round++;
                    System.out.println("对不起，第" + round + "轮猜测次数已用尽，目标数字是"+numToGuess+"，很遗憾您未猜中。。。🥀🥀🥀😭😭😭");
                    break;
                }
            }
        }
        System.out.println("猜数字游戏汇总信息：" + "\n" + "共猜数--" + totalGuessCount + "次" + "\n" + "共猜中--" + correctGuessCount + "次" + "\n" +
                "命中率--" + ((correctGuessCount * 1.0) / totalGuessCount) * 100 + "%");
    }
}
