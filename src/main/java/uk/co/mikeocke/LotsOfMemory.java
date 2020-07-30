package uk.co.mikeocke;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class LotsOfMemory {

    static List<String> magicWords = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Ready? Hit any key");
        System.in.read();

        IntStream.range(Integer.MIN_VALUE, Integer.MAX_VALUE)
                .mapToObj(i -> UUID.randomUUID().toString())
                .forEach(magicWords::add);

        System.out.println("Done");
        System.in.read();


    }

}
