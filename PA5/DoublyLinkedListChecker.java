public class DoublyLinkedListChecker {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        int returnInt;
        boolean returnBool;
        String returnString;

        returnInt = list.size();
        returnBool = list.add(1);
        list.add(0, 1);
        returnInt = list.get(0);
        returnInt = list.set(0, 1);
        returnInt = list.remove(0);
        returnBool = list.contains(0);
        returnString = list.toString();
        returnBool = list.isEmpty();
        list.clear();
    }

}
