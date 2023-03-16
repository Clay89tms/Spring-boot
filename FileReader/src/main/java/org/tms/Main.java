package org.tms;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
//создадим строку с номерами документов.
        String doc = "docnumint000115\ndocnumint000215\ndocnumint000315\ndocnumint000415\ndocnumint000515\ndocnumint000615" +
                "\ndocnumint0007x\ncontractint08\nnepodhoditint09\nvocnumint10vx\ncontractint1115\ncontragentint12" +
                "\ndacnumint0013xx\ndocnumint001415\ncontractint1515";
        boolean b;
        do {
            b = true;
//создаем строку с адресом рабочей папки
            String pathFolder = ScannerIn.scanIn();
//Создаем пути к файлам
                Path path = Paths.get(pathFolder + "\\file.txt");
                Path pathValid = Paths.get(pathFolder + "\\fileValid.txt");
                Path pathFail = Paths.get(pathFolder + "\\fileFail.txt");
//если не существует файлов создадим его.
                try {
                    CreateFiles.createFiles(path, pathValid, pathFail);
                } catch (NoSuchFileException nsfile) {
                    nsfile.getStackTrace();
                    b = false;
                    System.out.println("Неверный путь к файлу попробуйте еще раз.");
                }
                if (b) {
                    WriteData.writeData(path, doc, pathValid, pathFail);
                }
        } while (b == false);
    }
}