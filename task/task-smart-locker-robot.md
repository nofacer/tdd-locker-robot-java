## Smart Locker-robot Tasks
## Save packages

* Given the capacity of first locker is larger than second one, when user saves package, then the locker-robot should save pachage to first locker and gives user a ticket.
* Given the capacity of first locker is less than second one, when user saves package, then the locker-robot should save pachage to second locker and gives user a ticket.
* Given none of the lockers is available, when users check in bags, then the locker-robot should throw an error.

## Get packages

* Given a user has a valid ticket, when this user withdraws the package using ticket, then the locker-robot should send package back.
* Given a user has an invalid ticket, when this user withdraws the package using ticket, then the locker-robot should throw error message.
