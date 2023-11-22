package ai.serenade.treesitter;

import java.nio.charset.StandardCharsets;

public class TreeQuery implements AutoCloseable {
    private long pointer;
    private TreeQueryCursor cursor;
    TreeQuery(long pointer, TreeQueryCursor cursor) {
        this.pointer = pointer;
        this.cursor = cursor;
    }

    @Override
    public void close() {
        TreeSitter.treeQueryDelete(pointer);
    }

    public void execute(Node node) {
        TreeSitter.executeTreeQuery(cursor.pointer, this.pointer, node);
    }

    public Node gotoNextMatch() { return TreeSitter.treeQueryGoToNextMatch(pointer); }

    public static TreeQuery createTreeQuery(long language, String source, TreeQueryCursor cursor){
        byte[] bytes = source.getBytes(StandardCharsets.UTF_16LE);
        return new TreeQuery(TreeSitter.queryNew(language, bytes, bytes.length), cursor);
    }

    public static class TreeQueryCursor implements AutoCloseable {
        private long pointer;

        TreeQueryCursor(long pointer) {
            this.pointer = pointer;
        }

        public TreeQueryCursor() { this(TreeSitter.queryCursorNew()); }

        @Override
        public void close() {
            TreeSitter.treeQueryCursorDelete(pointer);
        }


    }

}
