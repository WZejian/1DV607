# Stuff Lending System OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

![class diagram](img/package_diagram.jpg)



## Detailed Design
### Class Diagram

![Class diagram](img/assign2grade2.png)


### Sequence Diagram
This sequence diagram is corresponding to the scenario of adding a new member.
![Sequence diagram](img/assign2_sequence.png)

### Object Diagram
This object diagram is corresponding to the sequence diagram.
![Object diagram](img/assign2_object.png)