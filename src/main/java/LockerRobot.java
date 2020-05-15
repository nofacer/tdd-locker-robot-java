import lombok.Data;

import java.util.List;

@Data
public class LockerRobot {
  private List<Locker> lockers;

  public LockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public Ticket savePackageInOrder() {
    //TODO: finish code
    return null;
  }

  public boolean getPackage(Ticket ticket) {
    //TODO: finish code
    return false;
  }
}
