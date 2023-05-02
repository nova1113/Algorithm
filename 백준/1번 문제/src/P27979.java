import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P27979 {
    public static void main(String[] args) {
        // main 메소드에서 실행할 코드를 작성합니다.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt(); // 정수 입력
            list.add(num); // 리스트에 정수 추가
        }

        // System.out.println(list.size());
        System.out.println(solve(list, count));
    }

    private static int solve(List<Integer> list, int count){
        if (list.size() <= 1) {
            return count;            
        }
        // System.out.println(list);

        if (isSorted(list)){
            return count;
        }
        else {
            list = substractMin(list);            
            return solve(list, ++count);
        }

    }
    private static boolean isSorted(List<Integer> list){
        boolean result = true;

        for (int i  = 1; i < list.size(); i++){
            if(list.get(i - 1) <= list.get(i)){
                result = (result && true);
            }
            else{
                return false;
            }
        }
        return result;
    }

    private static List<Integer> substractMin(List<Integer> list) {
        int minIndex = 0;
        int minValue = list.get(0);
        Hashtable<Integer, Stack<Integer>> hashtable = new Hashtable<>();
    
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if (list.get(i) < minValue) {
                minValue = list.get(i);
                minIndex = i;
            }
        }
    
        list.remove(minIndex);
        return list;
    }
}