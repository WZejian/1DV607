# BlackJack OO-Design
This document describes the current design. Note that some dependencies have been left out for readability reasons. For example there are a lot of dependencies to the Card class.

## Class Diagram
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. 

![class diagram](img/class_diagram.jpg)

## Stand - Sequence Diagram
This is the detailed sequence diagram for the `Game.stand` method. This is what should be implemented.

![Stand Sequence diagram](img/stand_seq.jpg)



## Extended version of class Diagram
The rule of Soft 17, WinStrategies(dealer and player) and Observer pattern are added into the Class diagram. 

![Extended class diagram](img/extended_Class_diagram.jpg)
