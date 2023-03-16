package org.tms;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main12ALL {
    public static void main(String[] args) throws IOException {
        String doc = "docnumint000115\ndocnumint000215\ndocnumint000315\ndocnumint000415\ndocnumint000515\ndocnumint000615" +
                "\ndocnumint0007x\ncontractint08\nnepodhoditint09\nvocnumint10vx\ncontractint1115\ncontragentint12" +
                "\ndacnumint0013xx\ndocnumint001415\ncontractint1515";
        boolean b;
        do {
            b = true;
//создаем строку с адресом рабочей папки
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите путь к созданию файлов:");
            String pathFolder = scanner.nextLine();
//Создаем пути к файлам
            Path path = Paths.get(pathFolder + "\\file.txt");
            Path pathValid = Paths.get(pathFolder + "\\fileValid.txt");
            Path pathFail = Paths.get(pathFolder + "\\fileFail.txt");
//если не существует файлов создадим его.
            try {
                if (!Files.exists(path)) {
                    Path fileValid = Files.createFile(path);
                }
                if (!Files.exists(pathValid)) {
                    Path fileValid = Files.createFile(pathValid);
                }
                if (!Files.exists(pathFail)) {
                    Path fileFail = Files.createFile(pathFail);
                }
            } catch (NoSuchFileException nsfile) {
                nsfile.getStackTrace();
                b = false;
                System.out.println("Неверный путь к файлу попробуйте еще раз.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (b) {
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
            if (b == true){
                scanner.close();
            }
        } while (b == false);
    }
}
