//Abbey Kerkmann, 300007054, Section B
//Ryan Matte, 300027432, Section B

public class GenericArrayStack<E> implements Stack<E> {
   
  
   // ADD YOUR INSTANCE VARIABLES HERE
  private int top;
  private E[] elems;

   // Constructor
    @SuppressWarnings("unchecked")
    public GenericArrayStack( int capacity ) {
        
    // ADD YOU CODE HERE
      top = 0;
      elems = (E[])new Object[capacity];

    }

    // Returns true if this ArrayStack is empty
    public boolean isEmpty() {
      return (top == 0);
    // ADD YOU CODE HERE

    }

    public void push( E elem ) {
        
    // ADD YOU CODE HERE
      elems[top] = elem;
      top++;
      
    }
    public E pop() {
        
    // ADD YOU CODE HERE
      E temp = elems[top];
      elems[top] = null;
      return temp;

    }

    public E peek() {
        
    // ADD YOU CODE HERE
      return elems[top--];
      

    }
}
