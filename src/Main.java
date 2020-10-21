import com.mathAdditional.Exceptions.InvalidValue;
import com.mathAdditional.SecondDegreeFunction;

public class Main {
    public static void main(String[] args) throws InvalidValue {

        double a = 1;
        double b = 9;
        double c = -10;

        SecondDegreeFunction sdf = new SecondDegreeFunction(a, b, c);

        System.out.println(sdf);
    }
}
