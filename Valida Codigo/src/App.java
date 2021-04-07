import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Stack;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        File arquivo = new File("prog.txt");
        Scanner scan = new Scanner(arquivo);
        FileWriter txtcodigo = new FileWriter("prog-check.txt");

        while (scan.hasNextLine()) {
            String linha = scan.nextLine().trim();

            if (ValidaCodigos(linha) == false) {
                txtcodigo.write(linha + " - " + "Inválido");
            }

            else if (ValidaCodigos(linha) == true) {
                txtcodigo.write(linha + " - " + "OK");
            }
        }
    }

    public static Boolean ValidaCodigos(String txt) {
        Stack<Character> pilha = new Stack<Character>();

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '<' || txt.charAt(i) == '{' || txt.charAt(i) == '[' || txt.charAt(i) == '(') {
                pilha.add(txt.charAt(i));

            } else if (txt.charAt(i) == '>') {
                if (pilha.peek() == '<') {
                    pilha.pop();
                } else {
                    return false;
                }

            } else if (txt.charAt(i) == '}') {
                if (pilha.peek() == '{') {
                    pilha.pop();
                } else {
                    return false;
                }

            } else if (txt.charAt(i) == ']') {
                if (pilha.peek() == '[') {
                    pilha.pop();
                } else {
                    return false;
                }

            } else if (txt.charAt(i) == ')') {
                if (pilha.peek() == '(') {
                    pilha.pop();
                } else {
                    return false;
                }
            }
        }

        if (pilha.empty()) {
            return true;
        } else
            return false;
    }
}
    