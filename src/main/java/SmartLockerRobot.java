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
    Locker locker = getAvailableLocker(this.getLockers());
    Ticket ticket = locker.savePackage(aPackage);
    bindTicketWithLabel(ticket, locker);
    return ticket;
  }

  private Locker getAvailableLocker(List<Locker> lockers) throws ErrorMessageException {
    int tempCapacity = 0;
    Locker tempLocker = null;
    int idx = 0;
    for (Locker locker : lockers) {
      if (locker.getCapacity() > tempCapacity) {
        tempCapacity = locker.getCapacity();
        tempLocker = locker;
        idx++;
      }
    }
    if (tempLocker == null) {
      throw new ErrorMessageException("All lockers are full");
    }
    return tempLocker;
  }

}
