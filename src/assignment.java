/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sumit 
 */
import java.util.Arrays;
import java.util.Scanner;
public class assignment
{
    int num,i,j,k;
    String com[][] = new String[100][100];
    String comaf[][] = new String[100][100];
    String comafi[][] = new String[100][100];
    int[] a= new int[100];
    
    // input from user 
    void input()
      {   
         //taking the total number of cases 
         System.out.print("Enter the total number of cases :- ");
         Scanner sc=new Scanner(System.in);
         num = sc.nextInt();
         
         //taking the lenght of each case 
         for(i=1;i<=num;i++)
         {
           System.out.println();
           System.out.print("Enter the length of case :- "+i+"   ");
           a[i-1]=sc.nextInt();
           convertd2b(i-1,a[i-1]);
         }
      }
     
      //convert binary to decimal 
      String toBinary(int n) 
        {
           if(n==0)
           {
             return "0";
           }
           String binary = "";
           while(n>0) 
             {
              int rem = n % 2;
              binary = rem + binary;
              n=n/2;
             }
          return binary;
        }
    
       //convert decimal to binary with fix length of bits 
        void convertd2b(int c,int n)
         {
           int tnum,counter1=0,counter2=0;
           int cc,b;
           cc=c;
           tnum = (int)Math.pow(2,n);
           for(k=0;k<tnum;k++)
            {  
              b=Integer.parseInt(toBinary(k));
              com[cc][k]=String.format("%0"+n+"d",b);
              if(com[cc][k].contains("00"))
               {
                 comafi[cc][counter1]=com[cc][k];
                 counter1++;
               }
              else
               {
                 comaf[cc][counter2]=com[cc][k];
                 counter2++;
               }
            }
      
          //removing null and empty values form string 
               comaf[cc] = Arrays.stream(comaf[cc])
                     .filter(s -> (s != null && s.length() > 0))
                     .toArray(String[]::new);
                comafi[cc] = Arrays.stream(comafi[cc])
                     .filter(s -> (s != null && s.length() > 0))
                     .toArray(String[]::new);
          }
    
      // print the output
       void output()
        {
          int flag=0;
          System.out.println();
          System.out.println("------------------output---------------------");
          System.out.println();
          for(i=0;i<num;i++)
           {
             System.out.println("output "+i+"-> "+comaf[i].length);
           }
          System.out.println();
          System.out.println("---------press 1 to show more result---------");
          System.out.println();
          Scanner sc = new Scanner(System.in);
          flag=sc.nextInt();
          if(flag==1)
           {
             System.out.println("------------------output---------------------");
             for(i=0;i<num;i++)
              {
               System.out.println();
               System.out.println("output "+i+"-> "+comaf[i].length);
               System.out.println("Total bit string ");
                for(j=0;j<(int)Math.pow(2,a[i]);j++)
                 {
                   System.out.print(com[i][j]+"  ");
                 }  
               System.out.println();
               System.out.println("Total valid bit string ");
                for(j=0;j<(int)comaf[i].length;j++)
                 {
                  System.out.print(comaf[i][j]+"  ");
                 }
                System.out.println();
                System.out.println("Total invalid bit string ");
                for(j=0;j<(int)comafi[i].length;j++)
                 {
                  System.out.print(comafi[i][j]+"  ");
                 }
               System.out.println();
              }
           }
        }
   
    //main function
    public static void main(String[] args)
    {
        assignment ag =new assignment();
        ag.input();
        ag.output();
    }
}
