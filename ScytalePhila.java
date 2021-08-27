public scytale;
public class ScytalePhila {
    public static String scytaleEncode(String ThePlainText, int NumberOfRows){ /*The method is going to have 2 parameters: String & integer*/
        String Textencoded = ""; /*Then I will have an empty string, which I will use as a return value*/
        if(NumberOfRows>=ThePlainText.length() || NumberOfRows <= 0){ /*The number of rows must be greater than the plaintext length. The number of rows represents diameter of the rod*/
            return ThePlainText;
        }
        else{
            while(ThePlainText.length()%NumberOfRows!=0){ /*The modulas of plaintext and number of rows should be zero, if it's not you must add spaces.*/
                ThePlainText += " ";  /*I will now keep adding space*/

            }
            int NumberOfColumns = ThePlainText.length()/NumberOfRows; /*When the loop finish I need to calculate number of columns */
            for(int j = 0; j<NumberOfColumns; j++){ /*Now I will make nested for loop which is the loop inside another loop*/
                for(int x = j; x<ThePlainText.length(); x += NumberOfColumns){
                    Textencoded += ThePlainText.charAt(x); /*I now add characters in my encoded strings*/
                }
            }
        }
        return Textencoded; /*This is the method to encode String using Cipher*/
    }
    public static  String scytaleDecode(String StringEncoded, int numberOfRows){ /*I am now decoding my string. The key to decode is the number of rows which represents the diameter*/
        String StringDecoded = ""; /*This is the empty string which will be my return value*/
        int numberOfColumns = StringEncoded.length()/numberOfRows;
        StringDecoded = scytaleEncode(StringEncoded, numberOfColumns).trim(); /*Trim method is used to remove spaces*/
        return StringDecoded;



    }
    public static void main(String[] args) {
        String text = "Hi, My name is Phila Dyantyi";
        String encoded = scytaleEncode(text, 6);  /* this is where encryption happens :Number of rows represents the diameter of the rod */
        System.out.println(encoded);  /* encoded text is printed out : I am hiding the name given*/
        String decoded = scytaleDecode(encoded, 6);  /* this is where decryption happens */
        System.out.println(decoded);  /* decoded text is printed out: I am reveling the name given */

    }
}
