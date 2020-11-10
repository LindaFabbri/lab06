package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
	
	private Map<N, Set<N>> myMap;
	private List<N> pathList ;
	
	public GraphImpl() {
		myMap = new HashMap<>();
	}
	
	public void addNode(N node) {
		if(!myMap.containsKey(node) && node != null) {
			myMap.put(node, new HashSet<>());
		}
		
	}

	
	public void addEdge(N source, N target) {
		
		if(source != null && target != null) {
			myMap.get(source).add(target);
		}
		
	}

	
	public Set<N> nodeSet() {
		
		return myMap.keySet();
	}

	
	public Set<N> linkedNodes(N node) {
		
		return Collections.unmodifiableSet(myMap.get(node));
	}

	
	public List<N> getPath(N source, N target) {
		pathList = new ArrayList<>();
		pathList.add(source);  //sicuramente la mia lista parte da source
		for(N nodoN : myMap.get(source)) {
			//pathList.addAll(getList(source, nodiN, myMap.get(source), target));
			pathFinder(nodoN,target);
		}
		
		
		return pathList;
	}
	
	private void pathFinder(N node,N target) {
		if(node.equals(target)) {
			pathList.add(node);
		}else {
			
		}
	}
	
	/*private List<N> getList(N source, N sourceProv, Set<N> adiacenti, N target){
		List<N> listaProvvisoria = new ArrayList<>();
		if(sourceProv == target) {
			listaProvvisoria.add(sourceProv);
			return listaProvvisoria;
		}
		for(N nodiN : myMap.get(sourceProv)) {
			getList(source, nodiN, myMap.get(sourceProv), target);
		}
		return null;
	}*/
	
	

}
