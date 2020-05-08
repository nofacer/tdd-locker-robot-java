import lombok.Data;

@Data
public class Ticket {

  private int label;
  private String timestamp;

  public Ticket(int label, String timestamp) {
    this.label = label;
    this.timestamp = timestamp;
  }

}
