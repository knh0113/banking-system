package bitcamp.myapp;

import bitcamp.myapp.handler.BoardHandler;
import bitcamp.myapp.handler.Handler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {
  public static void main(String[] args) {
    Prompt prompt = new Prompt();

    Handler memberHandler = new MemberHandler(prompt, "회원");
    Handler boardHandler = new BoardHandler(prompt, "입금 내역");
    Handler boardHandler2 = new BoardHandler(prompt, "출금 내역");

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else if (menuNo.equals("3")) {
        boardHandler2.execute();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 은행");
    System.out.println("2. 입금 내역");
    System.out.println("3. 출금 내역");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("나의 가계부");
    System.out.println("--------------------------------------");
  }
}
