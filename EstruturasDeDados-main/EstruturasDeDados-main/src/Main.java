

public class Main {
    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        for (int i = 0; i < 10; i++) {
            myList.insertAtBeginning(i + 1);
            System.out.println(myList);
        }
        myList.insertAtBeginning(552);
        System.out.println(myList);
        
        myList.removeAtBeginning();
        System.out.println();

        System.out.println(myList);

    }
}