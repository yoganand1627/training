/**
 * Created on Jul 10, 2006 at 10:29:08 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.pagination;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@SuppressWarnings({"SuspiciousMethodCalls"})
public class PaginatedHibernateList<E> implements List<E>, RandomAccess, Serializable {
  /** This class delegates the implementation of List to this field. */
  private final List<E> listDelegate;

  /** A 1-based value storing the current page number. */
  private int pageNbr;

  /** Stores the current page size. */
  private int pageSize;

  /** Stores the total number of results. */
  private boolean moreDataAvailable = false;

  /**
   * Creates a paginated list with a set page size and number.
   *
   * @param pageSize The number of results on each page.
   * @param pageNbr  The page number of the current result (1-based).
   */
  public PaginatedHibernateList(List<E> resultsList, int pageSize, int pageNbr) {
    this.listDelegate = new ArrayList<E>(resultsList.size());
    this.pageSize = pageSize;
    this.pageNbr = pageNbr;
    this.listDelegate.addAll(resultsList);
    while (this.listDelegate.size() > pageSize) {
      this.moreDataAvailable = true;
      this.listDelegate.remove(this.listDelegate.size() - 1);
    }
  }

  public int getPageNbr() {
    return pageNbr;
  }

  public int getPageSize() {
    return pageSize;
  }

  public boolean isMoreDataAvailable() {
    return moreDataAvailable;
  }

  public String getBMoreDataInd() {
    return moreDataAvailable ? ArchitectureConstants.Y : ArchitectureConstants.N;
  }

  // *** Methods below here are used exclusively to implement List<E>. ***
  public boolean containsAll(Collection c) {
    return listDelegate.containsAll(c);
  }

  public boolean removeAll(Collection c) {
    return listDelegate.removeAll(c);
  }

  public boolean retainAll(Collection c) {
    return listDelegate.retainAll(c);
  }

  public String toString() {
    return listDelegate.toString();
  }

  public Iterator<E> iterator() {
    return listDelegate.iterator();
  }

  public ListIterator<E> listIterator() {
    return listDelegate.listIterator();
  }

  public ListIterator<E> listIterator(int index) {
    return listDelegate.listIterator(index);
  }

  public List<E> subList(int fromIndex, int toIndex) {
    return listDelegate.subList(fromIndex, toIndex);
  }

  public boolean equals(Object o) {
    if (o instanceof PaginatedHibernateList) {
      return super.equals(o);
    }
    return false;
  }

  public int hashCode() {
    return listDelegate.hashCode();
  }

  public int size() {
    return listDelegate.size();
  }

  public boolean isEmpty() {
    return listDelegate.isEmpty();
  }

  public boolean contains(Object elem) {
    return listDelegate.contains(elem);
  }

  public int indexOf(Object elem) {
    return listDelegate.indexOf(elem);
  }

  public int lastIndexOf(Object elem) {
    return listDelegate.lastIndexOf(elem);
  }

  public Object[] toArray() {
    return listDelegate.toArray();
  }

  public Object[] toArray(Object[] a) {
    return listDelegate.toArray(a);
  }

  public E get(int index) {
    return listDelegate.get(index);
  }

  public E set(int index, E element) {
    return listDelegate.set(index, element);
  }

  public boolean add(E o) {
    return listDelegate.add(o);
  }

  public void add(int index, E element) {
    listDelegate.add(index, element);
  }

  public E remove(int index) {
    return listDelegate.remove(index);
  }

  public boolean remove(Object o) {
    return listDelegate.remove(o);
  }

  public void clear() {
    listDelegate.clear();
  }

  public boolean addAll(Collection<? extends E> c) {
    return listDelegate.addAll(c);
  }

  public boolean addAll(int index, Collection<? extends E> c) {
    return listDelegate.addAll(index, c);
  }
}
