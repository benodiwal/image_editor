import java.io.File;
import java.awt.Desktop;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.lang.Math;
import java.util.*;

public class ImageEditor {

	
/**
 * Prints the pixels of a BufferedImage.
 *
 * @param inputImage The BufferedImage whose pixels will be printed.
 */
public static void printImagePixels(BufferedImage inputImage) {
    // Get the height and width of the input image.
    int height = inputImage.getHeight();
    int width = inputImage.getWidth();

    // Iterate through each row (height) and column (width) of the image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            // Get the pixel value at the current position (i, j).
            int pixel = inputImage.getRGB(j, i);

            // Print the pixel value to the console.
            System.out.print(pixel);
        }
        // Move to the next line for the next row of pixels.
        System.out.println("");
    }
}

	
/**
 * Converts a BufferedImage to grayscale.
 *
 * @param inputImage The input BufferedImage to be converted to grayscale.
 * @return A new BufferedImage representing the grayscale version of the input image.
 */

public static BufferedImage grayScaleImage(BufferedImage inputImage) {
    // Get the width and height of the input image.
    int width = inputImage.getWidth();
    int height = inputImage.getHeight();
    
    // Create a new BufferedImage with grayscale color representation.
    BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

    // Iterate through each pixel in the input image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            // Get the color value of the pixel in the input image.
            int pixel = inputImage.getRGB(j, i);

            // Set the same color value in the output grayscale image.
            outputImage.setRGB(j, i, pixel);
        }
    }

    // Return the grayscale image.
    return outputImage;
}


/**
 * Adjusts the brightness of a BufferedImage.
 *
 * @param inputImage The input BufferedImage whose brightness will be adjusted.
 * @param increase   The percentage increase in brightness. A positive value increases brightness, while a negative value decreases it.
 * @return A new BufferedImage with the adjusted brightness.
 */
public static BufferedImage changeBrightness(BufferedImage inputImage, int increase) {
    // Get the width and height of the input image.
    int width = inputImage.getWidth();
    int height = inputImage.getHeight();
    
    // Create a new BufferedImage with 3-byte BGR color representation.
    BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each pixel in the input image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            // Get the color value of the pixel in the input image.
            Color pixel = new Color(inputImage.getRGB(j, i));
            
            // Extract the red, green, and blue components of the pixel.
            int red = pixel.getRed();
            int blue = pixel.getBlue();
            int green = pixel.getGreen();
            
            // Adjust the brightness of each component based on the percentage increase.
            red = red + (increase * red / 100);
            blue = blue + (increase * blue / 100);
            green = green + (increase * green / 100);

            // Ensure that the color components stay within the valid range [0, 255].
            if (red > 255) {
                red = 255;
            }
            if (blue > 255) {
                blue = 255;
            }
            if (green > 255) {
                green = 255;
            }
            if (red < 0) {
                red = 0;
            }
            if (blue < 0) {
                blue = 0;
            }
            if (green < 0) {
                green = 0;
            }

            // Create a new Color object with the adjusted components.
            Color newPixel = new Color(red, green, blue);
            
            // Set the adjusted pixel color in the output image.
            outputImage.setRGB(j, i, newPixel.getRGB());
        }
    }

    // Return the image with adjusted brightness.
    return outputImage;
}


/**
 * Rotates a BufferedImage by 90 degrees clockwise.
 *
 * @param image The input BufferedImage to be rotated.
 * @return A new BufferedImage representing the rotated image.
 */
public static BufferedImage rotateBy90(BufferedImage image) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();

    // Create a new BufferedImage with swapped width and height.
    BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each pixel in the input image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            // Get the color value of the pixel in the input image.
            int pixel = image.getRGB(j, i);
            
            // Set the pixel in the output image with swapped coordinates.
            outputImage.setRGB(height - i - 1, j, pixel);
        }
    }

    // Return the rotated image.
    return outputImage;
}


//	public static BufferedImage rotateby90Dash(BufferedImage image) {
//		int width = image.getWidth();
//		int height = image.getHeight();
//
//		BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);

//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				int pixel = image.getRGB(j, i);
//				outputImage.setRGB(i, j, pixel);
//			}
//		}
//
//		return outputImage;
//	}

//	public static BufferedImage rotateby90DoubleDash(BufferedImage image) {
//		int width = image.getWidth();
//		int height = image.getHeight();

//		BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);

//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				int pixel = image.getRGB(j, i);
//				outputImage.setRGB(height-i-1, width-j-1, pixel);
//			}
//		}

//		return outputImage;
//	}

//	public static BufferedImage rotateby90TripleDash(BufferedImage image) {
//		int width = image.getWidth();
//		int height = image.getHeight();
 
//		BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
//
//		for (int i = 0; i < height; i++) {
////			for (int j = 0; j < width; j++) {
//				int pixel = image.getRGB(j, i);
//				outputImage.setRGB(i, width-j-1, pixel);
//			}
//		}

//		return outputImage;
//	}

/**
 * Flips a BufferedImage horizontally.
 *
 * @param image The input BufferedImage to be horizontally flipped.
 * @return A new BufferedImage representing the horizontally flipped image.
 */
public static BufferedImage horizontalFlip(BufferedImage image) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();

    // Create a new BufferedImage to store the flipped image.
    BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each row in the input image up to its midpoint.
    for (int i = 0; i < height / 2; i++) {
        for (int j = 0; j < width; j++) {
            // Swap the pixels horizontally between the current row and its corresponding row from the bottom.
            int temp = image.getRGB(j, i);
            flippedImage.setRGB(j, i, image.getRGB(j, height - i - 1));
            flippedImage.setRGB(j, height - i - 1, temp);
        }
    }

    // Return the horizontally flipped image.
    return flippedImage;
}


/**
 * mirrors a BufferedImage vertically.
 *
 * @param image The input BufferedImage to be vertically mirrored.
 * @return A new BufferedImage representing the vertically mirrored image.
 */
public static BufferedImage mirror(BufferedImage image) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();

    // Create a new BufferedImage to store the vertically mirrored image.
    BufferedImage mirroredImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each row in the input image up to its midpoint.
    for (int i = 0; i < height / 2; i++) {
        for (int j = 0; j < width; j++) {
            // Swap the pixels vertically between the current row and its corresponding row from the bottom.
            int temp = image.getRGB(j, i);
            mirroredImage.setRGB(j, height - i - 1, temp);
            mirroredImage.setRGB(j, i, temp);
        }
    }

    // Return the vertically mirrored image.
    return mirroredImage;
}

	
/**
 * mirrors a BufferedImage horizontally (vertically flips it).
 *
 * @param image The input BufferedImage to be horizontally mirrored.
 * @return A new BufferedImage representing the horizontally mirrored image.
 */
public static BufferedImage mirrorVertical(BufferedImage image) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();

    // Create a new BufferedImage to store the horizontally mirrored image.
    BufferedImage mirroredImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each row in the input image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width / 2; j++) {
            // Swap the pixels horizontally between the current column and its corresponding column from the right.
            int temp = image.getRGB(j, i);
            mirroredImage.setRGB(width - j - 1, i, temp);
            mirroredImage.setRGB(j, i, temp);
        }
    }

    // Return the horizontally mirrored image.
    return mirroredImage;
}

/**
 * Flips a BufferedImage vertically.
 *
 * @param image The input BufferedImage to be vertically flipped.
 * @return A new BufferedImage representing the vertically flipped image.
 */
public static BufferedImage verticalFlip(BufferedImage image) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();

    // Create a new BufferedImage to store the vertically flipped image.
    BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    // Iterate through each row in the input image.
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width / 2; j++) {
            // Swap the pixels vertically between the current column and its corresponding column from the right.
            int temp = image.getRGB(j, i);
            flippedImage.setRGB(j, i, image.getRGB(width - j - 1, i));
            flippedImage.setRGB(width - j - 1, i, temp);
        }
    }

    // Return the vertically flipped image.
    return flippedImage;
}


	public static BufferedImage negative(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = image.getRGB(j, i);
				Color color = new Color(pixel);
				int red = 255 - color.getRed();
				int green = 255 - color.getGreen();
				int blue = 255 - color.getBlue();

				Color new_pixel = new Color(red, green, blue);
				outputImage.setRGB(j, i, new_pixel.getRGB());
			}
		}

		return outputImage;

	}


	public static BufferedImage poster(BufferedImage image, int numLevels) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int interval = 256 / numLevels;  // Calculate the interval size

     for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            Color color = new Color(image.getRGB(j, i));

            int red = (color.getRed() / interval) * interval;
            int blue = (color.getBlue() / interval) * interval;
            int green = (color.getGreen() / interval) * interval;

            Color newColor = new Color(red, green, blue);
            outputImage.setRGB(j, i, newColor.getRGB());
        }
    }

    return outputImage;
}


/**
 * Applies a blur effect to a BufferedImage.
 *
 * @param image The input BufferedImage to be blurred.
 * @param rad   The radius of the blur effect. Larger values result in stronger blur.
 * @return A new BufferedImage representing the blurred image.
 */
public static BufferedImage blur(BufferedImage image, int rad) {
    // Get the width and height of the input image.
    int width = image.getWidth();
    int height = image.getHeight();
    
    // Create a new BufferedImage to store the blurred image with the same dimensions and RGB color representation.
    BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Iterate through each pixel in the input image.
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int sumRed = 0, sumBlue = 0, sumGreen = 0, pixels = 0;

            // Iterate through the pixels within the specified radius around the current pixel.
            for (int dy = -rad; dy <= rad; dy++) {
                for (int dx = -rad; dx <= rad; dx++) {
                    int newX = Math.min(Math.max(x + dx, 0), width - 1);
                    int newY = Math.min(Math.max(y + dy, 0), height - 1);

                    // Get the color of the nearby pixel.
                    Color pixel = new Color(image.getRGB(newX, newY));
                    sumBlue += pixel.getBlue();
                    sumRed += pixel.getRed();
                    sumGreen += pixel.getGreen();

                    pixels++;
                }
            }

            // Calculate the average color values within the specified radius.
            int avgRed = sumRed / pixels;
            int avgBlue = sumBlue / pixels;
            int avgGreen = sumGreen / pixels;

            // Create a new Color object with the average color values.
            Color newPixel = new Color(avgRed, avgGreen, avgBlue);

            // Set the blurred color to the pixels within the specified radius around the current pixel.
            for (int dy = -rad; dy <= rad; dy++) {
                for (int dx = -rad; dx <= rad; dx++) {
                    int newX = Math.min(Math.max(x + dx, 0), width - 1);
                    int newY = Math.min(Math.max(y + dy, 0), height - 1);
                    outputImage.setRGB(newX, newY, newPixel.getRGB());
                }
            }
        }
    }

    // Return the blurred image.
    return outputImage;
}

	public static BufferedImage rotate(BufferedImage image) {

                BufferedImage output = image;

		Scanner sc = new Scanner(System.in);
		System.out.println("The angle by which you wanna rotate it --> ");
		System.out.println("1.)90   2.)180   3.) 270");
		int angle_num = sc.nextInt();

                for (int i = 0; i < angle_num; i++) {
                     output = rotateBy90(output);
        }

		return output;
	}

/**
 * Handles the blurring of a BufferedImage based on user input.
 *
 * @param image The input BufferedImage to be blurred.
 * @return A new BufferedImage representing the blurred image.
 */
public static BufferedImage handleBlur(BufferedImage image) {
    // Create a Scanner object to read user input.
    Scanner sc = new Scanner(System.in);
    
    // Prompt the user to enter the intensity of blur.
    System.out.println("Enter the intensity of blur:");
    
    // Read the user's input as an integer.
    int num = sc.nextInt();
    
    // Close the Scanner to release resources.
     
    
    // Apply the blur effect to the input image with the specified intensity.
    return blur(image, num);
}

/**
 * Handles the adjustment of brightness in a BufferedImage based on user input.
 *
 * @param image The input BufferedImage to be adjusted.
 * @return A new BufferedImage representing the adjusted image.
 */
public static BufferedImage handleChangeBrightness(BufferedImage image) {
    // Create a Scanner object to read user input.
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the value by which to increase the brightness.
    System.out.println("Enter the value by which you want to increase the brightness:");

    // Read the user's input as an integer.
    int num = sc.nextInt();

    // Close the Scanner to release resources.
     

    // Apply the brightness adjustment to the input image with the specified value.
    return changeBrightness(image, num);
}

public static BufferedImage handleMirror(BufferedImage image) {
        BufferedImage output = image;
        Scanner sc = new Scanner(System.in);
        System.out.println("How do you want to use the mirror effect ?");
        System.out.println("1. horizontally");
        System.out.println("2. vertically");

        int num = sc.nextInt();

        if (num == 1) {
            output = mirror(image);
        } else if (num == 2) {
            output = mirrorVertical(image);
        }
    
         

        return output;
    }

/**
 * Takes user input to select an image processing operation.
 *
 * @return An integer representing the selected operation.
 */
public static int takingInput() {
    // Create a Scanner object to read user input.
    Scanner sc = new Scanner(System.in);

    // Display a menu of available image processing options.
    System.out.println("What do you want to do with the image?");
    System.out.println("1. Flip the image horizontally");
    System.out.println("2. Flip the image vertically");
    System.out.println("3. Convert the image to grayscale");
    System.out.println("4. Change the brightness of the image");
    System.out.println("5. Rotate the image");
    System.out.println("6. Apply the mirror effect");
    System.out.println("7. Apply blur effect");
    System.out.println("8. Apply negative effect");
    System.out.println("9. Apply poster effect");

    // Read the user's choice as an integer.
    int input = sc.nextInt();

    // Close the Scanner to release resources.
     

    return input;
}

	
/**
 * Handles the selected image processing operation based on user input.
 *
 * @param input An integer representing the selected operation.
 * @param image The input BufferedImage to be processed.
 */
public static void handlingInput(int input, BufferedImage image) {
    switch (input) {
        case 1:
            handleOutputImage(horizontalFlip(image));
            break;
        case 2:
            handleOutputImage(verticalFlip(image));
            break;
        case 3:
            handleOutputImage(grayScaleImage(image));
            break;
        case 4:
            handleOutputImage(handleChangeBrightness(image));
            break;
        case 5:
            handleOutputImage(rotate(image));
            break;
        case 6:
            handleOutputImage(handleMirror(image));
            break;
        case 7:
            handleOutputImage(handleBlur(image));
            break;
        case 8:
            handleOutputImage(negative(image));
            break;
        case 9:
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the numLevels of the poster effect..");
            int num = sc.nextInt();
            handleOutputImage(poster(image, num));
             
        default:
            break;
    }
}

/**
 * Handles the output image by saving it as a JPEG file and opening it using the default application.
 *
 * @param image The BufferedImage to be handled as output.
 */
public static void handleOutputImage(BufferedImage image) {
    try {
        // Create a File object with the desired output file name and format.
        File file = new File("output.jpeg");
        
        // Write the BufferedImage to the output file as a JPEG image.
        ImageIO.write(image, "jpeg", file);
        
        // Open the output file using the default application.
        Desktop.getDesktop().open(file);
    } catch (IOException e) {
        // Handle any potential IOException by printing the stack trace.
        e.printStackTrace();
    }
}

	public static void main(String[] args) {

		boolean isValid = false;

		while (!isValid) {
		try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the valid path of the image on which you wanna make changes...");
				String path = sc.nextLine();
				File file = new File(path);
				BufferedImage image = ImageIO.read(file);
				File o_file = new File("output.jpeg");
			//System.out.println("Opening original file ...");
			//Desktop.getDesktop().open(file);
				handlingInput(takingInput(), image);
				isValid = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	}
}
