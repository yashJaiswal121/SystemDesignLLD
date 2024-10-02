package AbstractFactoryDp;



class Animal{
    Animal(int x){System.out.println("animal is created");}
}

class Doog extends Animal{
    Doog(){  super(3);System.out.println("dog is created");   } // -> actually via compiler : -> Dog(){  super(); System.out.println("dog is created");   }
    Doog(int d)
    { super(3);System.out.println("PARAM dog is created"); }// -> actually via compiler : -> Dog(){  super(); System.out.println("PARAM dog is created");   } //Has no-arg constructor was not present in Animal.class, there would be error
}

class Honda3 {

    public static void main(String args[]){
        Doog obj=new Doog();

    }
}