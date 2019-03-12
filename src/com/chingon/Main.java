package com.chingon;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
	    int x = 922342959;
        System.out.println(x/256/256/256);
	    writeInt(x);
    }

    private static void display(int x) {
        String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        String colouredBinary =  ANSI_BLUE + all.substring(0, 8) + ANSI_RESET +
                ANSI_PURPLE + all.substring(8, 16) + ANSI_RESET +
                ANSI_RED + all.substring(16, 24) + ANSI_RESET +
                ANSI_YELLOW + all.substring(24, 32) + ANSI_RESET;
        int y = x & 0xFF;
        String output = String.format("%3d & 0xFF is %8s \t %10d is ",  y, Integer.toBinaryString(y), x) + colouredBinary;
        System.out.println(output);
    }

    private static void writeInt(int v) {
        System.out.print("v >>> 24 is the same as v / 256^3: ");
        display(v >>> 24);
        System.out.print("v >>> 16 is the same as v / 256^2: ");
        display(v >>> 16);
        System.out.print("v >>>  8 is the same as v / 256^1: ");
        display(v >>> 8);
        System.out.print("v >>>  0 is the same as v / 256^0: ");
        display(v >>> 0);
    }

    private static void showBitwiseOperationsDemo() {
        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c = 0;

        c = a & b;        /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        c = a | b;        /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        c = a ^ b;        /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );

        c = ~a;           /*-61 = 1100 0011 */
        System.out.println("~a = " + c );

        c = a << 2;       /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;       /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;      /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );
    }

}
