import exceptions.ErrorMessageException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class PrimaryLockerRobot {

  private List<Locker> lockers;
  private Map<Integer, Locker> ticketLockerMap = new HashMap<>();

  public PrimaryLockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public Ticket savePackage(Package aPackage) throws exceptions.ErrorMessageException {
    int i = 0;
    for (Locker locker : lockers) {
      if (locker.getCapacity() > 0) {
        Ticket ticket = locker.savePackage(aPackage);
        bindTicketWithLabel(ticket, locker);
        return ticket;
      }
      i++;
    }
    throw new ErrorMessageException("All lockers are full");
  }

  public Package getPackage(Ticket ticket) throws ErrorMessageException {
    Package aPackage = null;
    Locker locker = this.ticketLockerMap.get(System.identityHashCode(ticket));
    if (locker == null) {
      throw new ErrorMessageException("The ticket is invalid");
    } else {
      aPackage = locker.getPackage(ticket);
    }
    return aPackage;
  }

  public Locker getLockerByTicket(Ticket ticket) {
    return this.ticketLockerMap.get(System.identityHashCode(ticket));
  }

  public void bindTicketWithLabel(Ticket ticket, Locker locker) {
    this.getTicketLockerMap().put(System.identityHashCode(ticket), locker);
  }
}
