import java.lang.annotation.Documented;

public class TestJob {

    public static void main(String[] args) {
        
    }

    @Abc
    int abc() {
        return 1;
    }
}


@Documented
 @interface Abc {

}

