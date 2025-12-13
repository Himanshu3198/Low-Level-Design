///**
//for problem statement check -https://leetcode.com/problems/web-crawler/
// * // This is the HtmlParser's API interface.
// * // You should not implement it, or speculate about its implementation
// * interface HtmlParser {
// *     public List<String> getUrls(String url) {}
// * }
// */
//
//class Solution {
//
//    public void dfs(String startUrl,String hostName,HtmlParser htmlParser,Set<String>visited){
//
//        if(visited.contains(startUrl)) return;
//        visited.add(startUrl);
//        List<String>pageUrl = htmlParser.getUrls(startUrl);
//        for(String currUrl : pageUrl){
//            if(currUrl.startsWith(hostName)){
//                dfs(currUrl,hostName,htmlParser,visited);
//            }
//        }
//    }
//    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//
//        // List<String> childUrl  = htmlParser.getUrls
//         Set<String> visited = new HashSet<>();
//         String hostName = "http://"+startUrl.split("/")[2];
//         System.out.println(hostName);
//         dfs(startUrl,hostName,htmlParser,visited);
//
//        return new ArrayList<>(visited);
//    }
//}
