# Requirement

## Locker
* Locker has an init capacity that won't be changed after it has been produced.
* Assuming the capacity of the locker is `n`, the label of boxes will be from `1` to `n`.
* When user requests an empty box, it will provide a box with the minimal label from all empty boxes.
* After providing user a box, it will give user a **ticket** with the box label and record the timestamp. After this the box is unavailable to other users.
* When user returns the box, user should provide the ticket. The ticket label and timestamp should both match the system record. If so the box will open.
* If the locker is full, and a user requests a box, it will print an error message "Sorry, this locker is full.".

## Ticket
* On the ticket there is the label of related box.
* On the ticket there is the timestamp of getting this box.
