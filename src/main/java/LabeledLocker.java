import lombok.Data;

@Data
public class LabeledLocker {

  private int label;
  private Locker locker;

  public LabeledLocker(int label, Locker locker) {
    this.label = label;
    this.locker = locker;
  }
}
