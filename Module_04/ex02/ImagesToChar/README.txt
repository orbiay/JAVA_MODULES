#ImagesToChar

This project converts a BMP image into a character representation in the console.

##Requirements
- A valid BMP file with White and black color.

## Compile Instructions
Run the following command:
javac -d target -sourcepath src/java src/java/fr/fortytwo/printer/app/Main.java


## Copy Resources to the Target Directory
mkdir -p target/resources
cp -r ./src/resources/* target/resources/

## Package into the JAR
jar cfm target/my-application.jar ./src/manifest.txt  -C target .

## Example
jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C target .

## Running the JAR
java -jar ./target/images-to-chars-printer.jar . 0 ./target/resources/it.bmp
