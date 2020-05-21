//import lombok.Data;
//
//import java.util.List;
//
//@Data
//public class LockerRobot {
//  private List<Locker> lockers;
//
//  public LockerRobot(List<Locker> lockers) {
//    this.lockers = lockers;
//  }
//
//  public Ticket savePackageInOrder() throws ErrorMessageException {
//    for (Locker locker : lockers) {
//      Ticket maybeTicket = locker.savePackage();
//      if (maybeTicket != null) {
//        return maybeTicket;
//      }
//    }
//    return null;
//  }
//
//  public boolean getPackage(Ticket ticket) {
//    for (Locker locker : lockers) {
//      if (ticket.getLockerName().equals(locker.getName())) {
//        return locker.getPackage(ticket);
//      }
//    }
//    return false;
//  }
//}
