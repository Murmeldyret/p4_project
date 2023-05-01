package postfix.semantics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/** List like implementation of a queue data structure */
public class QueueList<E> implements Queue<E>{

    private ArrayList<E> internalList;

    public QueueList() {
        internalList = new ArrayList<>();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return internalList.iterator();
    }

    @Override
    public Object[] toArray() {
        return internalList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalList.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return internalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return internalList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return internalList.retainAll(c);
    }

    @Override
    public void clear() {
        internalList.clear();
    }

    @Override
    public boolean add(E e) {
        return internalList.add(e);
    }

    @Override
    public boolean offer(E e) {
        return internalList.add(e);
    }

    @Override
    public E remove() {
        if (internalList == null || internalList.isEmpty()) {
            throw new NullPointerException("The queue is empty");
        }
        E res = internalList.get(0);
        internalList.remove(0);
        return res;
    }

    @Override
    public E poll() {
        E res;
        if (internalList != null || !internalList.isEmpty()) {
            res = internalList.get(0);
            internalList.remove(0);
        }
        else {
            res = null;
        }
        return res;
    }

    @Override
    public E element() {
        if(internalList == null || internalList.isEmpty()) {
            throw new NullPointerException("Queue is Empty");
        }
        return internalList.get(0);
    }

    @Override
    public E peek() {
        if (internalList == null || internalList.isEmpty()) {
            return null;
        }
        return internalList.get(0);
    }
    
}
