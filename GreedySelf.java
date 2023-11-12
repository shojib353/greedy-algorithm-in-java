
package greedyself;

import java.util.Scanner;


public class GreedySelf {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        System.out.print("\nEnter number of item=");
       int ItemSize=sc.nextInt();
        Item[] AllItem=new Item[ItemSize];
        Item[] key=new Item[2];
        
        for(int i=0;i<ItemSize;i++){
            AllItem[i]=new Item();
            System.out.print("Enter product name=");
            AllItem[i].Name=sc.next();
            System.out.print("\nEnter product Quantity=");
       AllItem[i].Quantity=sc.nextFloat();
       System.out.print("\nEnter product profit=");
       AllItem[i].Profit=sc.nextFloat();
       AllItem[i].ProfitPerUnit=AllItem[i].Profit/AllItem[i].Quantity;
            
        }
        
        /*AllItem[0]=new Item();
        
       AllItem[0].Name="product0";
       AllItem[0].Quantity=2.2f;
       AllItem[0].ProfitPerUnit=10.32f;
       AllItem[1]=new Item();
       
       AllItem[1].Name="product1";
       AllItem[1].Quantity=4;
       AllItem[1].ProfitPerUnit=100;
       
       AllItem[2]=new Item();
       
       AllItem[2].Name="product2";
       AllItem[2].Quantity=20;
       AllItem[2].ProfitPerUnit=10;
       AllItem[3]=new Item();
       
       AllItem[3].Name="product3";
       AllItem[3].Quantity=2;
       AllItem[3].ProfitPerUnit=0.6f;*/
       
       sort ob=new sort();
       
       ob.insertion(ItemSize,AllItem,key);
       int counter=0;
        System.out.println("\nEnter bag capacity=");
       
       float BagCapacity=sc.nextFloat();
       
       
       Item[] Container=new Item[ItemSize];
       float totalProfit = 0;
        for (int i = 0; i < ItemSize; i++) {
            Container[i]=new Item();
            if (BagCapacity == 0) {
                
                break;
            }
            float a = Math.min(AllItem[i].Quantity, BagCapacity);
            totalProfit=totalProfit+(a*AllItem[i].ProfitPerUnit);
            
            AllItem[i].Quantity-=a;
            Container[i].Name=AllItem[i].Name;
             Container[i].Quantity+=a;
             
             BagCapacity=BagCapacity-a;
             counter++;
             
             
            
        }
        for (int i = 0; i < counter; i++) {
        System.out.println("\n"+i+" no Quantity of shope="+AllItem[i].Quantity+"\nName="+AllItem[i].Name);
        
        System.out.println("\n"+i+" no Quantity of bag="+Container[i].Quantity+"\nName="+Container[i].Name);
            
        }
        System.out.println(totalProfit);
        
    }
               
      
    }
    
    
    



class Item{
    
        String Name;
        float Quantity=0.00f;
        float ProfitPerUnit=0.00f;
        float Profit=00.0f;
        
    }

class sort{
   void insertion(int n,Item[] array,Item[] key){
       
        
        
        for(int i=1;i<n;i++){  //insertion sort start here
            key[1]=array[i];   //store i no index value inside key variable
            
            int j=i-1;          //using this for indecate i-1 no index value
            while (j>=0 && array[j].ProfitPerUnit<key[1].ProfitPerUnit){  /*compare key with i-1 or j no variable.
                                        if its true swapping if its false not need to swapping.
                                           array[j]<key) "<" for descending order //
                                                          ">" for ascending order*/
                array[j+1]=array[j]; 
                j=j-1;
            }
            array[j+1]=key[1];  //reset the key value
        }
        System.out.print("sorted value={");
       for(int i=0;i<n;i++){  //printing sorted array
            System.out.print(" "+array[i].ProfitPerUnit+","+array[i].Name+",");
        }
       System.out.print("}\n");

   
   }
}
