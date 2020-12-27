package com.example.palindrom;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFixer {
    private String path;
    private String[] wordList;
    List<String> palindromList = new ArrayList<>();

    public String[] getWordList() {
        return wordList;
    }

    public List<String> getPalindromList() {
        return palindromList;
    }

    public String getTextFromSource() throws IOException {
        String fileContent = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            fileContent = new String(bytes, Charset.defaultCharset()); // zamienić potem na File...
        } catch (Exception e) {
            fileContent = "Błąd";
        }
        return fileContent;
    }

    public String[] convertTextToList(String s){
        return s.replaceAll(",","").split(" ",-1);
    }

    public List<String> findPalindrom(String[] table){
        List<String> list = new ArrayList<>();

        for (String s : table) {
            s = s.trim().toUpperCase();
            int length = s.length() - 1;
            boolean isPalindrom = false;
            if (length > 1) {
                isPalindrom = true;
                for (int i = 0; i <length; i++) {
                    if (s.charAt(i) != s.charAt(length - i)) {
                        isPalindrom = false;
                        break;
                    }
                }
            }
            if (isPalindrom && !list.contains(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public TextFixer(String path) throws IOException {
        this.path = path;
        this.wordList = convertTextToList(getTextFromSource());
        this.palindromList = findPalindrom(wordList);
    }
}
