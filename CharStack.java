
import java.util.EmptyStackException;
import java.util.Stack;

/**Author: Cole Holladay, Olivia Wojcik, Alex Garza
 *Date: 10/23/19
 * Purpose: Explore the functions of stack 
 */
public class CharStack {
    /**Brief statement of purpose: Follow specs for a module and functions of the stack type char
     *Preconditions: You must use all following functions and implement them in a test
     * Postconditions: Will iterate through characters, push them to a stack, check if alphabetic, if reverse do they equal the original and then print palindromes to the output txt file
     */

private Stack<Character> myCharacters; // STL stack of chars.
    private int count;
    
    CharStack(){
        this.myCharacters = new Stack<Character>();
    }
  
    public void StringToStack(String inStr){
     /*  StringToStack function reads the string into its private stack.
        Precondition: check if a character is an alphabetic letter
        Postcondition: only alphabetic letters of the string are in the private stack.
                       Other characters(like space, digit, punct, etc) can not be in the stack.
    
    */
       inStr = inStr.toLowerCase();
        
        for (char c : inStr.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                     myCharacters.push(c);
                }
        }
    }
    public CharStack Reverse(){
       /* Reverse function empties its private stack out into another stack, 
        causing the order of the characters to be reversed.  Returns this new stack.
        Precondition:  Private stack is not empty.
	Postcondition:  If private stack is empty, displays error and returns.
        Otherwise: Returns new stack containing private stack's
		   elements in reverse order.  Private stack is empty.
    */  
        CharStack tempCharStack = new CharStack();
        Stack<Character>t = (Stack<Character>)myCharacters.clone();

        while (!t.empty()){
            tempCharStack.push(t.pop());
        }
        return tempCharStack;
    }
    @Override
    public boolean equals(Object B){
        /* IsEqual function tests if both private stack and B's stack are the same.

        Precondition:  Neither stack is empty.

	Postcondition:  If either stack is empty,
		        displays error message and returns.

        Otherwise:
            Returns true if both stacks are the same, returns false otherwise.
            Both the private stack and B's stack are empty.
    */  
    
        boolean flag = true;
        CharStack obj = (CharStack)B;
        if (B == null){
            flag = false;
        }
        else if (!(obj instanceof CharStack)){
            flag = false;
        }
        else if (obj.size() != myCharacters.size()){
            flag = false;
        }
        else{
            
            Stack<Character> t1 = (Stack<Character>)myCharacters.clone();
            Stack<Character> t2 = (Stack<Character>)obj.myCharacters.clone();
                
                while (!t1.empty()) {
                    if (!(t1.pop().equals(t2.pop())) ) {
                    flag = false; 
                    }
                }
        }
        return flag;
    }
    public Boolean checkIfPalindrome(String string){
        String newString = "";
        //reads old parameter and creates a new string that has a reversed order
        for(int i = string.length()-1;i>=0;i--){
            newString += string.charAt(i);
        }
        return myCharacters.toString().equals(newString);
    }
    
      public char peek(){
        return myCharacters.peek();
    }
    
      public boolean isEmpty(){
        return this.count == 0;
    }
      
    public void push(char e){
        myCharacters.push(e);
        count++;
    }
    
    public int size(){
        return count;
    }
    
    public char pop(){
        char popped = this.myCharacters.pop();
        count--;
        return popped;
    }
    
    @Override
    public String toString(){
       /* Postcondition:  Contents of stack have been converted to string on one line.  
       the private stack myCharacters is unchanged.
    */ 
        String results = "";
        for (int i=0; i<myCharacters.size(); i++){
            results += myCharacters.get(i);
        }
        return results;
    }  
}
