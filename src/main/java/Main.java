import java.util.Scanner;

public class Main {

    public String testMe(){
        while(true){
            String test = new String();
            if(test!=null){
                return test;
            }
        }


    }

    public static Integer testOrder(){

        Integer s = new Integer(5);

        try {
            return s;
        }finally {
            s = 4;
            System.out.println("In the Method : " + s);
        }

    }



    public static void main(String[] args) {
//        int a = 0b100000;
//
//        byte b = (byte)0b11101001;
//
//        int c = 0b1000000 >> 34;
//
//        int d = 3;
//        d *= 4;
//
//        int[] f = {1,2,3,4,5};
//        int[] s = new int[5];
//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//        System.out.print("a: "+ a + "\n" + "b: " + b + "\n");
//        System.out.println("c: " + c);
//        System.out.println("d: " + d);


//        // 输入测试
//        Scanner sc = new Scanner(System.in);
//        StringBuffer sb = new StringBuffer();
//
//        Integer ss = null;
//        try {
//            ss = Integer.parseInt(sc.nextLine());
//        }catch (NumberFormatException e) {
//
//        }
//
//        if(ss != null){
//            sb.append(ss.toString());
//            System.out.println(sb.toString());
//        }
//        else{
//            System.out.println("Not a Integer");
//        }


        System.out.println("the Return Number : " + testOrder());

    }
}


