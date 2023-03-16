package org.tms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteData {

    public static void writeData(Path path, String doc, Path pathValid, Path pathFail) throws IOException {
        //Создадим счетчик действий.
        byte counterIn = 0, counterOut = 0, counterFail = 0;
        //ПЕРЕЗапишем Файл исходной строкой.
        try {
            Files.writeString(path, doc, StandardOpenOption.WRITE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//создадим массив строк разделяя "по новой строке"
        String[] list = Files.readString(path).split("\n");
//удалим все данные с файлов и записываем документы которые подходят или нет условиям
        try {
            Files.writeString(pathValid, "");
            Files.writeString(pathFail, "");
            for (int i = 0; i < list.length; i++) {
                counterIn++;
                if ((list[i].length() == 15) && ((list[i].startsWith("docnum")) || (list[i].startsWith("contract")))) {
                    Files.writeString(pathValid, list[i] + "\n", StandardOpenOption.APPEND);
                    counterOut++;
                } else {
                    Files.writeString(pathFail, list[i] + " не прошел проверку\n", StandardOpenOption.APPEND);
                    counterFail++;
                }
            }
            System.out.println("Полученно: " + counterIn + " документов;" +
                    "\nЗаписанно: " + counterOut + " документов" +
                    "\nОшибка записи: " + counterFail + " документов");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
