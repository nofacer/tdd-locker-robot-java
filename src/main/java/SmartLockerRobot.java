import exceptions.ErrorMessageException;
import java.util.List;
import lombok.Data;

@Data
public class SmartLockerRobot extends PrimaryLockerRobot {


  public SmartLockerRobot(List<Locker> lockers) {
    super(lockers);
  }

  @Override
  public Ticket savePackage(Package aPackage) throws exceptions.ErrorMessageException {
    LabeledLocker labeledLocker = getAvailableLocker(this.getLockers());
    Ticket ticket = labeledLocker.getLocker().savePackage(aPackage);
    this.getTicketLockerMap().put(System.identityHashCode(ticket), labeledLocker.getLabel());
    return ticket;
  }

  private LabeledLocker getAvailableLocker(List<Locker> lockers) throws ErrorMessageException {
    int tempCapacity = 0;
    Locker tempLocker = null;
    int tempLockerIdx = -1;
    int idx = 0;
    for (Locker locker : lockers) {
      if (locker.getCapacity() > tempCapacity) {
        tempCapacity = locker.getCapacity();
        tempLocker = locker;
        tempLockerIdx = idx;
        idx++;
      }
    }
    if (tempLocker == null) {
      throw new ErrorMessageException("All lockers are full");
    }
    return new LabeledLocker(tempLockerIdx, tempLocker);
  }
}
