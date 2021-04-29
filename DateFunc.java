class DateFunc {
    private String MONTH[] = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
            "OCTOBER", "NOVEMBER", "DECEMBER" };
    private boolean isValidInput, isLeap;
    private String result;
    private int dayNo, year, dateAfter;

    DateFunc(int dayNo, int year, int dateAfter) {
        this.dayNo = dayNo;
        this.year = year;
        this.dateAfter = dateAfter;
        result = "OUTPUT:\n\t";
        isLeap = isLeap();
        isValidInput = setValidity();
        if (isValidInput)
            genDate();

    }

    private boolean setValidity() {
        if (year < 1000 || year > 9999)
            return false;
        if (dayNo > 366 || dayNo < 1)
            return false;
        if (!isLeap && dayNo == 366)
            return false;
        if (dateAfter < 1 || dateAfter > 100)
            return false;
        return true;
    }

    private boolean isLeap() {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }

    private void genDate() {
        toStrDate();
        result += "\n\tDATE AFTER " + dateAfter + " DAYS :\n\t";
        toStrDateAfterN();
    }

    private void toStrDate() {
        int day = 0;

        int dp[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

        if (isLeap)
            for (int i = 2; i < 13; i++)
                ++dp[i];

        int index = 12;

        while (index >= 0) {
            if (dayNo > dp[index]) {
                day = dayNo - dp[index];
                break;
            }
            index--;
        }

        result += day + ((day % 10 == 1) ? "ST" : ((day % 10 == 2) ? "ND" : (day % 10 == 3) ? "RD" : "TH")) + ". "
                + MONTH[index] + " " + year;

    }

    private void toStrDateAfterN() {
        dayNo = dayNo + dateAfter;
        int days = ((isLeap) ? 366 : 365);
        if (dayNo > days) {
            dayNo -= days;
            ++year;
            isLeap = isLeap();
        }
        toStrDate();
    }

    public String toString() {
        if (!isValidInput)
            result += "INVALID INPUT!";
        return result + "\n";
    }
}