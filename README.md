# Smart Home
by **Olesia Cheremnykh** and **Chiril Babaev**

# Funkční požadavky
F1. 
<br>
F2. 
<br>
F3. 
<br>
F4. 
<br>
F5. 
<br>
F6. 
<br>
F7. 
<br>
F8. 
<br>
F9. 
<br>
F10.
<br> 
F11. 
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
