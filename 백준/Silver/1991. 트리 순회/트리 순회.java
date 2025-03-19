import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, String> tree;
    static Map<Integer, List<Integer>> treeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        tree = new HashMap<>();
        tree.put(1, "A");

        treeMap = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int index = map.get(input[0]);
            int left = index * 2;
            int right = index * 2 + 1;

            List<Integer> list = treeMap.getOrDefault(index, new ArrayList<>());

            if(!input[1].equals(".")) {
                map.put(input[1], left);
                tree.put(left, input[1]);
                list.add(left);
            }
            if(!input[2].equals(".")) {
                map.put(input[2], right);
                tree.put(right, input[2]);
                list.add(right);
            }

            treeMap.put(index, list);
        }

        answer.append(preorder(1, new StringBuilder())).append("\n")
                .append(inorder(1, new StringBuilder())).append("\n")
                .append(postorder(1, new StringBuilder())).append("\n");

        System.out.println(answer);
    }

    private static String preorder(int index, StringBuilder str) {
        int left = index * 2;
        int right = index * 2 + 1;

        str.append(tree.get(index));
        if(tree.containsKey(left)) preorder(left, str);
        if(tree.containsKey(right)) preorder(right, str);

        return str.toString();
    }

    private static String inorder(int index, StringBuilder str) {
        int left = index * 2;
        int right = index * 2 + 1;

        if(tree.containsKey(left)) inorder(left, str);
        str.append(tree.get(index));
        if(tree.containsKey(right)) inorder(right, str);

        return str.toString();
    }

    private static String postorder(int index, StringBuilder str) {
        int left = index * 2;
        int right = index * 2 + 1;

        if(tree.containsKey(left)) postorder(left, str);
        if(tree.containsKey(right)) postorder(right, str);
        str.append(tree.get(index));

        return str.toString();
    }
}
