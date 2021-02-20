package task3;

import java.util.*;

public class ListSync<E> implements List<E> {
    private volatile List<E> list = new ArrayList();

    @Override
    synchronized public int size() {
        return list.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    synchronized public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return list.toArray();
    }

    @Override
    synchronized public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    synchronized public boolean add(E e) {
        return list.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection<? extends E> c) {
        return list.addAll(index, c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    synchronized public void clear() {
        list.clear();
    }

    @Override
    synchronized public E get(int index) {
        return list.get(index);
    }

    @Override
    synchronized public E set(int index, E element) {
        return list.set(index, element);
    }

    @Override
    synchronized public void add(int index, E element) {
        list.add(index, element);
    }

    @Override
    synchronized public E remove(int index) {
        return list.remove(index);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    synchronized public ListIterator<E> listIterator() {
        return list.listIterator();
    }

    @Override
    synchronized public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    synchronized public List<E> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
