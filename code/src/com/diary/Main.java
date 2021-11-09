package com.diary;

import java.util.Scanner;

import com.utils.Utils;

public class Main {
    public static boolean isTrue = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (isTrue) {
            System.out.println("请选择你要进行的操作：");
            System.out.println("输入数字1进行增加操作    输入数字2进行删除操作    输入数字3进行修改操作    输入数字4进行查询操作    输入数字0退出");
            int inputFromKeyBoard = sc.nextInt();
            Utils.readKeyBoard(inputFromKeyBoard,isTrue);
        }
    }
}
