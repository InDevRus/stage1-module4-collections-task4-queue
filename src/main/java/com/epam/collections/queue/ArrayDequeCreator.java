package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    private void disposeCard(Queue<Integer> source, Queue<Integer> destination) {
        destination.add(source.remove());
    }

    private void moveCards(Queue<Integer> playersCards, Deque<Integer> sharedCards) {
        if (playersCards.isEmpty()) {
            return;
        }

        playersCards.add(sharedCards.removeLast());
        disposeCard(playersCards, sharedCards);
        disposeCard(playersCards, sharedCards);
    }
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        var sharedCards = new ArrayDeque<Integer>();
        disposeCard(firstQueue, sharedCards);
        disposeCard(firstQueue, sharedCards);
        disposeCard(secondQueue, sharedCards);
        disposeCard(secondQueue, sharedCards);

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            moveCards(firstQueue, sharedCards);
            moveCards(secondQueue, sharedCards);
        }

        return sharedCards;
    }
}
