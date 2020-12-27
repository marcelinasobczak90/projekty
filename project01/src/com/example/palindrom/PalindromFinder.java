package com.example.palindrom;

import java.io.IOException;
import java.util.List;

public class PalindromFinder {
    public static String path  = "C:\\Users\\Dell\\Desktop\\tekst.txt";

    public static void main(String[] args) throws IOException {
        TextFixer textFixer = new TextFixer(path);
        System.out.println(textFixer.getPalindromList());
    }
}
