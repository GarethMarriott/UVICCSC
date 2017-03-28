import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {

	public BSTMap () {
	}

	public boolean containsKey(K key) {
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		return null;
	}

	public List<Entry<K,V> >	entryList() {
		return null;
	}

	public void put (K key, V value) {
	}

	public int size() {
		return -1;
	}

	public void clear() {
	}

	public int getGetLoopCount() {
		return -1;
	}

	public int getPutLoopCount() {
		return -1;
	}

	public void resetGetLoops() {

	}
	public void resetPutLoops() {
	}
}
