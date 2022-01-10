# Smart Home
by **Olesia Cheremnykh** and **Chiril Babaev**

# UseCase diagram
Detail use-case diagram [UML](https://drive.google.com/drive/folders/1ecBQ5YxsUWEcK3Zshvg_v-kB49vOgqzN?usp=sharing)

# Funkční požadavky

F1. ✔️ Entity se kterými pracujeme je dům, patro v domu, mistnosti, ruzná zařízení (devicy a sport), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus další entity.   **Splněno** 
<br>
F2. ✔️ Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení.  **Splněno**
<br>
F3. ✔️ Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu.  **Splněno**
<br>
F4. ✔️ Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data spotřeby elektřiny.  **Splněno**
<br>
F5. ✔️ Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu.  **Splněno**
<br>
F6. ✔️ Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti a náhodně generují eventy.  **Splněno**
<br>
F7. ✔️ Eventy jsou přebírány a odbavovány vhodnou osobou (osobami).  **Splněno**
<br>
F8. ✔️ Vygenerování reportů.  **Splněno**
<br>
F9. ✔️ Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí.  **Splněno**
<br>
F10.✔️ Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport.  **Splněno**
<br> 

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
    -  třída `Manual` ve třídě `UsableObject` 
-   Strategy
    -  `NightStrategy` a `DayStrategy`
-   Builder 
    - třída `HomeBuilder` 

# Načítání dat a konfigurace domu

Načítání dat ze souboru ve formátu `json` probíhá ve třídě `Configuration`. Program se spouští v `Main` třídě, kde můžete vybrat soubor pro načtení konfigurace. Javadoc a reporty se zapisují do složky `resources`.

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
