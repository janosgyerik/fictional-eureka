public class BubbleSort {
    public static void sort(String[] words) {
        for (int i = 0;  i < words.length - 1;  i++ ){
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareToIgnoreCase(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }
}
