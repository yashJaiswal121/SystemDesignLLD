package Decorator;

import java.util.List;

//https://www.youtube.com/watch?v=j40kRwSm4VE&list=PLF206E906175C7E07&index=11
public class Client {
    /*
    * Problem and Usage: When you want to modify and extend features in your child object dynamically ie at runtime i.e
    *  You will use it , when you have inheritance, and at subclasses you need to add functionality at runtime
    *
    * Also , to add a new functionality, you add new code, instead of rewrite old code.
    *
    *Example: We have a Plain Pizza, and using it we make various Pizzas at runtime
    *
    * Decorator DP UMl:
    *
    *               ---------------------       is-a &   ----------------------------                   ------------------------------------
    *                   IPizza Interface        has-a      ToppingDecorator                                 TomatoSauceToppingDecorator
    * CLIENT ---->      +getToppings()      <----------     <Abstract Class>                    is-a        <Concrete Clas>
    *                   +getCost()                          -IPizza pizza;                   <----------
    *                                                       -ToppingDecorator(IPizza){                 -TomatoSauceToppingDecorator(IPizza){
    *                                                         ....Impl  }                                   super(ipizza);......Impl}
    *
    *                                                       +getToppings(); //Can also have             -getToppings(){.... Impl}
    *                                                       +getCost();    //impl to it                 -getCost(){.... Impl}
     *               ---------------------               -----------------------------                  -------------------------------------
    *                   ^
    *                   | implements
    *                   |
    *     ------------------------
    *       Pizza Concrete Class
    *        -getDescription(){
    *           ..Impl
    *          }
    *        -getCost(){
     *           ..Impl
     *          }
    *     -----------------------
    *
    * */

    public static void main(String[] args) {
        //See diffrence b/w toppings and cost in implementation of various decorators.
        // toppings is a list which is same all decorators pizza instance so treated diffrently as to cost variable

        IPizza pizza = new TomatoSaucePizzaDecorator(new MozerellaCheesePizzaDecorator(new Pizza()));
        pizza.breadSpec();
        List<String> toppings = pizza.getToppings();
        double cost = pizza.getCost();

        System.out.println("Toppings = " + toppings);
        System.out.println("Cost = "+cost);

    }
}
