class Solution {
    public int mirrorReflection(int p, int q) {
        if (p % q == 0) return (p / q) % 2 == 0 ? 2 : 1;
        int gcd = findGcd(p, q);
        p /= gcd;
        q /= gcd;
        if (q % 2 == 0) return 0;
        return (p - 1) % 2 == 0 ? 1 : 2;
    }
    
    int findGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGcd(n2, n1 % n2);
    }
}