Документация за конзолна игра <b> Green vs. Red </b> <br> <br>
Цел<br> <br>
Основната роля на играта е промяна на всяка клетка в предварително задедена решетка. Това се постига, следвайки прилежащи условия, свързани с цветовете на всяка клетка и нейните съседни.
Въз основа на изисквания брой завъртания, както и координати на конкертна клетка, финалният резултат е свързан с броя смени, 
през които дадената конкретна клетка е станала от червена в зелена.
Тази функционалност е осъществена чрез използване на езика Java, следните класове и интерфейси: <b> Grid, Cell, IGrid, ICell </b>.

<b> Клас Grid </b>.


Освен задължителните аксесори, класът съдържа и няколко метода, имплементирани от интефейса <b> IGrid </b>. <br> <br>
<i> public String[][] makeGridCopy </i> - създава и  връща копие на оригиналната решетка

<i> public int findGreenNeighbours(int greenCellsCounter, Cell cell) </i> - според подадени координати на дадена клетка, преброява колко зелени съседи има тя <br>

<i> public int traverseGrid(int x1, int y1, int turns, int greenCellsCounter) </i> - използва копието на оригиналната решетка, намира за всяка клетка от тип Cell колко са 
зелените съседи и в зависимост от броя, цвета и други условия я трансформира или в зелена, или в червена; ако клетката е станала зелена през тази генерация – броячът се увеличава; методът се извиква рекурсивно, докато броят на завъртания не стане 0

<i> public static void printGrid(String [][]grid) </i> - изпринтва решетката <br>

<b> Клас Cell </b>.


Освен задължителните аксесори, класът съдържа и няколко метода, имплементирани от интефейса <b> ICell </b>. <br> <br>
<i> static int checkCellIsGreen(String[][] grid, int x, int y) </i> – проверява дали клетка е зелена <br>

<i> String[][] transformToGreen(String [][]initialGrid, int greenCellsCounter) </i> – ако условията за превръщането на клетка от червена в зелена са изпълнени, 
клетката се трансформира в зелена <br>

<i> String[][] transformToRed(String [][]initialGrid, int greenCellsCounter) </i> - ако условията за превръщането на клетка от зелена в червена са изпълнени, 
клетката се трансформира в червена <br>
