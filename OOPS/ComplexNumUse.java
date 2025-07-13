public class ComplexNumUse {
    public static void main(String[] args) {
        ComplexNum c1 = new ComplexNum(2,3);
        // c1.print();

        c1.setReal(10);
        c1.setImg(30);
        // c1.print();

        ComplexNum c2 = new ComplexNum(1, 5);
        c1.add(c2);
        // c1.print();
        // c2.print();

        ComplexNum c3 = new ComplexNum(3,2);
        c3.multiply(c2);
        // c3.print();
        // c2.print();

        ComplexNum c4 = new ComplexNum(c1, c2);
        c1.print();
        c3.print();
        c4.print();

        ComplexNum c5 = c1.conjugate();
        c5.print();

    }
}
