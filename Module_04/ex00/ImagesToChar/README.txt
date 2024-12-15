#ImagesToChar

This project converts a BMP image into a character representation in the console.

##Requirements
- A valid BMP file with White and black color.

##Compile Instructions
Run the following command:
javac -d target -sourcepath src/java src/java/fr/fortytwo/printer/app/Main.java

##Run Instructions
java -cp target fr.fortytwo.printer.app.Main <charForBlack> <charForWhite> <image Relative Path>

##Example
java -cp target fr.fortytwo.printer.app.Main . 0  /$HOME/JAVA_MODULES/Module_04/ex00/it.bmp
