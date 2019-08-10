package com.icenodb.tickts;

public class Main {
    public static void main(String[] args) {
        Thread out = new Thread(new LibraryOut());
        Thread in = new Thread(new LibraryIn());
        in.run();
        out.run();
    }
}
