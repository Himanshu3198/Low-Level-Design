package FileSystem;

import java.util.ArrayList;
import java.util.List;

/* ================================
   CORE NODE
   ================================ */
abstract class FileSystemNode {

    protected String name;
    protected Directory parent;

    public FileSystemNode(String name) {
        this.name = name;
    }

    public abstract long getSize();
    public abstract void print(String indent);

    public void rename(String newName) {
        System.out.println("Renaming " + this.name + " to " + newName);
        this.name = newName;
    }

    public void delete() {
        if (parent != null) {
            parent.remove(this);
            System.out.println(this.name + " deleted successfully");
        }
    }

    public void moveTo(Directory target) {
        if (parent != null) {
            parent.remove(this);
        }
        target.add(this);
        System.out.println(this.name + " moved to directory " + target.name);
    }
}

/* ================================
   FILE (LEAF)
   ================================ */
class File extends FileSystemNode {

    private long size;
    private String extension;

    public File(String name, long size, String extension) {
        super(name);
        this.size = size;
        this.extension = extension;
    }

    @Override
    public long getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + name + "." + extension + " (" + size + " bytes)");
    }
}

/* ================================
   DIRECTORY (COMPOSITE)
   ================================ */
class Directory extends FileSystemNode {

    private List<FileSystemNode> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void add(FileSystemNode node) {
        node.parent = this;
        children.add(node);
        System.out.println("Added [" + node.name + "] to directory [" + this.name + "]");
    }

    public void remove(FileSystemNode node) {
        children.remove(node);
        System.out.println("Removed [" + node.name + "] from directory [" + this.name + "]");
    }

    public List<FileSystemNode> getChildren() {
        return children;
    }

    @Override
    public long getSize() {
        long size = 0;
        for (FileSystemNode child : children) {
            size += child.getSize();
        }
        return size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "[DIR] " + name);
        for (FileSystemNode child : children) {
            child.print(indent + "  ");
        }
    }
}

/* ================================
   FILTER SYSTEM
   ================================ */
interface Filter {
    boolean apply(File file);
}

class FilterByExtension implements Filter {

    private String extension;

    public FilterByExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean apply(File file) {
        return file.getExtension().equalsIgnoreCase(extension);
    }
}

class SizeFilter implements Filter {

    private long minSize;
    private long maxSize;

    public SizeFilter(long minSize, long maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean apply(File file) {
        return file.getSize() >= minSize && file.getSize() <= maxSize;
    }
}

class AndFilter implements Filter {

    private List<Filter> filters;

    public AndFilter(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean apply(File file) {
        for (Filter filter : filters) {
            if (!filter.apply(file)) return false;
        }
        return true;
    }
}

/* ================================
   SEARCHER (DFS)
   ================================ */
class FileSearcher {

    public static List<File> search(Directory root, Filter filter) {
        List<File> result = new ArrayList<>();
        dfs(root, filter, result);
        return result;
    }

    private static void dfs(FileSystemNode node, Filter filter, List<File> result) {

        if (node instanceof File) {
            File file = (File) node;
            if (filter.apply(file)) {
                result.add(file);
            }
        } else {
            Directory dir = (Directory) node;
            for (FileSystemNode child : dir.getChildren()) {
                dfs(child, filter, result);
            }
        }
    }
}

/* ================================
   DEMO / SIMULATION
   ================================ */
public class FileSystemDemo {

    public static void main(String[] args) {

        System.out.println("===== FILE SYSTEM (UNIX STYLE) =====");

        Directory root = new Directory("hs-dir");
        Directory photos = new Directory("photos");
        Directory documents = new Directory("documents");
        Directory videos = new Directory("videos");

        root.add(photos);
        root.add(documents);
        root.add(videos);

        File f1 = new File("myphoto1", 500, "jpg");
        File f2 = new File("myphoto2", 400, "jpg");

        File f3 = new File("resume", 500, "pdf");
        File f4 = new File("offer_letter", 400, "pdf");

        File f5 = new File("movie1", 1500, "mp4");
        File f6 = new File("movie2", 800, "mp4");

        photos.add(f1);
        photos.add(f2);
        documents.add(f3);
        documents.add(f4);
        videos.add(f5);
        videos.add(f6);

        /* PRINT */
        System.out.println("\n--- INITIAL FILE SYSTEM ---");
        root.print(" ");

        /* RENAME */
        System.out.println("\n--- RENAME FILE ---");
        f3.rename("updated_resume");
        root.print(" ");

        /* MOVE */
        System.out.println("\n--- MOVE FILE ---");
        f2.moveTo(root);
        root.print(" ");

        /* DELETE */
        System.out.println("\n--- DELETE DIRECTORY (videos) ---");
        videos.delete();
        root.print(" ");

        /* FILTER */
        System.out.println("\n--- FILTER: PDF FILES ---");
        Filter pdfFilter = new FilterByExtension("pdf");
        List<File> pdfFiles = FileSearcher.search(root, pdfFilter);
        pdfFiles.forEach(f -> f.print(" "));

        System.out.println("\n--- FILTER: JPG FILES BETWEEN 300-600 BYTES ---");
        Filter jpgSizeFilter = new AndFilter(
                List.of(new FilterByExtension("jpg"), new SizeFilter(300, 600))
        );

        List<File> jpgFiles = FileSearcher.search(root, jpgSizeFilter);
        jpgFiles.forEach(f -> f.print(" "));

        System.out.println("\nTotal size of root: " + root.getSize() + " bytes");
    }
}