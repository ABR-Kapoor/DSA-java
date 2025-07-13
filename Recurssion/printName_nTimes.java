public class printName_nTimes {

public static String recuName(String name, int n){
    if(n>=1){
        return name;
    }
    return recuName(name, n-1);
}

    public static void main(String[] args) {
        System.out.println(recuName("Raam",3)); 
    }
}