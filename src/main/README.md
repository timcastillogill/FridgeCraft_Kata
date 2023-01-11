You have been hired as a developer for FridgeCraft, a fridge manufacturer who pride themselves on their craftsmanship of delivering a quality fridge. FridgeCraft have decided to adopt the trend of making a “smart” fridge, and it’s your job to build the software to integrate into the new test model.

Instructions
The Research and Development team have given you the following requirements for the first iteration of the test model:

Track items placed into and out of the fridge
When an item is added, the fridge must capture information about that item
- Item name
- Expiration date
- Timestamp when added
  When the fridge is opened, the items already inside degrade their expiry
- 1 hour (sealed)
- 5 hours (opened)
  Provide a formatted display to view the contents and their remaining expiry
- Expired Items displayed first with "EXPIRED: $item.name"
- Non-expired items displayed after with "$item.name: n day(s) remaining
  An item is expired when the tracked expiry reaches midnight on the day after the expiration date.

You may also need to consider a way to simulate days passed, so the functionality can be easily demonstrated for the test model. However, make sure this does not affect the core functionality of the system and can be easily removed for release models.

The Research and Development team have also provided the following you do not have to worry about:

Where items are placed or how full the fridge is affecting the expiry.
How long the fridge is opened for affecting the expiry
Limit on how many items can be added
Even though this is just a prototype to show the stakeholders, you should still treat it with the care you would for a real system. Keep in mind the decisions you make and how they would affect the extensibilty of the system for the future.

Good luck, and keep your cool.

Example Events
One approach you could take to this kata is Event Sourcing.

The following is an example of typical events performed around your test model, you could even use this as an acceptance test.

> Set Current Date - "18/10/2021"

> Fridge Door Opened
> Item added - name: "Milk", expiry: "21/10/21", condition: "sealed"
> Item added - name: "Cheese", expiry: "18/11/21", condition: "sealed"
> Item added - name: "Beef", expiry: "20/10/21", condition: "sealed"
> Item added - name: "Lettuce", expiry: "22/10/21", condition: "sealed"
> Fridge Door Closed

> (Day Over)

> Fridge Door Opened
> Fridge Door Closed

> Fridge Door Opened
> Fridge Door Closed

> Fridge Door Opened
> Item removed - name: "Milk"
> Fridge Door Closed

> Fridge Door Opened
> Item added - name: "Milk", expiry: "26/10/21", condition: "opened"
> Item added - name: "Peppers", expiry: "23/10/21", condition: "opened"
> Fridge Door Closed

> (Day Over)

> Fridge Door Opened
> Item removed - name: "Beef"
> Item removed - name: "Lettuce"
> Fridge Door Closed

> Fridge Door Opened
> Item added - name: "Lettuce", expiry: "22/10/21", condition: "opened"
> Fridge Door Closed

> Fridge Door Opened
> Fridge Door Closed

> (Day Over)

These interactions should generate the following display on the fridge:

EXPIRED: Milk
Lettuce: 0 days remaining
Peppers: 1 day remaining
Cheese: 31 days remaining
