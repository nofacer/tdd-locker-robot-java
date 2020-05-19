## Locker-robot Tasks
## Save packages

* Given one of the lockers has available boxes, when users check in bags, then the locker-robot should give user a ticket in order:
  - The first locker empty.
  - The first locker full, second available.
* Given none of the lockers is available, when users check in bags, then the locker-robot should not give user a ticket.

## Get packages

* Given a user has a valid ticket, when this user withdraws the package using ticket, then the locker-robot should open related box.
  - Package in the first locker
  - Package in the second locker or even the last one.
* Given a user has an invalid ticket, when this user withdraws the package using ticket, then the locker-robot should report error message and no box will be open.


## Comments:

- No box due to AC. task should correspond to AC exactly.
- Package instead of box.
- Robot in given.
- Provide error message when lockers are all full.
- Do we care about storing package in order? PO does, real user does not. (Pass tests == meet PO's requirements).