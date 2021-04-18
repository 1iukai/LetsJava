import java.util.Scanner;

public class ScoreMaster1 {
    public static void main(String[] args) {

        int totalCount = 6;
        String[] names = new String[totalCount];
        names[0] = "语文";
        names[1] = "数学";
        names[2] = "英语";
        names[3] = "化学";
        names[4] = "物理";
        names[5] = "生物";

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一共有多少年的成绩：");
        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalCount];
        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalCount; j++) {
                scores[i][j] = 80 + 20 * Math.random();
                System.out.println("第" + (i + 1) + "年" + names[j] + "的成绩为：" + scores[i][j]);
            }
        }

        boolean cont = true;
        while (cont) {
            System.out.println("请选择要进行的操作：");
            System.out.println("1: 求某年最好成绩\n" +
                    "2: 求某年的平均成绩\n" +
                    "3: 求所有年份最好成绩\n" +
                    "4: 求某门课历年最好成绩");

            int optId = scanner.nextInt();
            int year = 0;
            switch (optId) {
                case 1:
                    System.out.println("请输入要求哪一年的最好成绩：");
                    year = scanner.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法的年份，请重新输入！");
                        break;
                    }
                    int bestScoreId = 0;
                    for (int i = 0; i < totalCount; i++) {
                        if (scores[year][bestScoreId] < scores[year][i]) {
                            bestScoreId = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年最好成绩为" + names[bestScoreId] + "：" + scores[year][bestScoreId]);
                    break;
                case 2:
                    System.out.println("请输入求哪一年的平均成绩：");
                    year = scanner.nextInt() - 1;
                    double totalScoreOfYear = 0;
                    for (int i = 0; i < totalCount; i++) {
                        totalScoreOfYear += scores[year][i];
                    }
                    System.out.println("第" + (year + 1) + "年平均成绩为：" + (totalScoreOfYear / totalCount));
                    break;
                case 3:
                    int bestScoreIdOfYears = 0;
                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalCount; j++) {
                            if (scores[year][bestScoreIdOfYears] < scores[i][j]) {
                                year = i;
                                bestScoreIdOfYears = j;
                            }
                        }
                    }
                    System.out.println("历年最好成绩为第" + (year + 1) + "年" + names[bestScoreIdOfYears] + "成绩：" + scores[year][bestScoreIdOfYears]);
                    break;
                case 4:
                    System.out.println("请输入科目编号：");
                    int subjectId = scanner.nextInt() - 1;
                    if (subjectId < 0 || subjectId >= totalCount) {
                        System.out.println("非法的科目编号");
                        cont = false;
                        break;
                    }
                    for (int i = 0; i < yearCount; i++) {
                        if (scores[year][subjectId] < scores[i][subjectId]) {
                            year = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年度" + names[subjectId] + "成绩最好，为：" + scores[year][subjectId]);
                    break;
                default:
                    cont = false;
                    break;

            }
        }

    }
}
