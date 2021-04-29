class EditStr {
    private boolean isValidInput;
    private String str, output;
    private char endChar;

    EditStr(String str) {
        this.str = str;
        output = "OUTPUT:\t";
        endChar = str.charAt(str.length() - 1);
        setValidity();
        if (isValidInput)
            genStr();
    }

    private void setValidity() {
        if (endChar != '.' && endChar != '?' && endChar != '!')
            isValidInput = false;
        else
            isValidInput = true;
    }

    private void genStr() {
        output += capitalize(str) + "\n";
        str = str.substring(0, str.length() - 1);
        sort();
        output += ("\t" + capitalize(str) + endChar);
    }

    private String capitalize(String inp) {
        return ((char) (inp.charAt(0) - 32)) + inp.substring(1, inp.length());
    }

    private void sort() {
        String repo[] = str.split(" ");
        int indexer[] = new int[repo.length];

        for (int i = 0; i < repo.length; i++) {
            indexer[i] = i;
        }

        for (int i = 0; i < indexer.length - 1; i++) {
            for (int j = 0; j < indexer.length - i - 1; j++) {
                if (repo[indexer[j]].length() > repo[indexer[j + 1]].length()) {
                    int temp = indexer[j];
                    indexer[j] = indexer[j + 1];
                    indexer[j + 1] = temp;
                }
            }
        }

        str = repo[indexer[0]];

        for (int i = 1; i < repo.length; i++) {
            str += " " + repo[indexer[i]];
        }
    }

    public String toString() {
        if (!isValidInput)
            return "INVALID INPUT!";
        return output;
    }
}