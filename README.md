# Practica firmă de închirieri casete/DVD-uri audio/video/jocuri
Partea scrisa a proiectului
Tema
Analiza problemei
Specificarea cerintelor
Proiectarea la nivel conceptual (Modelul conceptual al datelor / Diagrama Entitate Relatie)
Proiectarea la nivel logic (Modelul logic al datelor / Schema bazei de date relationale)
Proiectarea la nivel fizic (Modelul fizic al datelor)
Limbaje si librarii utilizate - o scurta descriere
Descrierea aplicatiei


Aplicatia Java va implementa interfata grafica in Java SWING si va folosi JDBC pentru conectarea la baza de date.

Pentru entitatile din aplicatie va permite cel putin:
    - listare/vizualizare
    - adaugare,
    - modificare,
    - stergere,
    - cautare,
    - filtrare
    - login

Suplimentar se pot implementa:
- export date in PDF/XLSX
- import date din XLSX
- rapoarte pentru o perioada selectabile si reprezentarea datelor sub forma une grafice (bar chart, line chart, pie chart)


Implementarea aplicatiei
- implementarea tabelelor in baza de date
- o aplicatie fara interfata grafica - de test - pentru utilizarea JDBC - testarea implementarii comenzilor SQL SELECT/INSERT/DELETE/UPDATE pe baza de date nou creata
- crearea interfetei grafice pentru aplicatia finala - Java SWING fie fara GUI Builder, de la 0, fie folosind un GUI Builder - de ex. NetBeans IDE GUI Builder, din WindowBuilder din Eclipse
- veti crea un singur JFrame pentru fereastra principala a aplicatiei si mai multe containere (de ex JPanel) pentru fiecare actiune/functionalitate si eventual ferestre de dialog (JDialog) unde este cazul. Aceste containere vor fi incarcate/afisate/ascunse/sterse in fereastra principala.
- implementarea sistemului de login
- afisarea functionalitatilor pe baza rolului fiecarui utilizator (fiecare utilizator va avea asociat un rol in aplicatie)
- implementarea functionalitatilor din capitolul "Specificarea cerintelor"


Resurse

JDBC
https://docs.oracle.com/javase/tutorial/index.html
https://docs.oracle.com/javase/tutorial/jdbc/index.html
https://www.tutorialspoint.com/jdbc/index.htm
https://www.javatpoint.com/java-jdbc

MySQL
https://dev.mysql.com/doc/connector-j/8.0/en/
https://dev.mysql.com/doc/connector-j/5.1/en/

Oracle
https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/toc.htm

Microsoft SQL Server
https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15

PostgreSQL
https://jdbc.postgresql.org/documentation/head/index.html

API
https://docs.oracle.com/javase/8/docs/api/
https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html
https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html
Package java.sql



Informatii utile privitoare la disciplina Practica, anul 2 Calculatoare, 2024

Practica se va desfasura in perioada luni, 1 iulie - vineri, 19 iulie 2024 (90 de ore, 6 ore pe zi).

Practica se poate face in productie sau la facultate.

Pentru practica in productie studentii vor trebui sa caute o firma cu profile IT (sau care are departament IT) care sa-i accepte sa efectueze stagiul de practica.

Practica la facultate consta in realizarea unui proiect (realizarea unei aplicatii).

Pentru studentii care doresc sa faca practica la facultate vom avea intalniri in care vom stabili temele de proiect, cerintele si se va prezenta progresul.

Evaluarea activității de practică se face la sfârșitul perioadei de practică, în cadrul unui colocviu.
