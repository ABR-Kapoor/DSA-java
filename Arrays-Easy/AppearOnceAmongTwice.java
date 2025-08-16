public class AppearOnceAmongTwice {
    public static int appearOnce(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i])
                    count++;
            }
            if (count == 1)
                return arr[i];
        }
        return -1;
    }

    public static int BetterAppearOnce(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[i] == 1)
                return i;
        }
        return -1;
    }

    public static int OptiAppearOnce(int[] arr) {
        int n = arr.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 3, 1, 2, 4 };
        System.out.println(appearOnce(arr));
        System.out.println(BetterAppearOnce(arr));
        System.out.println(OptiAppearOnce(arr));
    }
}
