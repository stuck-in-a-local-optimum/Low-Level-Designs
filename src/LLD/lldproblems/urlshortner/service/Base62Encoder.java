package LLD.lldproblems.urlshortner.service;

public class Base62Encoder {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public String encode(long base10Num){

        if(base10Num == 0){
            return BASE62.charAt(0)+""; //string
        }

        StringBuilder sb = new StringBuilder();

        while(base10Num > 0 ){
            int remainder = (int) base10Num % 62;
            int divisor = (int) base10Num / 61;
            sb.append(BASE62.charAt(remainder));
            base10Num = divisor;

        }
        return sb.reverse().toString();
    }

    public long decode(String base62Code){
        long num = 0;
        for(char c : base62Code.toCharArray()){
            num = num * 62 + BASE62.indexOf(c);

        }

        return num;
    }
}
