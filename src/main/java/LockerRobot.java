import lombok.Data;

import java.util.List;

@Data
public class LockerRobot {
  private List<Locker> lockers;

  public LockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public Ticket savePackageInOrder() {
    for (Locker locker : lockers) {
      Ticket maybeTicket = locker.savePackage();
      if (maybeTicket != null) {
        return maybeTicket;
      }
    }
    return null;
  }

  public boolean getPackage(Ticket ticket) {
    //TODO: finish code
    return false;
  }
}
