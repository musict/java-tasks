package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] key = new byte[] {1,2,3,4,5};

        switch (args[0]) {
            case "-e": {
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dst = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buf = new byte[src.available()];
                    src.read(buf);

                    //XOR Code
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    dst.write(buf);
                }
                src.close();
                dst.close();
                break;
            }
            case "-d": {
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dst = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buf = new byte[src.available()];
                    src.read(buf);

                    //XOR deCode
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    dst.write(buf);
                }
                src.close();
                dst.close();
                break;
            }
        }

    }

}