import java.util.*;
import java.util.function.Consumer;

public class CustomList <E> implements List <E>, RandomAccess{
    private Object[] _list = new Object[1];
    private int _size = 0;

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return new Iter();
    }

    public Object[] toArray() {
        return Arrays.copyOf(_list, _size);
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        if(_size >= _list.length)
            expand();

        _list[_size++] = e;

        return true;
    }

    private void expand() {
        int newLen = Math.min((_list.length << 1) + 1, Integer.MAX_VALUE - 8);
        _list = Arrays.copyOf(_list, newLen);
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public E get(int index) {
        checkIndex(index);
        return (E) _list[index];
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        _list[index] = element;
        return oldValue;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= _size)
            throw new IndexOutOfBoundsException("Index: " + index + " of Size: " + _size);
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return new IterList(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new IterList(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class Iter implements Iterator<E>{
        protected int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < _size;
        }

        @Override
        public E next() {
            return get(currentIndex++);
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
    private class IterList extends Iter implements ListIterator<E>{
        public IterList(int index) {
            checkIndex(index);
            currentIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public E previous() {
            return get(--currentIndex);
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void set(E e) {
            CustomList.this.set(currentIndex - 1, e);
        }

        @Override
        public void add(E e) {

        }
    }
}
