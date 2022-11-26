class Solution {
    public String convert(String s, int numRows) {
        if ( numRows == 1 ) return s ;
        int length = ( 2 * ( numRows-1 ) )  ;
        ArrayList<ArrayList<String>> lines = new ArrayList<>(length);
        for(int i=0; i < length; i++) 
            lines.add(new ArrayList(s.length()));
        for ( int i = 0 ; i < length ; i ++ ){
            for ( int j = i ; j <s.length();j += length )
                lines.get(i).add(Character.toString(s.charAt(j)));
        }
        String ans = "" ;
        for ( int i = 0 ; i < lines.get(0).size() ; i ++ )
            ans += lines.get(0).get(i) ;
        for ( int i = 1 ; i < numRows-1 ; i ++ ){
            int head = 0 ;
            int tail = 0 ;
            int longth = lines.get(i).size() + lines.get(length-i).size() ;
            for (int j = 0 ; j < longth ;j++) {
                if (  j % 2 == 0  )
                    ans += lines.get(i).get(head++) ;
                else
                    ans += lines.get(length-i).get(tail++) ;
            }
        }
        for ( int i = 0 ; i < lines.get(numRows-1).size() ; i ++ )
            ans += lines.get(numRows-1).get(i) ;
        
        return ans ;
    }
}
