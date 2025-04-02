import java.io.*;
import java.util.*;

public class BOJ_1406 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 왼쪽 오른쪽 스택 만들기
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 입력 값
        char[] inputs = br.readLine().toCharArray();
        for (char input: inputs) {
            leftStack.push(input);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] commands = br.readLine().split(" ");

            if (commands[0].equals("L")) {
                if (!leftStack.isEmpty()) {
                    char popChar = leftStack.pop();
                    rightStack.push(popChar);
                }
            } else if (commands[0].equals("D")) {
                if(!rightStack.isEmpty()) {
                    char popChar = rightStack.pop();
                    leftStack.push(popChar);
                }
            } else if (commands[0].equals("B")) {
                if (!leftStack.isEmpty()) leftStack.pop();
            } else if (commands[0].equals("P")) {
                leftStack.push(commands[1].charAt(0));
            }
        }
        br.close();

//        System.out.println(leftStack);
//        System.out.println(rightStack);

        // 왼쪽 스택에 있는 거 다 빼서 오른쪽 스택으로 옮김
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        // 오른쪽 스택에서 다 빼면서 출력함
        while(!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}