import lombok.Data;

@Data
public class Ticket {

  private int label;
  private String lockerName;

  public Ticket(String lockerName, int label) {
    this.lockerName = lockerName;
    this.label = label;
  }

}
