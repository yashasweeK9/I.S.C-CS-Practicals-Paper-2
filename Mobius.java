public class Mobius {
    private int n, result, factors;
    private boolean duplicate, isValidInput;
    private String factorStr;

    Mobius(int n) {
        this.n = n;
        factors = 0;
        duplicate = false;
        factorStr = "";
        setValidity();
        if (isValidInput)
            getMobius();
    }

    private void setValidity() {
        if (n > 0)
            isValidInput = true;
        else
            isValidInput = false;
    }

    private void getMobius() {
        calculate();
        if (n == 1)
            result = 1;
        else if (duplicate)
            result = 0;
        else
            result = (factors % 2 == 0) ? 1 : -1;
    }

    private void calculate() {
        int save = factorize(n, 2);
        for (int i = 3; save != 1; i += 2) {
            save = factorize(save, i);
        }
    }

    private int factorize(int state, int divisor) {
        int counter = 0;
        while (state % divisor == 0) {
            factorStr += (divisor + " x ");
            counter++;
            state /= divisor;
        }
        if (counter > 1)
            duplicate = true;
        factors += counter;
        return state;
    }

    public String toString() {
        if (!isValidInput)
            return "INVALID INPUT!";
        String output = "OUTPUT:\t";
        if (n == 1)
            output += "1 = 1\n\tNO PRIME FACTORS";
        else {

            factorStr = factorStr.substring(0, factorStr.length() - 2);
            output += (n + " = " + factorStr + "\n\t");
            output += ((duplicate) ? "DUPLICATE PRIME FACTORS" : ("NUMBER OF DISTINCT PRIME FACTORS = " + factors));
        }
        output += "\n\tM(" + n + ") = " + result;
        return output;
    }
}