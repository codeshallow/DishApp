package cn.tx.demo;

/**
 * @author qianyu
 * @title 菜品类
 * @Package cn.tx.demo
 * @date 2022/1/25 11:57
 */
public class Dish {

    //编号
    int id;
    //菜的名称
    String name;
    //价格
    double price;

    public Dish() {
    }

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
