package bitcamp.myapp;

import bitcamp.myapp.handler.BoardHandler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();

    MemberHandler memberHandler = new MemberHandler(prompt);
    BoardHandler boardHandler = new BoardHandler(prompt);

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("99")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        memberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        memberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        memberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        memberHandler.deleteMember();
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 환자등록");
    System.out.println("2. 환자목록");
    System.out.println("3. 환자조회");
    System.out.println("4. 환자변경");
    System.out.println("5. 환자삭제");
    System.out.println("6. 게시물등록");
    System.out.println("7. 게시물목록");
    System.out.println("8. 게시물조회");
    System.out.println("9. 게시물변경");
    System.out.println("10. 게시물삭제");
    System.out.println("99. 종료");
  }

  static void printTitle() {
    System.out.println("병원 접수 시스템");
    System.out.println("----------------------------------");
  }
}
