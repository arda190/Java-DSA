import java.util.*;

public class FSM {
    private Set<String> symbols = new HashSet<>();
    private Map<String, State> states = new LinkedHashMap<>();
    private String initialState = null;
    private Set<String> finalStates = new HashSet<>();
    private Map<String, Map<String, String>> transitions = new HashMap<>();

    public void addSymbol(String symbol) {
        symbol = symbol.toUpperCase();
        if (!symbol.matches("[a-zA-Z0-9]")) {
            System.out.println("Warning: Invalid symbol " + symbol);
            return;
        }
        if (!symbols.add(symbol)) {
            System.out.println("Warning: Symbol " + symbol + " was already declared");
        }
    }

    public void addState(String stateName) {
        stateName = stateName.toUpperCase();
        if (!stateName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Warning: Invalid state " + stateName);
            return;
        }
        if (!states.containsKey(stateName)) {
            states.put(stateName, new State(stateName, false));
            if (initialState == null) {
                initialState = stateName;
            }
        } else {
            System.out.println("Warning: State " + stateName + " was already declared");
        }
    }

    public void setInitialState(String stateName) {
        addState(stateName); // otomatik ekle
        initialState = stateName.toUpperCase();
    }

    public void addFinalState(String stateName) {
        addState(stateName); // otomatik ekle
        stateName = stateName.toUpperCase();
        finalStates.add(stateName);
        states.get(stateName).setFinal(true);
    }

    public void addTransition(String symbol, String from, String to) {
        symbol = symbol.toUpperCase();
        from = from.toUpperCase();
        to = to.toUpperCase();

        if (!symbols.contains(symbol)) {
            System.out.println("Error: Invalid symbol " + symbol);
            return;
        }
        if (!states.containsKey(from)) {
            System.out.println("Error: Invalid state " + from);
            return;
        }
        if (!states.containsKey(to)) {
            System.out.println("Error: Invalid state " + to);
            return;
        }

        transitions.putIfAbsent(from, new HashMap<>());
        Map<String, String> stateTransitions = transitions.get(from);

        if (stateTransitions.containsKey(symbol)) {
            System.out.println("Warning: Transition already exists for <" + symbol + "," + from + ">, will be overridden.");
        }
        stateTransitions.put(symbol, to);
    }
}