package tools;

import java.util.Scanner;

public class Input {
    public String getInput() {
        System.out.print("请输入菜品名称和数量（格式：名称x数量，名称x数量，…）：");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
