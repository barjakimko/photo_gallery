# photo_gallery

Witam,

aby uruchomić aplikacje, należy wstrzyknać dane z pliku
"db_data.sql".

Aby dodać zdjęcie należy dodaniac pliki do folderu
resources/static/photos., następnie w aplikacji trzeba podać
pełną nazwę zdjęcia wraz z rozszerzeniem. W przypadku gdy 
podanego zdjęcia nie ma w folderze zdjęcie nie doda się do
bazy. Encja galeria ma swoje hasło wedle wymagań jednak,
nie wiedziałem w jaki sposób, dołączyć weryfikację hasłem
galerii (w ramach możliwego rozszerzenia aplikacji zostało
wprowadzone do encji).

Po uruchomieniu aplikacji, pierwszym endpointem jest 
"loginForm".

Autentykacja jest zrobiona niestety bez spring seciurity, 
ponieważ dopiero w najbliższych miesiącach będe wprowadzony
w ten framework. 

Niestety nie zdążyłem z testami, dołączam tylko testy
loginu dla serwisu, oraz przykładowy test dla repo. 

kontakt:
barjakimko@gmail.com