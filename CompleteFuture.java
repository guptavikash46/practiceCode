import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        
        CompletableFuture<String> futureObj = CompletableFuture.supplyAsync(() -> { 

            return "hello";
         });
        futureObj.thenAcceptAsync(val -> System.out.println(val)).join();
       //Thread.sleep(2000);
        
    }
}