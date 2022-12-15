import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {

    public static final int MAX_MEMORY = 1048576;

    public static void main(String[] args) throws IOException {
        String input = getFileContent(args);
        int[] memory = initMemory();
        String[] actions = parseInput(input);

        Stack<Integer> stack = new Stack<>();

        int memoryPointer = 0;
        int i = 0;

        while (i < actions.length) {
            switch (actions[i]) {
                case "\uD83D\uDC49":
                    memoryPointer++;
                    break;
                case "\uD83D\uDC48":
                    memoryPointer--;
                    break;
                case "\uD83D\uDC46":
                    memory[memoryPointer]++;
                    if (memory[memoryPointer] > 255) {
                        memory[memoryPointer] = 0;
                    }
                    break;
                case "\uD83D\uDC47":
                    memory[memoryPointer]--;
                    if (memory[memoryPointer] < 0) {
                        memory[memoryPointer] = 255;
                    }
                    break;
                case "\uD83E\uDD1C":  //right
                    if (memory[memoryPointer] == 0) {
                        i = jumpAfterNextPunchLeft(actions, i + 1);
                    } else  {
                        stack.push(i);
                    }
                    break;
                case "\uD83E\uDD1B": //left
                    if (memory[memoryPointer] != 0) {
                        i = stack.pop();
                        stack.push(i);
                        //i = jumpAfterPreviousPunchRight(actions, i - 1);
                    } else {
                        stack.pop();
                    }
                    break;
                case "\uD83D\uDC4A":
                    System.out.print("" + (char) memory[memoryPointer]);
                    break;
            }
            i++;
        }

    }

    private static String getFileContent(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        StringBuilder input = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                input.append(sc.nextLine());
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            inputStream.close();
            if (sc != null) {
                sc.close();
            }
        }
        return input.toString();
    }

    // with this method is too slooooooooowwwly. dont use it
    private static int jumpAfterPreviousPunchRight(String[] actions, int index) {
        int nestedClosed = 0;
        for (int i = index; i >= 0; i--) {
            if (actions[i].equals("\uD83E\uDD1B")) {
                nestedClosed++;
            } else if (actions[i].equals("\uD83E\uDD1C") && nestedClosed > 0) {
                nestedClosed--;
            } else if (actions[i].equals("\uD83E\uDD1C") && nestedClosed == 0) {
                return i;
            }
        }
        return 0;
    }

    private static int jumpAfterNextPunchLeft(String[] actions, int index) {
        int opened = 0;
        for (int i = index; i < actions.length; i++) {
            if (actions[i].equals("\uD83E\uDD1C")) {
                opened++;
            } else if (actions[i].equals("\uD83E\uDD1B") && opened > 0) {
                opened--;
            } else if (actions[i].equals("\uD83E\uDD1B") && opened == 0) {
                return i;
            }
        }
        return 0;
    }

    private static  int[] initMemory() {
        int[] memory = new int[MAX_MEMORY];
        for (int i = 0; i < MAX_MEMORY; i++) {
            memory[i] = 0;
        }
        return  memory;
    }

    private static String[] parseInput(String input) {
        return Pattern.compile("\\P{M}\\p{M}*+").matcher(input)
                .results()
                .map(MatchResult::group).toArray(String[]::new);
    }

}
