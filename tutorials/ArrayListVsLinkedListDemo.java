import java.util.*;

public class ArrayListVsLinkedListDemo {
    public static void main(String[] args) {
        // 1. Declaring
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        // 2. Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        linkedList.add("Cat");
        linkedList.add("Dog");

        // 3. Adding elements at particular location
        arrayList.add(1, "Mango"); // Insert Mango at index 1
        linkedList.add(1, "Elephant"); // Insert Elephant at index 1

        // 4. Removing elements
        arrayList.remove("Banana"); // Remove by value
        linkedList.remove("Cat");

        // 5. Removing elements at particular location
        arrayList.remove(0); // Remove by index
        linkedList.remove(0);

        // 6. Accessing elements
        String arrItem = arrayList.get(0);
        String linkItem = linkedList.get(0);

        // 7. Getting Size
        int arrSize = arrayList.size();
        int linkSize = linkedList.size();

        // 8. Getting first and last elements
        String arrFirst = arrayList.get(0);
        String arrLast = arrayList.get(arrayList.size() - 1);
        String linkFirst = linkedList.get(0);
        String linkLast = linkedList.get(linkedList.size() - 1);

        // 9. Removing first and last elements
        arrayList.remove(0); // First
        arrayList.remove(arrayList.size() - 1); // Last
        ((LinkedList<String>)linkedList).removeFirst(); // First
        ((LinkedList<String>)linkedList).removeLast(); // Last

        // 10. Transforming (mapping to uppercase)
        arrayList.addAll(Arrays.asList("One", "Two", "Three"));
        List<String> upperArr = arrayList.stream()
                                         .map(String::toUpperCase)
                                         .toList();

        // 11. Sorting with and without custom logic
        Collections.sort(arrayList); // Default sort
        arrayList.sort((a, b) -> b.compareTo(a)); // Custom reverse sort

        // 12. Iterating them
        for (String s : arrayList) {
            System.out.println("ArrayList item: " + s);
        }
        linkedList.forEach(item -> System.out.println("LinkedList item: " + item));

        // 13. Different methods of list object
        arrayList.isEmpty();
        arrayList.contains("Two");
        arrayList.indexOf("Three");
        arrayList.clear();

        // 14. Using Collections utils methods on list
        Collections.addAll(arrayList, "X", "Y", "Z");
        Collections.reverse(arrayList);
        Collections.shuffle(arrayList);
        Collections.fill(arrayList, "Filled");
        List<String> unmodifiable = Collections.unmodifiableList(arrayList);

        // Print examples
        System.out.println("Final ArrayList: " + arrayList);
        System.out.println("Final LinkedList: " + linkedList);
        System.out.println("Unmodifiable List: " + unmodifiable);
    }
}
