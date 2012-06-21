package com.gsaex;

import java.util.HashMap;
import java.util.Map;

public class SimilarityMatrix {

    private Map<Character, Map<Character, Integer>> graph = new HashMap<Character, Map<Character, Integer>>();

    public int score(char firstBase, char secondBase) {
        if(!containsScoreFor(firstBase, secondBase)) {
            throw new BaseNotDefinedInMatrix();
        }
        return graph.get(firstBase).get(secondBase);
    }

    private boolean containsScoreFor(char firstBase, char secondBase) {
        return graph.containsKey(firstBase) && graph.get(firstBase).containsKey(secondBase);
    }

    public void addPairScore(char fromBase, char toBase, int score) {
        createAndAddScore(fromBase, toBase, score);
        createAndAddScore(toBase, fromBase, score);
    }

    private void createAndAddScore(char fromBase, char toBase, int score) {
        createEntryIfKeyDoesNotExists(fromBase);
        addScore(fromBase, toBase, score);
    }

    private void addScore(char fromBase, char toBase, int score) {
        graph.get(fromBase).put(toBase, score);
    }

    private void createEntryIfKeyDoesNotExists(char keyBase) {
        if(!graph.containsKey(keyBase)) {
            graph.put(keyBase, new HashMap<Character, Integer>());
        }
    }

    public class BaseNotDefinedInMatrix extends RuntimeException {
    }
}
