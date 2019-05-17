package javaapplication3;

import java.util.*;
import java.math.BigInteger;

public class DH {

    final static BigInteger one = new BigInteger("1");

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        BigInteger n;
// Get a start spot to pick a prime from the user.
        System.out.println("Entre com o primeiro numero primo:");
        String ans = stdin.next();
        n = getNextPrime(ans);
        System.out.println("Primeiro numero primo eh: " + n + ".");
// Get the base for exponentiation from the user.
        System.out.println("Entre com o segundo numero primo(entre 2 e " + n + "):");
        BigInteger g = new BigInteger(stdin.next());
// Get A’s secret number.
        System.out.println("Pessoa A: entre com o numero secreto qualquer)");
        BigInteger a = new BigInteger(stdin.next());
// Make A’s calculation.
        BigInteger resulta = g.modPow(a, n);
// This is the value that will get sent from A to B.
// This value does NOT compromise the value of a easily.
        System.out.println("Pessoa A envia " + resulta + " para pessoa B.");
// Get B’s secret number.
        System.out.println("Pessoa B: entre com o numero secreto qualquer");
        BigInteger b = new BigInteger(stdin.next());
// Make B’s calculation.
        BigInteger resultb = g.modPow(b, n);
// This is the value that will get sent from B to A.
// This value does NOT compromise the value of b easily.
        System.out.println("Pessoa B envia " + resultb + " para pessoa A.");
// Once A and B receive their values, they make their new calculations.
// This involved getting their new numbers and raising them to the
// same power as before, their secret number.
        BigInteger KeyACalculates = resultb.modPow(a, n);
        BigInteger KeyBCalculates = resulta.modPow(b, n);
// Print out the Key A calculates.
        System.out.println("A recebe " + resultb + " elevado a potencia " + a + " mod " + n);
        System.out.println("A chave A calculada eh " + KeyACalculates + ".");
// Print out the Key B calculates.
        System.out.println("B recebe " + resulta + " elevado a potencia " + b + " mod " + n);
        System.out.println("A chave B calculada eh " + KeyBCalculates + ".");
    }

    public static BigInteger getNextPrime(String ans) {
        BigInteger test = new BigInteger(ans);
        while (!test.isProbablePrime(99)) {
            test = test.add(one);
        }
        return test;
    }
}
