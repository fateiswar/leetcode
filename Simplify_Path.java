public class Solution {
    public String simplifyPath(String path1) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] split = path1.split("/");
        if(split.length == 0) return "/";
        LinkedList<String> list = new LinkedList<String>();
        for(int i = 0; i < split.length; i++)
            if(split[i].equals("."))
                continue;
            else if(split[i].equals("..")){
                if(list.size() > 0)
                    list.pollLast();
            }else if(!split[i].equals("")) list.offerLast(split[i]);
        if(list.size() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for(Iterator<String> it = list.iterator(); it.hasNext(); ){
            sb.append("/");
            sb.append(it.next());
        }
        return sb.toString();
    }
}
