package api.concurrency;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RequestBuilder {
    public static final HttpClient httpClient = HttpClient.newHttpClient();
    public static final Gson gson = new Gson();
    public static JsonObject getJsonFromApi(String url) throws IOException, InterruptedException {
        long startTime = 0;
        long endTime  = 0;
        double apiResponseTime = 0;
        startTime = System.nanoTime();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().header("Accept","application/json").build();
        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200){
            endTime = System.nanoTime();
            apiResponseTime = (endTime - startTime)/1000000000.0;
            System.out.println("Start time: "+startTime);
            System.out.println("End time: "+endTime);
            System.out.println("Api response time:"+apiResponseTime);
            return  gson.fromJson(response.body(), JsonObject.class);
        }else{
            System.err.println("Failed to fetch data status code: "+response.statusCode());
            return null;
        }
    }

    public static  void makeRequest(int id){
        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
        try{
            JsonObject jsonResponse = getJsonFromApi(url);
            if(jsonResponse != null){
                System.out.println(Thread.currentThread().getName()+" Response Received :"+jsonResponse.toString());
            }else{
                System.out.println(Thread.currentThread().getName()+"  No record found with ID: "+id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("hello world..");
        List<Integer> list  = Arrays.asList(1,3,2,4,5,6,7,8,9,10,12,23,11);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        try{
            for(Integer record:list){
                final Integer taskRecord = record;
                executor.submit(()->makeRequest(taskRecord));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }



    }
}
