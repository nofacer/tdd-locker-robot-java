import lombok.Data;

@Data
public class Ticket {

  private int label;

  public Ticket(int label) {
    this.label = label;
  }

}
