// incomplete

public class PolynomialClass {
    
    // DynamicArray coeffcient;
    private int deg, coeffi;

    public PolynomialClass(int deg, int coeffi){
        // coeffcient = new DynamicArray();
        this.coeffi = coeffi;
        this.deg = deg;        
    }

    void setCoefficient(int deg, int coeffi) {
        if(this.deg == deg){
            this.coeffi = coeffi;
            return;
        }
        this.deg = deg;
        this.coeffi = coeffi;

    }

    void print() {
        for(int i = deg ; i <= 0 ;i--){
            System.out.print(coeffi+"x^"+deg + " + ");
        }
        
    }

    static PolynomialClass add(PolynomialClass py, PolynomialClass po) {
        int c = py.coeffi + po.coeffi;
        int d = py.deg + po.deg;
        PolynomialClass p = new PolynomialClass(d, c);
        return p;
        
    }

    float evaluate(int i) {
        float value = (float) (coeffi * (Math.pow(i, deg)));
        return value;
    }

    void multiply(PolynomialClass p1) {
        
    }
}
