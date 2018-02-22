package glossary;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        final File outFile = new File("OrderedGlossary");
        final List<String> orderedList = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("Sözlük.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                InputStreamReader isr = new InputStreamReader(bis);
                LineNumberReader lnr = new LineNumberReader(isr);
                FileWriter fw = new FileWriter(outFile,false);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String orderedLine = "";
            while((orderedLine = lnr.readLine()) != null){
                orderedList.add(orderedLine);
            }

            List<String> orderedStringList = orderedList
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .map(String::trim)
                    .filter(str -> str.length() > 0)
                    .collect(Collectors.toList());

            for (String s : orderedStringList) {
                 bw.write(s+"\n");
            }
        }
    }
}
