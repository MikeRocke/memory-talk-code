package uk.co.mikeocke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TooMuchWork {

    public static void main(String[] args) throws IOException {
        System.out.println("Ready? Hit any key");
        System.in.read();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.submit(() -> {
                readMediumFile();
            });
        }

        executorService.shutdown();
    }

    private static void readMediumFile() {
        try {
            byte[] data = Files.readAllBytes(Paths.get("medium-file.txt"));
            for (int i = 0; i < 10; i++) {
                data[i] = 0x00;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
