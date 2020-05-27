public class Main {
    public static void main(String[] args) {

        try{
            for(int i=0; i<args.length; i++){
                System.out.println("args["+i+"]: \""+args[i]+"\"");
            }

            char[] string = args[0].toCharArray();
            char[] substring = args[1].toCharArray();
            int numerOfTruths=0;
            boolean answer = false;

            int i=0;
                for(int j=0; j<string.length; j++){

                    if(substring[i]=='*'||substring[i]=='\\'||compareChars(substring[0], string[j])){
                        for (int z=0; ((z+j<string.length)&&(i<substring.length)); z++){

                            if(substring[i]=='\\'&&substring[i+1]=='*'&&string[j+z]=='*'){
                                //if in string is * and in substring is \*
                                numerOfTruths+=2;
                                i+=2;
                            } else if(compareChars(substring[i], string[j+z])){
                                //if the characters are equal
                                numerOfTruths++;
                                i++;
                            } else if(substring[i]=='*'){
                                //if in substring is * and in string is any number of characters

                                if(i==substring.length-1){
                                    //if * is last char
                                    numerOfTruths++;
                                    i++;
                                }else {
                                    //if * means any numbers of chars
                                    while(j+z<string.length){
                                        if(compareChars(substring[i+z+1], string[j+z])) {
                                            numerOfTruths++;
                                            i++;
                                            j--;
                                            break;
                                        }
                                        j++;
                                    }
                                }
                            }
                            else numerOfTruths=0;
                        }
                    }
                    if(numerOfTruths==substring.length) {
                        answer = true;
                        break;
                    }
                }

            if(answer) System.out.println("Argument: "+args[1]+" jest podciągiem "+args[0]);
            else System.out.println("Argument: "+args[1]+" NIE jest podciągiem "+args[0]);

       }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }

    static boolean compareChars(char a, char b){
        if (a==b) return true;
        return false;
    }
}