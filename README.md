# ImageEditor Documentation

The `ImageEditor` class is a Java program that allows you to perform various image processing operations on a given image. This documentation provides an overview of the class and its methods, along with descriptions of how to use them.

## Class Overview

The `ImageEditor` class contains a set of methods for performing image processing operations on a `BufferedImage` object. These operations include:

1. Printing the pixels of an image.
2. Converting an image to grayscale.
3. Adjusting the brightness of an image.
4. Rotating an image by 90 degrees clockwise.
5. Flipping an image horizontally.
6. Mirroring an image vertically.
7. Mirroring an image horizontally.
8. Flipping an image vertically.
9. Creating a negative image.
10. Creating a posterized image with custom levels.
11. Applying a blur effect to an image.

The class also provides methods for handling user input, allowing users to select and apply these image processing operations.

## Method Descriptions

### `printImagePixels`

```java
public static void printImagePixels(BufferedImage inputImage)
```

This method prints the pixel values of a given `BufferedImage` to the console. It helps visualize the color values of each pixel in the image.

### `grayScaleImage`

```java
public static BufferedImage grayScaleImage(BufferedImage inputImage)
```

This method converts a given `BufferedImage` to grayscale. It returns a new `BufferedImage` with grayscale color representation.

### `changeBrightness`

```java
public static BufferedImage changeBrightness(BufferedImage inputImage, int increase)
```

This method adjusts the brightness of a given `BufferedImage` by a specified percentage. It returns a new `BufferedImage` with the adjusted brightness.

### `rotateBy90`

```java
public static BufferedImage rotateBy90(BufferedImage image)
```

This method rotates a given `BufferedImage` by 90 degrees clockwise and returns a new rotated `BufferedImage`.

### `horizontalFlip`

```java
public static BufferedImage horizontalFlip(BufferedImage image)
```

This method flips a given `BufferedImage` horizontally and returns a new horizontally flipped `BufferedImage`.

### `mirror`

```java
public static BufferedImage mirror(BufferedImage image)
```

This method mirrors a given `BufferedImage` vertically and returns a new vertically mirrored `BufferedImage`.

### `mirrorVertical`

```java
public static BufferedImage mirrorVertical(BufferedImage image)
```

This method mirrors a given `BufferedImage` horizontally (vertically flips it) and returns a new horizontally mirrored `BufferedImage`.

### `verticalFlip`

```java
public static BufferedImage verticalFlip(BufferedImage image)
```

This method flips a given `BufferedImage` vertically and returns a new vertically flipped `BufferedImage`.

### `negative`

```java
public static BufferedImage negative(BufferedImage image)
```

This method creates a negative image (invert colors) from a given `BufferedImage` and returns the negative image.

### `poster`

```java
public static BufferedImage poster(BufferedImage image, int numLevels)
```

This method creates a posterized image with a custom number of color levels from a given `BufferedImage` and returns the posterized image.

### `blur`

```java
public static BufferedImage blur(BufferedImage image, int rad)
```

This method applies a blur effect to a given `BufferedImage` with a specified radius and returns the blurred image.

### `takingInput`

```java
public static int takingInput()
```

This method takes user input to select an image processing operation and returns an integer representing the selected operation.

### `handlingInput`

```java
public static void handlingInput(int input, BufferedImage image)
```

This method handles the selected image processing operation based on user input and applies the chosen operation to the input image.

### `handleOutputImage`

```java
public static void handleOutputImage(BufferedImage image)
```

This method handles the output image by saving it as a JPEG file and opening it using the default application.

### `main`

```java
public static void main(String[] args)
```

The `main` method is the entry point of the program. It allows the user to provide an image file path, performs image processing operations based on user input, and saves the output image.

## How to Use

1. Compile the `ImageEditor` class using a Java compiler.
2. Run the compiled program.
3. Enter the path to the image file you want to process.
4. Follow the on-screen instructions to select an image processing operation and adjust parameters if necessary.
5. The processed image will be saved as "output.jpeg" and opened with the default image viewer.

Please note that you can customize the main method to include additional image processing operations or modify the program's behavior according to your requirements.
