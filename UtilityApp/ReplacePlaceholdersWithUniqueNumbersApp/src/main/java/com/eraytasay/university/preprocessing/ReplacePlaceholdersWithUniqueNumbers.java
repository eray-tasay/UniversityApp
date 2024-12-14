package com.eraytasay.university.preprocessing;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Random;

public class ReplacePlaceholdersWithUniqueNumbers {
    private final String m_sourceFilePath;
    private final String m_destFilePath;
    private final String m_placeHolder;
    private final Charset m_charset;

    public ReplacePlaceholdersWithUniqueNumbers(String sourceFilePath, String destFilePath, String placeHolder, Charset charset)
    {
        m_sourceFilePath = sourceFilePath;
        m_destFilePath = destFilePath;
        m_placeHolder = placeHolder;
        m_charset = charset;
    }

    public ReplacePlaceholdersWithUniqueNumbers(String sourceFilePath, String destFilePath, String placeHolder)
    {
        this(sourceFilePath, destFilePath, placeHolder, StandardCharsets.UTF_8);
    }

    public void create()
    {
        try {
            try (var fr = new FileReader(m_sourceFilePath, m_charset); var fw = new FileWriter(m_destFilePath, m_charset)) {
                int ch;
                var buffer = new char[m_placeHolder.length()];
                var uniqueNumbers = new HashSet<String>();
                var r = new Random();
                var placeHolderIdx = 0;

                while ((ch = fr.read()) != -1) {
                    if (m_placeHolder.charAt(placeHolderIdx) == ch) {
                        buffer[placeHolderIdx++] = (char)ch;

                        if (placeHolderIdx == m_placeHolder.length()) {
                            String num;
                            while (uniqueNumbers.add(num = generateRandomNumber(r, m_placeHolder.length())))
                                ;

                            fw.write(num);
                            placeHolderIdx = 0;
                        }
                    }
                    else {
                        if (placeHolderIdx != 0)
                            fw.write(buffer, 0, placeHolderIdx);

                        placeHolderIdx = 0;
                        fw.write(ch);
                    }
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String generateRandomNumber(Random r, int length)
    {
        var digits = "0123456789";
        var str = new char[length];

        str[0] = digits.charAt(r.nextInt(1, 10));

        for (var i = 1; i < str.length; i++)
            str[i] = digits.charAt(r.nextInt(10));

        return new String(str);
    }
}
