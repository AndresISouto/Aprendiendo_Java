package codewars;

public class main {


        public static void main(String[] args) {
            String palabra = "word";

            System.out.println(solution(palabra));

        }
        public static String solution(String str) {
            // Your code here...
            String cadena = "";

            for (int i = str.length()-1; i>=0;i--)
            {
                cadena += str.charAt(i);
            }
            return cadena;
        }
        public static String solution_mejorada(String str) {
            return new StringBuilder(str).reverse().toString();
        }


  


}
