# Smart Home
by **Olesia Cheremnykh** and **Chiril Babaev**

# UML
Naše diagramy [UML](https://drive.google.com/drive/folders/1ecBQ5YxsUWEcK3Zshvg_v-kB49vOgqzN?usp=sharing)

# Funkční požadavky

F1.  **Splněno**
<br>
F2.  **Splněno**
<br>
F3.  **Splněno**
<br>
F4.  **Splněno**
<br>
F5.  **Splněno**
<br>
F6.  **Splněno**
<br>
F7.  **Splněno**
<br>
F8.  **Splněno**
<br>
F9.  **Splněno**
<br>
F10. **Splněno**
<br> 
F11. **Splněno**

# Nefunkční požadavky
NF1.	Není požadována autentizace ani autorizace.✔️
<br>
NF2.	Aplikace může běžet pouze v jedné JVM.✔️
<br> 
NF3.	Dobře schované metody a proměnné, které nemají být dostupné ostatním třídám. Vygenerovný javadoc by měl mít co nejméně public metod a proměnných.✔️
<br> 
NF4. 	Reporty jsou generovány do textového souboru.✔️
<br> 
NF5. 	Konfigurace domu, zařízení a obyvatel domu nahrávána z externího json souboru.✔️
# Použité design patterny

- 	State machine
    - package `stuff.state`
- 	Factory
    - třídy `PeopleFactory`, `PetFactory`, `RoomFactory`, `DeviceFactory`, `SportFactory`
-   Observer
    - Observer třída `PositronicBrain`, Observed třída `UsableObject`
-   Singleton
    - třídy `PositronicBrain`, `SportFactory`, `DeviceFactory`, `Home`, `HomeBuilder`
- 	Lazy Initialization
    -  třída `UsableObject` metoda `getManual`
-   Builder 
    - třída `HomeBuilder` 

# Načítání dat a konfigurace domu

Načítání dat ze souboru ve formátu `json` probíhá ve třídě `Configuration`. Program se spouští v `Main` třídě, kde můžete vybrat soubor pro načtení konfigurace.

# Druhy zařízení

- class AirConditioner
- class AudioSystem
- class Computer
- class Fridge
- class PetFeeder
- class PetToy
- class SmartPhone
- class SmartVacuum
- class TV

# Druhy sportovního vybavení

- class Bike
- class Orbitrek
- class Stepper
- class Treadmill
