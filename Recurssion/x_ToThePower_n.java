
public class x_ToThePower_n{

    public static int x_power_n(int base, int exponenet){
        if(exponenet==1){
            return base;
        }        
        return base * x_power_n(base, exponenet-1);
        
    }


    public static void main(String[] args) {
        

        // System.out.println(Math.pow(x, n));
        System.out.println(x_power_n(3,3));
    }
}