public class MultiTable1 {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j <= 9; j++) {
                if (j>i){
                    break;
                }
                line.append(i).append("*").append(j).append("=").append(i * j).append("\t");
            }
            System.out.println(line);
        }
    }
}
