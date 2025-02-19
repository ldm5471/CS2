public class Anonymous {

    public static void main(String[] args) {
        System.out.println(new Object(){
            @Override
            public String toString(){
                return "This is bizarre";
            }
        });
    }
}
