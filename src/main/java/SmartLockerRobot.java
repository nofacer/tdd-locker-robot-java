import java.util.List;
import lombok.Data;

@Data
public class SmartLockerRobot extends PrimaryLockerRobot {


  public SmartLockerRobot(List<Locker> lockers) {
    super(lockers);
  }

  @Override
  public Ticket savePackage(Package aPackage) throws exceptions.ErrorMessageException {
    int tempCapacity = 0;
    Locker tempLocker = null;
    int tempLockerIdx = -1;
    int idx = 0;
    for (Locker locker : this.getLockers()) {
      if (locker.getCapacity() > tempCapacity) {
        tempCapacity = locker.getCapacity();
        tempLocker = locker;
        tempLockerIdx = idx;
        idx++;
      }
    }
    Ticket ticket = tempLocker.savePackage(aPackage);
    this.getTicketLockerMap().put(System.identityHashCode(ticket), tempLockerIdx);
    return ticket;
  }
}
