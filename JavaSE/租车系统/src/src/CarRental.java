package src;

import java.util.Scanner;
import java.util.regex.*;

public class CarRental {
    public static void main(String[] args){
        Car car[] = new Car[8];
        car[0] = new SedanCar();
        car[1] = new Minibus();
        car[2] = new Bus();
        car[3] = new LowsidedTruck();
        car[4] = new HighsidedTruck();
        car[5] = new Van();
        car[6] = new JapanPick();
        car[7] = new EnglishPick();

        //展示
        System.out.println("载客车：");
        System.out.println(" 序 号 | 车辆名称 | 租车费用(元/(车·天)) | 最大载人（人）");
        for(int i = 0;i<3;i++){
            System.out.println("   "+car[i].serialNumber+"   |  "+car[i].name+"  |          "+car[i].cost+"          |    "+car[i].maximumNumber);
        }
        System.out.println("载货车：");
        System.out.println(" 序 号 | 车辆名称 | 租车费用(元/(车·天)) | 最大载货（吨）");
        for(int i = 3;i<6;i++){
            System.out.println("   "+car[i].serialNumber+"   |  "+car[i].name+"  |          "+car[i].cost+"          |    "+car[i].maxLoad);
        }
        System.out.println("皮卡车：");
        System.out.println(" 序 号 |   车辆名称   | 租车费用(元/(车·天)) | 最大载人（人）| 最大载货（吨）");
        for(int i = 6;i<8;i++){
            System.out.println("   "+car[i].serialNumber+"   |  "+car[i].name+"  |          "+car[i].cost+"          |      "+car[i].maximumNumber+"        |    "+car[i].maxLoad);
        }

        for(int i = 0;i<8;){
            if(number(car,i))
                i++;
        }

        System.out.print("请问您将要租用几天？（不满一天按一天计算）");
        int day;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if (isPureDigital(str)) {
                day = Integer.valueOf(str);
                break;
            } else {
                System.out.println("你的输入有误，请重新输入");
            }
        }

        if(day>0) {
            System.out.println("您好，您的订单如下：");
            int allMaximumNumber = 0;
            for (int i = 0; i < 8; i++) {
                allMaximumNumber += car[i].maximumNumber * car[i].number;
            }
            if (allMaximumNumber > 0)
                System.out.println("总体租车的最大载人量为：" + allMaximumNumber + "人");

            double allMaxLoad = 0;
            for (int i = 0; i < 8; i++) {
                allMaxLoad += car[i].maxLoad * car[i].number;
            }
            if (allMaxLoad > 0)
                System.out.println("总体租车的最大载货量为：" + allMaxLoad + "吨");

            double allCost = 0;
            for (int i = 0; i < 8; i++) {
                allCost += car[i].cost * car[i].number * day;
            }
            if (allCost > 0)
                System.out.println("总体租车费用为：" + allCost + "元");

            System.out.println("租车天数为：" + day + "天");

            int allNumber = 0;
            for (int i = 0; i < 8; i++) {
                allNumber += car[i].number;
            }
            if (allMaximumNumber > 0)
                System.out.println("总体租用车辆总数为：" + allNumber + "辆");

            for (int i = 0; i < 8; i++) {
                if (car[i].number > 0) {
                    System.out.println(car[i].name + "的租用数目为：" + car[i].number);
                }
            }
        }
        else
            {
                System.out.println("打扰了");
            }
        System.out.println("请按回车结束程序");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            if (string.equals("")) {
                break;
            }
            else
            {
                System.out.println("请不要输入其他数据");
            }
        }
    }



//  下面这个函数是进行租用询问的
    public static boolean number(Car car[],int i ){
        System.out.print("请输入序号"+car[i].serialNumber+"（"+car[i].name+"）的租用数量：");
        Scanner scanner = new Scanner(System.in);//
        String str = scanner.next();
        if (isPureDigital(str)){
            int num = Integer.valueOf(str);
            car[i].number = num ;
            return true;
        }
        else {
            System.out.println("你的输入有误，请重新输入");
            return false;
        }
    }

//  下面这个函数是判断用户输入是否为正整数以及零的
    public static boolean isPureDigital(String str) {
        if (str == null || "".equals(str)){
            return false;
        }
        String regEx1 = "^[0-999]\\d*$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(str);
        if (m.matches()){
            return true;
        }else{
            return false;
        }
    }
}
