package com.eraytasay.university.preprocessing;

public class ReplacePlaceholdersWithUniqueNumbersApp {
    public static void run(String[] args)
    {
        if (args.length != 3) {
            System.err.println("Wrong number of arguments usage: java -jar ReplacePlaceholdersWithUniqueNumbersApp-1.0.0.jar sourceFilePath destFilePath placeholder");
            System.exit(1);
        }

        var replacePlaceholders = new ReplacePlaceholdersWithUniqueNumbers(args[0], args[1], args[2]);

        replacePlaceholders.create();
    }
}
