public class ComplexNum{

    private int real;
    private int img;

    public ComplexNum(int real, int img){
        this.real = real;
        this.img = img;
    }

    ComplexNum(ComplexNum c1, ComplexNum c2) {
        this.real = c1.real + c2.real;
        this.img = c1.img + c2.img;
    }

    public void print(){
        System.out.println(real + " + " + img + "i");
    }

    public void setImg(int img){
        this.img = img;
    }
    public void setReal(int real){
        this.real = real;
    }

    public void add(ComplexNum c2) {
        this.real = this.real + c2.real;
        this.img = this.img + c2.img;
    }

    public void multiply(ComplexNum c2) {
        this.real = this.real * c2.real;
        this.img = this.img * c2.img;
    }

    public ComplexNum conjugate() {
        ComplexNum cx = new ComplexNum(real, img);
        cx.setImg(-img);
        return cx;
    }
}