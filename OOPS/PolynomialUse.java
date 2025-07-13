public class PolynomialUse {
    public static void main(String[] args) {
        PolynomialClass p1 = new PolynomialClass(3,5);
        p1.setCoefficient(0,3);
        p1.setCoefficient(2,2);
        p1.print();

        // PolynomialClass p2 = new PolynomialClass(3,6);
        // p2.setCoefficient(0,3);
        // p2.setCoefficient(2,2);
        // p2.setCoefficient(1,4);
        // p2.setCoefficient(2,5);
        // p2.print();

        // PolynomialClass.add(p2, p2);
        // p1.print();
        // p2.print();

        // p2.multiply(p1);
        // p1.print();
        // p2.print();

        // PolynomialClass p3 = PolynomialClass.add(p1,p2);
        // p1.print();
        // p2.print();
        // p3.print();

        float ans = p1.evaluate(2);
        System.out.println("the value of the expression is: "+ ans);

    }
}
