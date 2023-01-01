package queue;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dozen Lee<br/>
 * 2023/1/2 1:26
 */
public class Queue01 {
    @Test
    public void test1801() {
        int[][] orders = new int[][]{{26, 7, 0}, {16, 1, 1}, {14, 20, 0}, {23, 15, 1}, {24, 26, 0}, {19, 4, 1}, {1, 1, 0}};
        System.out.println(getNumberOfBacklogOrders(orders));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = (int) 1e9 + 7;
        PriorityQueue<Pair<Integer, Integer>> sellBacklog = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        PriorityQueue<Pair<Integer, Integer>> buyBacklog = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (int[] order : orders) {
            if (order[2] == 0) { // buy
                if (!sellBacklog.isEmpty() && sellBacklog.peek().getKey() <= order[0]) {
                    int amount = order[1];
                    while (!sellBacklog.isEmpty() && sellBacklog.peek().getKey() <= order[0]) {
                        Pair<Integer, Integer> curPair = sellBacklog.poll();
                        if (amount == curPair.getValue()) {
                            amount = 0;
                            break;
                        } else if (amount < curPair.getValue()) {
                            sellBacklog.add(new Pair<>(curPair.getKey(), curPair.getValue() - amount));
                            amount = 0;
                            break;
                        } else {
                            amount -= curPair.getValue();
                        }
                    }
                    if (amount > 0) {
                        buyBacklog.add(new Pair<>(order[0], amount));
                    }
                } else {
                    buyBacklog.add(new Pair<>(order[0], order[1]));
                }
            } else if (order[2] == 1) { // sell
                if (!buyBacklog.isEmpty() && buyBacklog.peek().getKey() >= order[0]) {
                    int amount = order[1];
                    while (!buyBacklog.isEmpty() && buyBacklog.peek().getKey() >= order[0]) {
                        Pair<Integer, Integer> curPair = buyBacklog.poll();
                        if (amount == curPair.getValue()) {
                            amount = 0;
                            break;
                        } else if (amount < curPair.getValue()) {
                            buyBacklog.add(new Pair<>(curPair.getKey(), curPair.getValue() - amount));
                            amount = 0;
                            break;
                        } else {
                            amount -= curPair.getValue();
                        }
                    }
                    if (amount > 0) {
                        sellBacklog.add(new Pair<>(order[0], amount));
                    }
                } else {
                    sellBacklog.add(new Pair<>(order[0], order[1]));
                }
            }
        }
        int sum = 0;
        for (Pair<Integer, Integer> pair : sellBacklog) {
            sum = (sum + (pair.getValue() % MOD)) % MOD;
        }
        for (Pair<Integer, Integer> pair : buyBacklog) {
            sum = (sum + (pair.getValue() % MOD)) % MOD;
        }
        return sum;
    }
}
