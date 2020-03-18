import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**Author: Cole Holladay, Olivia Wojcik, Alex Garza
 *Date: 10/23/19
 * Purpose: Explore the functions of stack 
 */
public class Test {

    /**Brief statement of purpose: To test the functions of stack using a text file
     *Preconditions: Must call functions in CharStack class to determine if palindrome
     * Postconditions: Will print the palindromes to a new txt file
     */
    public static void main(String[] args) throws IOException {
        String input = fileInput();
        File file = new File(input);

        try{
            String[] stringsFromFile = readFile(file); 
            PrintWriter writer = new PrintWriter("C:\\Users\\Olivia\\.android\\outputproject.txt");
            for (int i = 0; i < stringsFromFile.length; i++){
                CharStack stack = new CharStack();
                stack.StringToStack(stringsFromFile[i]);
                CharStack reverse = stack.Reverse();

                if (stack.equals(reverse)){
                    System.out.println(reverse);
                    writer.println(reverse);
                } 
            } 
            writer.close();
            
        }
        catch(FileNotFoundException ex){
            System.out.print(ex);
        }
        
    }
    public static String fileInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a file name: ");
        return input.next();
    }
    public static String[] readFile(File f) throws FileNotFoundException{
        if (!f.exists()){
            throw new FileNotFoundException("File does not exist.");
        }
        Scanner read = new Scanner(f);
        String[] strings = new String[16];
        for (int i = 0; i < strings.length; i++){
            strings[i] = read.nextLine();
        }
        return strings;
    }
}
