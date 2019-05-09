import java.util.ArrayList;

/**
   This class displays a solution to the Towers of
   Hanoi game.
*/

public class Hanoi
{
   ArrayList<Line> stack1 = new ArrayList<Line>();
   ArrayList<Line> stack2 = new ArrayList<Line>();
   ArrayList<Line> stack3 = new ArrayList<Line>();
   private int numDiscs;   // Number of discs
   
   /**
      Constructor.
      @param n The number of discs to use.
   */
   
   public Hanoi(int n)
   {
      // Assign the number of discs.
      numDiscs = n;

      //Initialize the illustration
      initStacks();
      
      // Move the number of discs from peg 1 to peg 3
      // using peg 2 as a temporary storage location.
      moveDiscs(numDiscs, 1, 3, 2);
   }

   /**
      The moveDiscs method displays a disc move.
      @param num The number of discs to move.
      @param fromPeg The peg to move from. 
      @param toPeg The peg to move to. 
      @param tempPeg The temporary peg.
   */
   
   private void moveDiscs(int num, int fromPeg,
                          int toPeg, int tempPeg)
   {

      if (num > 0)
      {
         //moveNum++;
         //System.out.println("A) " + " move num: " + moveNum + " num: " + num + " tempPeg: " + tempPeg);

         moveDiscs(num - 1, fromPeg, tempPeg, toPeg);
         //moveNum++;
         System.out.println(" Move a disc from peg " +
                        fromPeg + " to peg " + toPeg);
         stacks(fromPeg, toPeg);
         System.out.println(toString());
         moveDiscs(num - 1, tempPeg, toPeg, fromPeg);
      }
   }

   private void initStacks(){

      for(int i = 1; i <= numDiscs; i++){
         Line disc = new Line('*', i);
         stack1.add(disc);
      }


   }

   private void stacks(int from, int to){
      //Line[] discs = new Line[numDiscs];
      if(from == 1 && to == 2){
         stack2.add(0, stack1.get(0));
         stack1.remove(0);
      }
      else if(from == 1 && to == 3){
         stack3.add(0, stack1.get(0));
         stack1.remove(0);
      }
      else if(from == 2 && to == 1){
         stack1.add(0, stack2.get(0));
         stack2.remove(0);
      }
      else if(from == 2 && to == 3){
         stack3.add(0, stack2.get(0));
         stack2.remove(0);
      }
      else if(from == 3 && to == 1){
         stack1.add(0, stack3.get(0));
         stack3.remove(0);
      }
      else if(from == 3 && to == 2){
         stack2.add(0, stack3.get(0));
         stack3.remove(0);
      }
   }

   public String toString(){
      String stacks = "";
      stacks += "1) ";
      stacks += '\n';
      for(int i = 0; i < stack1.size(); i++){
         stacks += stack1.get(i);
         stacks += '\n';
      }
      stacks += "2) ";
      stacks += '\n';
      for(int j = 0; j < stack2.size(); j++){
         stacks += stack2.get(j);
         stacks += '\n';
      }
      stacks += "3) ";
      stacks += '\n';
      for(int k = 0; k < stack3.size(); k++){
         stacks += stack3.get(k);
         stacks += '\n';
      }
      return stacks;
   }
}
