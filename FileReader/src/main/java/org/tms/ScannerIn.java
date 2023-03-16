package org.tms;

import java.util.Scanner;

public class ScannerIn {

    public static String scanIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к созданию файлов:");
        return scanner.nextLine();
    }
}

