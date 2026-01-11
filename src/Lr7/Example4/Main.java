package Lr7.Example4;

public class Main {
    public static void main(String[] args) {
        FirstClass obj1 = new FirstClass('п');
        FirstClass obj11 = obj1.copyFirstClass('p');
        System.out.println(obj1);
        System.out.println(obj11 == obj1);

        SecondClass obj2 = new SecondClass('а', "fgf");
        SecondClass obj21 = obj2.copySecondClass('p', "dkdkdk");
        System.out.println(obj2);
        System.out.println(obj21 == obj2);

        ThirdClass obj3 = new ThirdClass('щ', "fgkf", 6);
        ThirdClass obj31 = obj3.copyThirdClass('щ', "fgkfj", 6);
        System.out.println(obj3);
        System.out.println(obj31 == obj3);
    }

}
