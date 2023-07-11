import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> map = new HashMap<>();
        long initX = Long.MAX_VALUE;
        long initY = Long.MAX_VALUE;

        int exitCnt = 0;
        while(true){
            if (initX != Long.MAX_VALUE && initY != Long.MAX_VALUE) break;
            if(exitCnt == 5){
                System.out.println("프로그램을 종료하시겠습니까? y/n");
                String temp = sc.nextLine();
                if(temp.equals("Y") || temp.equals("y") ||  temp.equals("")){
                    System.exit(0);
                } else {
                    exitCnt = 0;
                }
            }

            System.out.println("내 좌표 x값을 입력해 주세요.");
            String checkerX = sc.nextLine();
            if(!checkerX.equals("")) {
                initX = Long.parseLong(checkerX);
            }

            System.out.println("내 좌표 y값을 입력해 주세요.");
            String checkerY = sc.nextLine();
            if(!checkerY.equals("")) {
                initY = Long.parseLong(checkerY);
            }

            exitCnt++;
        }



        List<String> pointList = new ArrayList<>();

        int cnt = 1;
        while (true) {
            if (pointList.size() == 10) break;

            long tempX=Long.MIN_VALUE;
            long tempY=Long.MIN_VALUE;
            System.out.printf("%d/10 번째 입력\n", cnt);
            System.out.println("임의의 좌표 x값을 입력해 주세요.");
            String checkerX = sc.nextLine();
            if(!checkerX.equals("")) {
                tempX = Long.parseLong(checkerX);
            }

            System.out.println("임의의 좌표 y값을 입력해 주세요.");

            String checkerY = sc.nextLine();
            if(!checkerY.equals("")) {
                tempY = Long.parseLong(checkerY);
            }

            if(tempX != Long.MIN_VALUE && tempY != Long.MIN_VALUE){
                if (tempX != initX && tempY != initY) {
                    long[] tempArr = new long[2];
                    tempArr[0] = tempX;
                    tempArr[1] = tempY;
                    if (!pointList.contains(Arrays.toString(tempArr))) {
                        double distance = Math.pow((long) Math.pow(Math.abs(tempX - initX), 2) + (long) Math.pow(Math.abs(tempY - initY), 2), 0.5) * 100/ 100.0;
                        pointList.add(Arrays.toString(tempArr));
                        map.put(Arrays.toString(tempArr), distance);
                        cnt++;
                    }else {
                        System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
                    }
                }
            }
        }

        StringBuilder sbMin = new StringBuilder();
        StringBuilder sbAll = new StringBuilder();
        double minDistance = Double.MAX_VALUE;
        for (Object distance : pointList.toArray()) {
            minDistance = Math.min(minDistance, map.get(distance));
            sbAll.append(distance.toString().replace("[", "(").replace("]", ")").replace(".", ", ") + " => ");
            sbAll.append(String.format("%.6f \n", map.get(distance)));
            if (minDistance == map.get(distance)) {
                sbMin.setLength(0);
                sbMin.append(distance);
            }
        }


        System.out.print(new String(sbAll));
        System.out.println("제일 가까운 좌표:");
        System.out.println(new String(sbMin).replace("[", "(").replace("]", ")").replace(".", ", ") + " => " + String.format("%.6f", minDistance));
        sbMin.setLength(0);
        sbAll.setLength(0);
    }
}
