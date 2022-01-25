package cn.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qianyu
 * @title 点菜的主程序
 * @Package cn.tx.demo
 * @date 2022/1/25 12:00
 */
public class DishApp {

    //提前准备一些菜品，展示给用户，同时用户可以点菜
    // 定义集合（表示小饭店拥有的菜品）
    static List<Dish> dishlist = new ArrayList<>();

    //用户已点的菜品集合
    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {
        //先初始化菜品
        initDish();
        //System.out.println(dishlist);

        //小饭店就会做5个菜

        //创建扫描器对象，获取到控制台输入的内容
        Scanner s = new Scanner(System.in);
        //System.out.println("请输入编号");
        ////获取内容 阻塞的效果
        //int num = s.nextInt();
        //System.out.println("输入的值：" + num);

        //写死循环
        while(true){
            // 给用户展示主菜单
            showMenu();

            //获取内容
            int num = s.nextInt();

            //判断用户输入的数字
            switch (num) {
                case 1 :
                    while(true){
                        //把饭店菜单展示给用户就ok
                        showDishMenu();
                        //获取用户输入的内容
                        int id = s.nextInt();
                        //判断
                        if (id == 0) {
                            break;
                        }
                        //System.out.println("输入菜品的序号：" + id);

                        //从饭店的集合中获取到菜品的对象 1 2 3 4 5
                        //集合的索引 0 1 2 3 4
                        Dish dish = dishlist.get(id - 1);
                        System.out.println("亲，您点了：" + dish + "菜");
                        //用户点一个，存一个
                        personDish.add(dish);

                        //break;
                    }

                case 2 :
                    //展示用户已点的菜品
                    showPersonDish();
                    break;
                case 3 :
                    //买单
                    buy();
                    return;
            }
        }
    }

    /**
     * 展示饭店菜单
     */
    private static void showDishMenu() {
        System.out.println("----请您点菜----");
        //遍历集合
        for (int i = 0; i < dishlist.size(); i++) {
            //从集合中使用 i 获取每一个菜品对象
            Dish dish = dishlist.get(i);
            System.out.println(dish.id + "\t"+ dish.name + "\t"+dish.price);
        }
        System.out.println("----输入序号点菜，按 0 返回上一级----");
    }

    /**
     * 客户已点
     */
    private static void showPersonDish() {
        System.out.println("----您已点的菜品----");
        //遍历已点的集合
        for (Dish dish : personDish) {
            System.out.println(dish.id + "\t"+ dish.name + "\t" + dish.price);
            
        }
    }

    /**
     * 买单走人
     */
    private static void buy() {
        System.out.println("----请稍等，正在结算----");
        //定义总金额
        double total = 0f;

        //遍历已点的菜品
        for (Dish dish : personDish) {
            //单价的累加
            total += dish.price;
        }

        System.out.println("亲，您本次共消费了：" + total + " 元");
    }

    /**
     * 展示主菜单
     */
    public static  void showMenu(){
        System.out.println("---主菜单---");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t\t 2");
        System.out.println("买单\t\t\t 3");

        System.out.println("---根据编号选择服务---");

    }

    /**
     * 初始化菜品
     */
    public static void initDish(){
        Dish dish = new Dish(1, "香辣肉丝", 29);
        dishlist.add(dish);
        Dish dish2 = new Dish(2,"炖王八",59);
        dishlist.add(dish2);
        //存放菜品
        dishlist.add(new Dish(3,"家常凉菜",21));
        dishlist.add(new Dish(4,"地三鲜",24));
        dishlist.add(new Dish(5, "油焖大虾",55));
    }
}
