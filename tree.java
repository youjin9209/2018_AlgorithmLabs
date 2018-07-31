/*
트리 순회
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
class Node {
    int left, right;
    Node (int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class Main {
    public static void preorder(Node[] tree, int x) {
        if (x == -1)
            return ;
        System.out.print((char)(x+'A'));
        preorder(tree, tree[x].left);
        preorder(tree, tree[x].right);
    }
    public static void inorder(Node[] tree, int x) {
        if (x == -1)
            return;
        inorder(tree, tree[x].left);
        System.out.print((char)(x+'A'));
        inorder(tree, tree[x].right);
    }
    public static void postorder (Node[] tree, int x) {
        if (x == -1)
            return;
        postorder(tree, tree[x].left);
        postorder(tree, tree[x].right);
        System.out.print((char)(x+'A'));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] tree = new Node[N];
        while (N-- > 0) {
            int x = sc.next().charAt(0) - 'A';
            char y = sc.next().charAt(0);
            char z = sc.next().charAt(0);
            int left = -1; // 말단 노드 
            int right = -1; // 말단 노드  
            if (y != '.') {
                left = y - 'A';
            }
            if (z != '.') {
                right = z - 'A';
            }
            tree[x] = new Node(left, right);
        }
        preorder(tree, 0);
        System.out.println();
        inorder(tree, 0);
        System.out.println();
        postorder(tree, 0);
        System.out.println();
    }
}
