# MAMN01-HelloSensor

#### Resurser jag använt när appen utvecklats:

För att bygga grunden till appen:
- Android Developer: "Build your first app": https://developer.android.com/training/basics/firstapp/index.html
- Delar av "Build a simple user interface": https://developer.android.com/training/basics/firstapp/building-ui

Accelerometer:
- Android Developer: Sensor Event: https://developer.android.com/reference/android/hardware/SensorEvent.html
- Android Developer: Sensor Manager: https://developer.android.com/reference/android/hardware/SensorManager.html
- Youtube tutorial: https://www.youtube.com/watch?v=YrI2pCZC8cc

Compass:
- https://www.wlsdevelop.com/index.php/en/blog?option=com_content&view=article&id=38

För att hitta lösningar på problem och få förståelse för hur Android Studio fungerar har jag använt Stack Overflow.

#### Modifikationer

Utöver vad som gavs av handledningarna till de olika aktiviteterna har jag implementerat:

Accelerometer:
- En stor bild på en skattkarta har lagts till. Användaren ser bara en del av kartan åt gången.
- Då telefonen lutas och accelerometer-värderna uppnår ett visst krav rör sig kartan antingen uppåt, neråt, åt vänster eller åt höger. Detta gör att användaren ser en ny del av kartan. 
- Beroende på hur mycket användaren lutar telefonen så rör sig kartan inte alls eller i någon av två olika hastigheter.
- När kartan rör sig i den snabbaste hastigheten så ändrar textfärgen på accelerometer-värderna till röd.
- När accelerometer-aktiviteten startas syns en ruta med instruktioner till användaren som denne sedan kan stänga ner.
- En knapp, i form av en skattkista, är placerad på bilden av skattkartan och rör sig i kapp med kartan.
- När användaren trycker på skattkisteknappen så visas en text
- Accelerometer-aktiviteten har fått en bakgrundsbild och accelerometervärderna har fått en ram runt sig. 

Compass:
- Fyra knappar som låter användaren välja vilken riktning, Norr, Söder, Väst eller Öst, den vill att kompassen pekar mot
- Den knapp användaren tryckt på byter färg för att indikera vilken som valts
- När användaren valt en riktning och kompassen pekar i den riktningen så ger telefonen ifrån sig en vibration
- När användaren valt en riktning och kompassen pekar i den riktningen så skrivs texten "You'r heading in the right direction!" ut i en rosa färg. När kompassen inte pekar i den valda riktningen skrivs texten "Use the Compass to find the way!" ut i svart. 
- Kompasses visas med en annan bild än den som är given i handledningen
- kompass-aktiviteten har fått en bakgrundsbild och knapparna har fått var sin bakgrundsbild

Startsidan:
- Lagt till en bakgrundsbild
- Lagt till bakgrundsbilder på de två knapparna
