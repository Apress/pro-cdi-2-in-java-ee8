package org.omnifaces.procdi.events.generic;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StringList implements List<String> {

	private final List<String> list;

	public StringList(List<String> list) {
		this.list = list;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<String> iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean add(String s) {
		return list.add(s);
	}

	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		return list.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	@Override
	public void replaceAll(UnaryOperator<String> operator) {
		list.replaceAll(operator);
	}

	@Override
	public void sort(Comparator<? super String> c) {
		list.sort(c);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean equals(Object o) {
		return list.equals(o);
	}

	@Override
	public int hashCode() {
		return list.hashCode();
	}

	@Override
	public String get(int index) {
		return list.get(index);
	}

	@Override
	public String set(int index, String element) {
		return list.set(index, element);
	}

	@Override
	public void add(int index, String element) {
		list.add(index, element);
	}

	@Override
	public String remove(int index) {
		return list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<String> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Spliterator<String> spliterator() {
		return list.spliterator();
	}

	@Override
	public boolean removeIf(Predicate<? super String> filter) {
		return list.removeIf(filter);
	}

	@Override
	public Stream<String> stream() {
		return list.stream();
	}

	@Override
	public Stream<String> parallelStream() {
		return list.parallelStream();
	}

	@Override
	public void forEach(Consumer<? super String> action) {
		list.forEach(action);
	}

	@Override
	public String toString() {
		return "Wrapped string: " + list.toString();
	}
}
