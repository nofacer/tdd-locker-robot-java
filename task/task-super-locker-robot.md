# Super Locker-robot Tasks
## Save packages

* Given the vacancy-ratio of first locker is larger than second one, when user saves package, then the locker-robot should save pachage to first locker and gives user a ticket.
* Given the vacancy-ratio of first locker is less than second one, when user saves package, then the locker-robot should save pachage to second locker and gives user a ticket.
* Given the vacancy-ratio of first and second locker is same, when user saves package, then the locker-robot should save pachage and gives user a ticket.
* Given all the lockers are full, when users check in package, then the locker-robot should throw an error.

## Get packages

* Given a user has a valid ticket, when this user withdraws the package using ticket, then the locker-robot should send package back.
* Given a user has an invalid ticket, when this user withdraws the package using ticket, then the locker-robot should throw error message.
