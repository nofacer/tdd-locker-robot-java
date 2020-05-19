## Locker-robot Tasks
## Save packages

* Given the first locker is not full, when user saves package, then the locker-robot should give user a ticket.
* Given the first locker is full and second locker is not full, when user saves package, then the locker-robot should give user a ticket.
* Given none of the lockers is available, when users check in bags, then the locker-robot should not give user a ticket and throw an error.

## Get packages

* Given a user has a valid ticket, when this user withdraws the package using ticket, then the locker-robot should send package back.
* Given a user has an invalid ticket, when this user withdraws the package using ticket, then the locker-robot should throw error message.
