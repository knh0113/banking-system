package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.ArrayList;
import bitcamp.util.Prompt;

public class MemberHandler implements Handler {

  private ArrayList list = new ArrayList();
  private Prompt prompt;
  private String title;

  public MemberHandler(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  @Override
  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s> ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("1. 은행등록");
    System.out.println("2. 은행목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputMember() {
    Member m = new Member();
    m.setName(this.prompt.inputString("은행이름? "));
    m.setBanknum(this.prompt.inputString("계좌번호? "));
    m.setEmail(this.prompt.inputString("이메일? "));
    m.setPassword(this.prompt.inputString("암호? "));

    if (!this.list.add(m)) {
      System.out.println("입력 실패입니다!");
    }
  }

  private void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 은행이름, 계좌번호");
    System.out.println("---------------------------------------");

    Object[] arr = this.list.list();
    for (Object obj : arr) {
      Member m = (Member) obj;
      System.out.printf("%d, %s, %s\n", m.getNo(), m.getName(), m.getBanknum());
    }
  }

  private void viewMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = (Member) this.list.get(new Member(memberNo));
    if (m == null) {
      System.out.println("해당 번호의 은행이 없습니다!");
      return;
    }
    System.out.printf("은행이름: %s\n", m.getName());
    System.out.printf("계좌번호: %s\n", m.getBanknum());
    System.out.printf("이메일: %s\n", m.getEmail());
  }



  private void updateMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = (Member) this.list.get(new Member(memberNo));
    if (m == null) {
      System.out.println("해당 번호의 은행이 없습니다!");
      return;
    }
    m.setName(this.prompt.inputString("은행이름(%s)? ", m.getName()));
    m.setBanknum(this.prompt.inputString("계좌번호(%s)? ", m.getBanknum()));
    m.setEmail(this.prompt.inputString("이메일(%s)? ", m.getEmail()));
    m.setPassword(this.prompt.inputString("새암호? "));
  }



  private void deleteMember() {
    if (!this.list.delete(new Member(this.prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }
}


