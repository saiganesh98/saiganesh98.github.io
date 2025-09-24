import java.util.*;
// removeFirst(), removeLast(), getFirst(), getLast() are only available if reference type if LinkedList
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

/**

ArrayList vs LinkedList Operations in Java
📌 Introduction
ArrayList and LinkedList are two commonly used classes in Java that implement the List interface. Both support storing ordered elements, allowing duplicates and null values. The difference lies in their underlying data structures and performance characteristics.

🔹 1. Add Element
* ArrayList
    * list.add(element) → adds at the end in O(1) (amortized).
    * list.add(index, element) → inserts at a specific index but may require shifting → O(n).
* LinkedList
    * list.add(element) → appends at the end in O(1).
    * list.add(index, element) → traverses to index (O(n)) + links nodes (O(1)) → overall O(n).

🔹 2. Remove Element
* ArrayList
    * list.remove(index) → shifts elements → O(n).
    * list.remove(element) → searches for element + shifts → O(n).
* LinkedList
    * list.remove(index) → traverses to index → O(n).
    * list.remove(element) → searches + unlinks node → O(n).
    * list.removeFirst() / list.removeLast() → O(1).

🔹 3. Get Element
* ArrayList
    * list.get(index) → direct access → O(1).
* LinkedList
    * list.get(index) → sequential traversal → O(n).

🔹 4. Size
* Both ArrayList and LinkedList maintain a size variable internally.
* list.size() → O(1) in both.

🔹 5. First and Last Elements
* ArrayList
    * list.get(0) → first element.
    * list.get(list.size() - 1) → last element.
    * Both are O(1).
* LinkedList
    * list.getFirst() / list.getLast() → direct methods → O(1).

🔹 6. Sorting
* Both support sorting via Collections.sort(list) or list.sort(Comparator).
* Sorting complexity is O(n log n) for both (uses TimSort internally).

🔹 7. Transforming (Iteration / Mapping)
* ArrayList
    * Iteration with for-each or iterator() is faster (cache-friendly, contiguous memory).
* LinkedList
    * Iteration is slower (pointer chasing).
Example (transform all elements to uppercase):
list.replaceAll(e -> e.toUpperCase());

🔹 Summary Table
Operation	ArrayList	LinkedList
Add (end)	O(1) amortized	O(1)
Add (index)	O(n) (shift required)	O(n) (traversal)
Remove (end)	O(1) amortized	O(1)
Remove (index)	O(n)	O(n)
Get (index)	O(1)	O(n)
Size	O(1)	O(1)
First element	O(1)	O(1)
Last element	O(1)	O(1)
Sorting	O(n log n)	O(n log n)
Iteration	Faster (cache-friendly)	Slower
🔹 When to Use?
* ArrayList → Best for frequent reads and appending.
* LinkedList → Best for frequent insertions/deletions at start/middle.


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // 1. For loop with index
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + " -> " + list.get(i));
        }

        // 2. Enhanced for loop (for-each)
        for (String s : list) {
            System.out.println("For-each: " + s);
        }

        // 3. Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }

        // 4. ListIterator (forward & backward)
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println("ListIterator forward: " + lit.next());
        }
        while (lit.hasPrevious()) {
            System.out.println("ListIterator backward: " + lit.previous());
        }

        // 5. forEach with lambda
        list.forEach(s -> System.out.println("Lambda: " + s));

        // 6. Stream API
        list.stream().forEach(System.out::println);
    }
}

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedListIteration {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        // 1. For loop with index
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + " -> " + list.get(i));
        }

        // 2. Enhanced for loop (for-each)
        for (String s : list) {
            System.out.println("For-each: " + s);
        }

        // 3. Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }

        // 4. ListIterator (forward & backward)
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println("ListIterator forward: " + lit.next());
        }
        while (lit.hasPrevious()) {
            System.out.println("ListIterator backward: " + lit.previous());
        }

        // 5. forEach with lambda
        list.forEach(s -> System.out.println("Lambda: " + s));

        // 6. Stream API
        list.stream().forEach(System.out::println);
    }
}

import java.util.*;

public class CustomSortExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Kiwi");
        list.add("Mango");

        // Custom sort: sort by length of string
        Collections.sort(list, (a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println("Sorted by length: " + list);
    }
}

import java.util.*;

public class CustomSortDesc {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Custom sort: descending order
        numbers.sort((a, b) -> b - a);

        System.out.println("Descending order: " + numbers);
    }
}

import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class CustomSortObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 90));

        // Custom sort: by marks (ascending)
        students.sort((s1, s2) -> Integer.compare(s1.marks, s2.marks));

        System.out.println("Sorted by marks: " + students);

        // Custom sort: by name (alphabetical)
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));

        System.out.println("Sorted by name: " + students);
    }
}

**/

