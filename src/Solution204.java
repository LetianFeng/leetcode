public class Solution204 {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;

                if (i <  Math.sqrt(n)) {
                    for (int j = i; i * j < n; j++)
                        notPrime[i * j] = true;
                }
            }

        }

        return count;
    }
}