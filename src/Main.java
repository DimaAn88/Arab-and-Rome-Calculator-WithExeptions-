import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input data
        String a = "Введите два неотрицательных числа (арабских или римских) не больше 10 с операндом +-*/, например 1+2 или I*IV";
        String d = null;
        int err1=0;
        System.out.println(a);
        double c, b; int q=0;
        int w1=0; int w2=0;
        Scanner in = new Scanner(System.in);
        d = in.next();
        in.close();
        int len1 = d.length();
        //System.out.println(len1);
        //unicode's operation
        String f = "0123456789IVX+-/*";
        int len2 = f.length();
        int x = 0;
        f.charAt(1);
        //System.out.println(f.charAt(1));
        int i, j;
        int e;
        int[] unicod = new int[len2];
        for (i = 0; i < len2; i++) {
            //  System.out.println(f.codePointAt(i));
            e = f.codePointAt(i);
            unicod[i] = e;
        }
        // System.out.println(Arrays.toString(unicod));
        int[] arab = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        int[] rim = {73, 86, 88};
        int[] calc = {42, 43, 45, 47};
        int[] usersum = new int[len1];
        for (j = 0; j < len1; j++) {
            usersum[j] = d.codePointAt(j);
        }
        //System.out.println(Arrays.toString(usersum));
        //controlling terms. 1st compare all simbols
        int n = 0;

        int q2;
        for (i = 0; i < len1; i++) {
            int m = 0;
            int l = usersum[i];

            for (j = 0; j < len2; j++) {
                int l2 = unicod[j];
                int k;
                if (l == l2) {
                    m = 1;
                    ;
                    n = n + 1;
                    //System.out.println("найдено " + n + "/" + len1 + " совпадение; ");
                    for (k = 0; k < 4; k++) {
                        if (l == calc[k]) {
                            q = i + 1; err1=err1+1;
                            //System.out.println("Знак на " + q + " месте");
                        }
                    }
                }
            }
        }
        if (q==0) {System.out.print("строка не является математической операцией");} else
        if (err1>1) { System.out.println("слишком много операндов");} else {
        System.out.println(" ");
        if (n == len1) {
           // System.out.println("выражение корректно");
            x = x + 1;
        } else {
            System.out.println("выражение не корректно");

        }
        // controlling similar data
        int p = usersum[0];
        int p1 = usersum[len1 - 1];
        int p3 = Math.abs(p1 - p);
        if (p3 > 15) {
            System.out.println("данные разных типов");
        } else {
            //System.out.println("норма типов данных");
            x = x + 1;
        }
        if (p > 60) {
            //System.out.println("римское исчисление");
            x = x + 1;
        } else {
            //System.out.println("арабское исчисление");
        }

        // arab numbers

        if (x == 2) {
            w1 = usersum[0] - 48;
            w2 = usersum[2] - 48;
            if (q==3) {w1=10; w2 = usersum[3] - 48; }
            if ((len1-q)==2) {w2=10;}
        }

        //  rome's numbers
         if (x==3) {
        int len3 = q-1;
        int len4 = len1-q;
        int [] num1=new int[len3];int [] num2 =new int[len4]; //System.out.println("числa римские");
        for (i=0; i<len3; i++) { num1[i]= usersum[i];//System.out.print(usersum[i]);
            }
        for (i=0; i<len4; i++) { num2[i]= usersum[i+1+len3]; //System.out.print(num2[i]);
        }
        if (len3==4) {w1=8;}
         if (len4==4) {w2=8;}
         if (len3==1) { if (num1[0]==73){w1=1;}
                        if (num1[0]==86){w1=5;}
                        if (num1[0]==88){w1=10;} }
         if (len4==1) { if (num2[0]==73){w2=1;}
                        if (num2[0]==86){w2=5;}
                        if (num2[0]==88){w2=10;} }
         if (len3==3) { if (num1[0]==73){w1=3;}
                        if (num1[0]==86){w1=7;} }
         if (len4==3) { if (num2[0]==73){w2=3;}
                        if (num2[0]==86){w2=7;} }
         if (len3==2)
             if (num1[0] == 86) {
                 w1 = 6;
             } else {
                 if (num1[1] == 73) {
                     w1 = 2;
                 }
                 if (num1[1] == 86) {
                     w1 = 4;
                 }
                 if (num1[1] == 88) {
                     w1 = 9;
                 }
             }
             if (len4 == 2)
                 if (num2[0] == 86) {
                     w2 = 6;
                 } else {
                     if (num2[1] == 73) {
                         w2 = 2;
                     }
                     if (num2[1] == 86) {
                         w2 = 4;
                     }
                     if (num2[1] == 88) {
                         w2 = 9;
                     }
                 }
              
         }
            // System.out.println("числа " + w1 + "  " + w2);
                  // Math operations
             int result=0;
             if (usersum[q-1]==43) {result=w1+w2;}
             if (usersum[q-1]==45) {result=w1-w2;}
             if (usersum[q-1]==47) {result=w1/w2;}
             if (usersum[q-1]==42) {result=w1*w2;}

             if (x==2) {
             if (x>1) {System.out.println(result);} }

             if (x==3) if (result>0) {
                         int u =0;
                         int r =0;
                         int des=0;
                         des = result/10; System.out.print("ответ  ");
                           // System.out.println(des);
                            for (i=0; i<des; i++) {System.out.print("X");}
                            u=result-des*10;
                            if (u==1) {System.out.print("I");}
                            if (u==2) {System.out.print("II");}
                            if (u==3) {System.out.print("III");}
                            if (u==4) {System.out.print("IV");}
                            if (u==5) {System.out.print("V");}
                            if (u==6) {System.out.print("VI");}
                            if (u==7) {System.out.print("VII");}
                            if (u==8) {System.out.print("VIII");}
                            if (u==9) {System.out.print("IX");}

                             }   else { System.out.print("ошибка! римский результат должен быть больше 0"); }
    }



    }





}


