public class Exercise27_09 {

    public static void main(String[] args) {
        String s = "4.5";
        System.out.println(hashCodeForString(s));
        s = "Hello";
        System.out.println(hashCodeForString(s));
        }
        public static int hashCodeForString(String s) {
            // Add your code here
            int B = 31;
            int hashcode = 0;
            for(int i = 0; i <s.length(); i++)
                hashcode = B *hashcode + (int)s.charAt(i);

        return hashcode;
        }
    }

