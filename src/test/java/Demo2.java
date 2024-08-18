import java.util.HashMap;
import java.util.Map;

public class Demo2
{
    public static void main(String[] args)
    {
        // "abc" "abcdef"

        //boolean found = isSubstringFound("abc", "abcdef"); // abc bcd
        boolean found = isSubstringFound("abcc", "abcdef"); // abc bcd
        System.out.println(found);
    }

    private static boolean isSubstringFound(String src, String target)
    {
        Map<Character, Integer> srcMap = new HashMap<>();
        for (Character c: src.toCharArray())
        {
            srcMap.put(c, srcMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < src.length() && i < target.length(); i++)
        {
            char c = target.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0 ; i < target.length() - src.length(); i++)
        {
            if (matchFound(srcMap, targetMap))
            {
                return true;
            }
            char c = target.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) - 1);
            if (targetMap.get(c) == 0)
            {
                targetMap.remove(c);
            }
            char c2 = target.charAt(i + src.length() - 1);
            targetMap.put(c2, targetMap.getOrDefault(c2, 0) + 1);
        }
        return false;
    }

    private static boolean matchFound(Map<Character, Integer> map1, Map<Character, Integer> map2)
    {
        if (map1.keySet().size() != map2.keySet().size())
        {
            return false;
        }

        return map1.equals(map2);
    }


}
