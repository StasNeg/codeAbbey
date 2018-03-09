package task95SimpleLinearRegression;

/**
 * Created by Stanislav on 09.03.2018.
 */
public class Solutions {
    public static void main(String[] args) {
//        y = ax+b
//        we need to find a, b

//        xyAverage = average y(i) * x(i)
//        yAverage = average y(i)
//        xSquareAverage = average x(i) * x(i)
//        xAverage = average x(i)
//        a = (xyAverage - xAverage*yAverage) / (xSquareAverage - xAverage*xAverage)
//        b = yAverage - a*xAverage

        String[] data = {
                "1926: 102 259",
                "1927: 142 413",
                "1928: 134 391",
                "1929: 131 384",
                "1930: 131 395",
                "1931: 91 303",
                "1932: 64 307",
                "1933: 122 334",
                "1934: 135 391",
                "1935: 68 259",
                "1936: 51 219",
                "1937: 86 302",
                "1938: 58 238",
                "1939: 129 377",
                "1940: 115 400",
                "1941: 110 338",
                "1942: 118 363",
                "1943: 90 305",
                "1944: 135 391",
                "1945: 127 376",
                "1946: 61 245",
                "1947: 91 317",
                "1948: 77 261",
                "1949: 93 301",
                "1950: 126 371",
                "1951: 122 383",
                "1952: 125 375",
                "1953: 124 341",
                "1954: 104 315",
                "1955: 98 313",
                "1956: 93 318",
                "1957: 141 361",
                "1958: 134 390",
                "1959: 55 223",
                "1960: 86 290",
                "1961: 107 337",
                "1962: 57 209",
                "1963: 53 221",
                "1964: 66 258",
                "1965: 79 268",
                "1966: 112 346",
                "1967: 66 306",
                "1968: 77 305",
                "1969: 54 203",
                "1970: 76 278",
                "1971: 107 365",
                "1972: 107 380",
                "1973: 144 370",
                "1974: 57 238",
                "1975: 133 382",
                "1976: 148 365",
                "1977: 113 345",
                "1978: 69 267",
                "1979: 146 416",
                "1980: 84 311",
                "1981: 60 248",
                "1982: 146 381",
                "1983: 115 321",
                "1984: 144 377",
                "1985: 84 309",
                "1986: 86 311",
                "1987: 92 310",
                "1988: 93 300",
                "1989: 72 274",
                "1990: 136 367",
                "1991: 119 403",
                "1992: 79 248",
                "1993: 124 361",
                "1994: 57 234",
                "1995: 95 342",
                "1996: 66 255",
                "1997: 135 400",
                "1998: 115 277",
                "1999: 135 392",
                "2000: 99 319",
                "2001: 133 363",
                "2002: 93 307",
                "2003: 139 424",
                "2004: 62 212",
                "2005: 72 272",
                "2006: 150 425",
                "2007: 92 303",
                "2008: 62 188",
                "2009: 81 322",
                "2010: 143 408",
                "2011: 83 287",
                "2012: 111 355"
        };
        double xyAverage = 0;
        double yAverage = 0;
        double xSquareAverage = 0;
        double xAverage = 0;
        double a = 0;
//= (xyAverage - xAverage*yAverage) / (xSquareAverage - xAverage*xAverage)
        double b = 0;
//= yAverage - a*xAverage
        for (String d : data) {
            String[] splitted = d.split(" ");
            xyAverage += Double.parseDouble(splitted[1]) * Double.parseDouble(splitted[2]);
            xAverage += Double.parseDouble(splitted[1]);
            xSquareAverage += Double.parseDouble(splitted[1]) * Double.parseDouble(splitted[1]);
            yAverage += Double.parseDouble(splitted[2]);
        }
        xyAverage /= data.length;
        xAverage /= data.length;
        xSquareAverage /= data.length;
        yAverage /= data.length;
        a = (xyAverage - xAverage * yAverage) / (xSquareAverage - xAverage * xAverage);
        b = yAverage - a * xAverage;
        System.out.println(a + " " + b);
    }

}
