//import java.util.Stack;
//
//class BrowserHistory {
//    Stack<String> undo;
//    Stack<String> redo;
//
//    public BrowserHistory(String homepage) {
//        undo = new Stack<>();
//        undo.push(homepage);
//        redo = new Stack<>();
//    }
//
//    public void visit(String url) {
//        undo.push(url);
//        redo.clear();
//        System.out.println("Visited: " + url);
//    }
//
//    public String back(int steps) {
//        for (int i = 0; i < steps && undo.size() > 1; i++) {
//            redo.push(undo.pop());
//        }
//        System.out.println("Back to: " + undo.peek());
//        return undo.peek();
//    }
//
//    public String forward(int steps) {
//        for (int i = 0; i < steps && !redo.isEmpty(); i++) {
//            undo.push(redo.pop());
//        }
//        System.out.println("Forward to: " + undo.peek());
//        return undo.peek();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Initialize browser history with homepage
//        BrowserHistory browserHistory = new BrowserHistory("google.com");
//
//        // Visit new websites
//        browserHistory.visit("youtube.com");
//        browserHistory.visit("facebook.com");
//        browserHistory.visit("twitter.com");
//
//        // Go back in history
//        browserHistory.back(1);  // Should go back to facebook.com
//        browserHistory.back(1);  // Should go back to youtube.com
//
//        // Move forward in history
//        browserHistory.forward(1);  // Should go to facebook.com
//
//        // Visit a new page, which clears the forward history
//        browserHistory.visit("linkedin.com");
//
//        // Attempt to move forward (should not work)
//        browserHistory.forward(2);  // Should stay at linkedin.com
//
//        // Go back multiple steps
//        browserHistory.back(2);  // Should go back to google.com
//    }
//}
