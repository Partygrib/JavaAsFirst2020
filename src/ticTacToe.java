import java.util.*;

public class ticTacToe {
    private final char pusto = ' ';
    private final char k = 'x';
    private final char o = 'o';
    public int raz;
    public char[][] pole;
    public ticTacToe(Integer r) {
        raz = r;
        if (raz < 1) throw new IllegalArgumentException();
        pole = new char[raz][raz];
    }
    public void inPole() {
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                pole[i][j] = pusto;
            }
        }
    }
    public void printPole() {
        for (int i = 0;i < raz;i++)
            for (int j = 0;j < raz;j++)
                System.out.print(pole[i][j] + " ");
            System.out.println();
    }
    public void putK(Integer x, Integer y) {
        pole[x][y] = k;
    }
    public void putO(Integer x, Integer y) {
        pole[x][y] = o;
    }
    public void clear(Integer x, Integer y) {
        pole[x][y] = pusto;
    }
    public LinkedList<String> findK() {
        int s;
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        s = 0;
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (pole[i][j] == k)
                    list1.add(String.format("%d;%d", i, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (pole[j][i] == k)
                    list1.add(String.format("%d;%d", j, i));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (pole[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (pole[j][s] == k)
                    list1.add(String.format("%d;%d", j, s));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                if (pole[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                if (pole[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        return list2;
    }
    public LinkedList<String> findO() {
        int s;
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        s = 0;
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (pole[i][j] == o)
                    list1.add(String.format("%d;%d", i, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (pole[j][i] == o)
                    list1.add(String.format("%d;%d", j, i));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (pole[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (pole[j][s] == o)
                    list1.add(String.format("%d;%d", j, s));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                if (pole[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                if (pole[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        return list2;
    }
}
