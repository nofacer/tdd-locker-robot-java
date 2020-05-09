public class Validator {

  public static String generateTimeStamp() {
    return java.util.Calendar.getInstance().getTime().toString();
  }

  public static void main(String[] args) {
    System.out.println(generateTimeStamp());
  }
}
