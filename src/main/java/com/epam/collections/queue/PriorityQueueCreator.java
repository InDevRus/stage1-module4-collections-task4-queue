package com.epam.collections.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        var queue = new PriorityQueue<>(Comparator.<String>naturalOrder().reversed());
        queue.addAll(firstList);
        queue.addAll(secondList);
        return queue;
    }
}
