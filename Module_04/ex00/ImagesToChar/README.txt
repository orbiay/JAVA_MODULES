#ImagesToChar

This project converts a BMP image into a character representation in the console.

##Requirements
- A valid BMP file with White and black color.

##Compile Instructions
Run the following command:
javac -d target -sourcepath src src/javaa/fr/fortytwo/printer/app/Main.java

##Run Instructions
java -cp target fr.fortytwo.printer.app.MainApp <charForBlack> <charForWhite> <image Relative Path>

##Example
java -cp target fr.fortytwo.printer.app.Main image.bmp . 0
