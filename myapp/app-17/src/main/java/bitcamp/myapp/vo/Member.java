package bitcamp.myapp.vo;

public class Member {
  private static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  public int no;
  public String name;
  public String age;
  public String weight;
  public char gender;

  public Member() {
    this.no = userId++;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

}
