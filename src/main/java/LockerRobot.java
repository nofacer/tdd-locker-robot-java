import exceptions.ErrorMessageException;

public interface LockerRobot {
  public Ticket savePackage(Package aPackage) throws ErrorMessageException;
  public Package getPackage(Ticket ticket) throws ErrorMessageException;
}
