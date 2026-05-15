## Mój wybór implementacji promocji
Użyłam wzorca strategy, gdzie każda promocja to osobna klasa implementująca
interfejs *Promotion* z metodą *apply*

Dzięki temu, nie trzeba zmieniać nic w Cart, gdy chcemy dodać nową
promocję, można promocje dowolnie usuwać/dodawać,
każda promocja = jedna rzecz/działanie.

## Mój wybór implementacji produktu
Moja klasa *Product* jest nie mutowalna, czyli wszędzie jest final i 
nie mam setterów. Zamiast modyfikować produkt, promocja zwraca nowy
produkt metodą *withDiscount*. Przez to promocje napewno nie zmodyfikują
oryginalny produkt

## Mój wybór implementacji sortowania
*Cart* ma pole *Comparator* żeby można było sobie podmienić sposób sortowanie 
przez setter. Daje to dowolność zmieniania sposobu podczas działania programu

## Mój wybór implementacji wyszukiwania
Wszystko z Logiką jest w klasie *Finder*, a Cart zarządza tymi wyszukiwaniami