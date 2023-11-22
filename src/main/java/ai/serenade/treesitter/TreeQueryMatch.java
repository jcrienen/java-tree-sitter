package ai.serenade.treesitter;

public class TreeQueryMatch {

    int id;
    int pattern_index;
    int capture_count;
    TreeQueryCapture captures;

    public TreeQueryMatch() {
    }

    public int getId() {
        return id;
    }

    public int getCapture_count() {
        return capture_count;
    }

    public int getPattern_index() {
        return pattern_index;
    }

    public TreeQueryCapture getCaptures() {
        return captures;
    }

    public Node getNode() {
        return captures.getNode();
    }

    public class TreeQueryCapture {
        Node node;
        int index;

        public TreeQueryCapture() {

        }

        public int getIndex() {
            return index;
        }

        public Node getNode() {
            return node;
        }
    }

}


