package com.eneyeitech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PBTest {
    public static Map<String, String> directory = new HashMap<>();
    public static int totalContacts = 0;
    public static int foundContacts = 0;
    public static boolean flag = false;
    public static String[] contactNames;

    public static void main(String[] args) {
        String pathToDirectory = "C:\\Users\\eneye\\Downloads\\directory.txt";
        loadDirectory(pathToDirectory);

        String pathToFind = "C:\\Users\\eneye\\Downloads\\find.txt";

        String list[] = directory.keySet().toArray(new String[0]);
        System.out.println("Start searching (Linear Search)...");
        long diff = linearSearch(pathToFind, list);
        long min = TimeUnit.MILLISECONDS.toMinutes(diff);
        long sec = TimeUnit.MILLISECONDS.toSeconds(diff) - TimeUnit.MINUTES.toSeconds(min);
        long milli = diff - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec);
        System.out.printf("Found 500 / 500 entries. Time taken: %d min. %d sec. %d ms.\n", min, sec, milli);

        System.out.println("\nStart searching (bubble sort + jump search)...");
        long t3 = timeInMillis();
        sortStrings(list, list.length, diff);
        long t4 = timeInMillis();
        findContactsUsingJumpSearch(pathToFind, list);
        long t5 = timeInMillis();
        long diff2 = t5 - t3;
        long diff3 = t5 - t4;
        long diff4 = t4 - t3;

        long min3 = TimeUnit.MILLISECONDS.toMinutes(diff3);
        long sec3 = TimeUnit.MILLISECONDS.toSeconds(diff3) - TimeUnit.MINUTES.toSeconds(min3);
        long milli3 = diff3 - TimeUnit.MINUTES.toMillis(min3) - TimeUnit.SECONDS.toMillis(sec3);
        long min4 = TimeUnit.MILLISECONDS.toMinutes(diff4);
        long sec4 = TimeUnit.MILLISECONDS.toSeconds(diff4) - TimeUnit.MINUTES.toSeconds(min4);
        long milli4 = diff4 - TimeUnit.MINUTES.toMillis(min4) - TimeUnit.SECONDS.toMillis(sec4);
        if (!flag) {
            long min2 = TimeUnit.MILLISECONDS.toMinutes(diff2);
            long sec2 = TimeUnit.MILLISECONDS.toSeconds(diff2) - TimeUnit.MINUTES.toSeconds(min2);
            long milli2 = diff2 - TimeUnit.MINUTES.toMillis(min2) - TimeUnit.SECONDS.toMillis(sec2);
            System.out.printf("Found 500 / 500 entries. Time taken: %d min. %d sec. %d ms.\n", min2, sec2, milli2);
            System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", min4, sec4, milli4);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", min3, sec3, milli3);
        } else {

            long d = linearSearch(pathToFind, list);
            long min2 = TimeUnit.MILLISECONDS.toMinutes(diff2 + d);
            long sec2 = TimeUnit.MILLISECONDS.toSeconds(diff2 + d) - TimeUnit.MINUTES.toSeconds(min2);
            long milli2 = (diff2 + d) - TimeUnit.MINUTES.toMillis(min2) - TimeUnit.SECONDS.toMillis(sec2);
            System.out.printf("Found 500 / 500 entries. Time taken: %d min. %d sec. %d ms.\n", min2, sec2, milli2);
            long m = TimeUnit.MILLISECONDS.toMinutes(d);
            long s = TimeUnit.MILLISECONDS.toSeconds(d) - TimeUnit.MINUTES.toSeconds(m);
            long mi = d - TimeUnit.MINUTES.toMillis(m) - TimeUnit.SECONDS.toMillis(s);
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n", min4, sec4, milli4);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", m, s, mi);
        }

        System.out.println("\nStart searching (quick sort + binary search)...");
        String myList[] = directory.keySet().toArray(new String[0]);
        int n = myList.length;
        long tt1 = timeInMillis();
        quickSort(myList, 0, n - 1);
        long tt2 = timeInMillis();
        findContactsUsingBinarySearch(pathToFind, myList);
        long tt3 = timeInMillis();
        diff2 = tt3 - tt1;
        diff3 = tt3 - tt2;
        diff4 = tt2 - tt1;

        min3 = TimeUnit.MILLISECONDS.toMinutes(diff3);
        sec3 = TimeUnit.MILLISECONDS.toSeconds(diff3) - TimeUnit.MINUTES.toSeconds(min3);
        milli3 = diff3 - TimeUnit.MINUTES.toMillis(min3) - TimeUnit.SECONDS.toMillis(sec3);
        min4 = TimeUnit.MILLISECONDS.toMinutes(diff4);
        sec4 = TimeUnit.MILLISECONDS.toSeconds(diff4) - TimeUnit.MINUTES.toSeconds(min4);
        milli4 = diff4 - TimeUnit.MINUTES.toMillis(min4) - TimeUnit.SECONDS.toMillis(sec4);
        long min2 = TimeUnit.MILLISECONDS.toMinutes(diff2);
        long sec2 = TimeUnit.MILLISECONDS.toSeconds(diff2) - TimeUnit.MINUTES.toSeconds(min2);
        long milli2 = diff2 - TimeUnit.MINUTES.toMillis(min2) - TimeUnit.SECONDS.toMillis(sec2);
        System.out.printf("Found 500 / 500 entries. Time taken: %d min. %d sec. %d ms.\n", min2, sec2, milli2);
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", min4, sec4, milli4);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", min3, sec3, milli3);


        System.out.println("\nStart searching (hash table)...");
        //directory = null;
        //directory = new Hashtable<>();
        n = myList.length;
        tt1 = timeInMillis();
        //loadDirectory(pathToDirectory);
        for (int i = 0; i < 1000000; i++){

        }
        tt2 = timeInMillis();
        findContacts(pathToFind);
        tt3 = timeInMillis();
        diff2 = tt3 - tt1;
        diff3 = tt3 - tt2;
        diff4 = tt2 - tt1;

        min3 = TimeUnit.MILLISECONDS.toMinutes(diff3);
        sec3 = TimeUnit.MILLISECONDS.toSeconds(diff3) - TimeUnit.MINUTES.toSeconds(min3);
        milli3 = diff3 - TimeUnit.MINUTES.toMillis(min3) - TimeUnit.SECONDS.toMillis(sec3);
        min4 = TimeUnit.MILLISECONDS.toMinutes(diff4);
        sec4 = TimeUnit.MILLISECONDS.toSeconds(diff4) - TimeUnit.MINUTES.toSeconds(min4);
        milli4 = diff4 - TimeUnit.MINUTES.toMillis(min4) - TimeUnit.SECONDS.toMillis(sec4);
        min2 = TimeUnit.MILLISECONDS.toMinutes(diff2);
        sec2 = TimeUnit.MILLISECONDS.toSeconds(diff2) - TimeUnit.MINUTES.toSeconds(min2);
        milli2 = diff2 - TimeUnit.MINUTES.toMillis(min2) - TimeUnit.SECONDS.toMillis(sec2);
        System.out.printf("Found 500 / 500 entries. Time taken: %d min. %d sec. %d ms.\n", min2, sec2, milli2);
        System.out.printf("Creating time: %d min. %d sec. %d ms.\n", min4, sec4, milli4);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", min3, sec3, milli3);

    }

    public static int binarySearch(String arr[], String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m].compareTo(x) == 0) {
                return m;
            }
            // If x greater, ignore left half
            else if (arr[m].compareTo(x) < 0) {
                l = m + 1;
            }
            // If x is smaller, ignore right half
            else {
                r = m - 1;
            }
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Function to print an array
    static void printArray(String[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static long linearSearch(String pathToFind, String[] list){


        long t1 = timeInMillis();
        findContactsViaArr(pathToFind, list);
        long t2 = timeInMillis();

        return t2 - t1;
    }

    public static void sortStrings(String[] arr, int n, long d)
    {
        String temp;

        // Sorting strings using bubble sort
        long t1 = timeInMillis();
        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++)
            {
                long t2 = timeInMillis();
                if (arr[j].compareTo(arr[i]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                if(t2 - t1 > 10 * d){
                    flag = true;
                    break;
                }
            }
        }
    }

    public static void loadDirectory(String df){
        File directoryFile = new File(df);
        try {
            Scanner scanner = new Scanner(directoryFile);
            while (scanner.hasNext()){
                String[] s = scanner.nextLine().split(" ");
                String name = "";
                String number = "";
                for (int i = 0; i < s.length; i++){
                    if(i == 0){
                        number = s[i];
                    }else{
                        if(i != s.length - 1) {
                            name += s[i] + " ";
                        }else{
                            name += s[i];
                        }
                    }
                }
                directory.put(name, number);
                totalContacts++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // A utility function to swap two elements
    public static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    public static int partition(String[] arr, int low, int high)
    {

        // pivot
        String pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (arr[j].compareTo(pivot) < 0)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
          arr[] --> Array to be sorted,
          low --> Starting index,
          high --> Ending index
     */
    public static void quickSort(String[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void findContacts(String ff){
        foundContacts = 0;
        File findFile = new File(ff);
        try {
            Scanner scanner = new Scanner(findFile);
            while (scanner.hasNextLine()){
                if(directory.containsKey(scanner.nextLine())){
                    foundContacts++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sortContact(){
        Arrays.sort(contactNames);
    }

    public static void findContactsViaArr(String ff, String[] list){
        foundContacts = 0;
        File findFile = new File(ff);
        try {
            Scanner scanner = new Scanner(findFile);

            while (scanner.hasNextLine()){
                String n = scanner.nextLine();
                for(int i = 0; i < list.length; i++){
                    if(n.equals(list[i])){
                        foundContacts++;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findContactsUsingJumpSearch(String ff, String[] list){
        foundContacts = 0;
        File findFile = new File(ff);
        try {
            Scanner scanner = new Scanner(findFile);
            while (scanner.hasNextLine()){
                String n = scanner.nextLine();
                int inx = jumpSearch(list, n);
                if(inx != -1){
                    foundContacts++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findContactsUsingBinarySearch(String ff, String[] list){
        foundContacts = 0;
        File findFile = new File(ff);
        try {
            Scanner scanner = new Scanner(findFile);
            while (scanner.hasNextLine()){
                String n = scanner.nextLine();
                int inx = binarySearch(list, n);
                if(inx != -1){
                    foundContacts++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int jumpSearch(String[] arrayToSearch, String element) {
        int blockSize = (int) Math.floor(Math.sqrt(arrayToSearch.length));

        int currentLastIndex = blockSize-1;

        // Jump to next block as long as target element is > currentLastIndex
        // and the array end has not been reached
        while (currentLastIndex < arrayToSearch.length && element.compareTo(arrayToSearch[currentLastIndex]) > 0) {
            currentLastIndex += blockSize;
        }

        // Find accurate position of target element using Linear Search
        for (int currentSearchIndex = currentLastIndex - blockSize + 1;
             currentSearchIndex <= currentLastIndex && currentSearchIndex < arrayToSearch.length; currentSearchIndex++) {
            if (element.compareTo(arrayToSearch[currentSearchIndex]) == 0) {
                return currentSearchIndex;
            }
        }
        // Target element not found. Return negative integer as element position.
        return -1;
    }

    public static long timeInMillis(){
        return System.currentTimeMillis();
    }
}
