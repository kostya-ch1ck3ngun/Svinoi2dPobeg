package com.dupaRecords.svinoiPobeg;

public class Main {
    private static int height = 600;
    private static int width = 800;
    private static int fps = 144;

    static void main(String[] args) {
        parseArgs(args);
        new MainWindow(width, height, fps);
    }

    private static void parseArgs(String[] args) {
        boolean isHeight = false;
        boolean isWidth = false;
        boolean isFps = false;
        for (String arg : args) {
            switch (arg) {
                case "-h" -> {
                    isHeight = true;
                    isWidth = false;
                    isFps = false;
                    continue;
                }
                case "-w" -> {
                    isHeight = false;
                    isWidth = true;
                    isFps = false;
                    continue;
                }
                case "-f" -> {
                    isHeight = false;
                    isWidth = false;
                    isFps = true;
                    continue;
                }
            }
            if (isInt(arg)) {
                if (isHeight) {
                    isHeight = false;
                    height = Integer.parseInt(arg);
                } else if (isWidth) {
                    isWidth = false;
                    width = Integer.parseInt(arg);
                } else if (isFps) {
                    isFps = false;
                    fps = Integer.parseInt(arg);
                }
            }
        }
    }

    private static boolean isInt(String str) {
        return str != null && str.matches("\\d+");
    }
}


