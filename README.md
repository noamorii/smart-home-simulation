# Smart Home

The main goal of this project was to create a simple simulation of a house, in the implementation of which various design patterns were used.

## UseCase diagram
Detail use-case diagram [here](https://github.com/noamorii/smart-home-simulation/blob/main/docs/UseCases.PNG)

## Implementation

The entities there are a house, a floor in a house, rooms, various devices (devices and sports), a person, a car, a bicycle, a non-economic type pet, plus other entities.

Appliances have their consumption in active state, idle state, switched off state. Cllecting electricity consumption data about devices.

People and animals can perform activities (actions) that have some effect on the device or another person. Individual devices and people are present in the same room at any moment and randomly generate events. Events are accepted and handled by the appropriate person(s). When the device is broken, the resident of the house must examine the documentation for the device - go through the repair manual and take corrective action.

The family is active and spends free time roughly in proportion (50% using appliances in the house and 50% sports. Reports generated. Various house configurations available

## Design patterns

- 	State machine
    - package `stuff.state`
- 	Factory
    - `PeopleFactory`, `PetFactory`, `RoomFactory`, `DeviceFactory`, `SportFactory`
-   Observer
    - Observer class `PositronicBrain`, Observed class `UsableObject`
-   Singleton
    - `PositronicBrain`, `SportFactory`, `DeviceFactory`, `Home`, `HomeBuilder`
- 	Lazy Initialization
    - `Manual` in `UsableObject` 
-   Strategy
    -  `NightStrategy` and `DayStrategy`
-   Builder 
    - class `HomeBuilder` 

## Loading data and configuring the house
Loading data from a file in `json` format takes place in the `Configuration` class. 
The program starts in the `Main` class, where you can select a file to load the configuration. Javadoc and reports are written to the `resources` folder.

## Types of devices

- class AirConditioner
- class AudioSystem
- class Computer
- class Fridge
- class PetFeeder
- class PetToy
- class SmartPhone
- class SmartVacuum
- class TV

## Types of sport equipment

- class Bike
- class Orbitrek
- class Stepper
- class Treadmill
