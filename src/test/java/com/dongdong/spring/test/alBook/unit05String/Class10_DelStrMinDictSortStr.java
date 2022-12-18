package com.dongdong.spring.test.alBook.unit05String;

/**
 * 删除多余字符得到字典序最小的字符串
 */
public class Class10_DelStrMinDictSortStr {

    private  static String removeDuplicateLetters(String s){
        char[] str=s.toCharArray();
        int[] map=new int[26];
        for(int i=0;i<str.length;i++){
            map[str[i]-'a']++;
        }
        char[] res=new char[26];
        int index=0;
        int L=0;
        int R=0;
        while(R!=str.length){
            if(map[str[R]-'a']==-1 || --map[str[R]-'a']>0){
                R++;
            }else {
                int pick=-1;
                for(int i=L;i<=R;i++){
                    if(map[str[i]-'a']!=- 1
                            && (pick==-1 || str[i]<str[pick])){
                        pick=i;
                    }
                }
                //把AsCII 码最小的字符串放到挑选结果中
                res[index++]=str[pick];
                //需要把str[pick+1...R]中每种字符出现的次数加回来
                for(int i=pick+1;i<=R;i++){
                    if(map[str[i]-'a']!=-1){
                        map[str[i]-'a']++;
                    }
                }
                //选出ASCII 码最小的字符，以后不再考虑了
                map[str[pick]-'a']=-1;
                //继续在str[pick+1...]上重复这个过程
                L=pick+1;
                R=L;
            }
        }
      return String.valueOf(res,0,index);
    }


    public static void main(String[] args) {
        String s="acbaccac";
        System.out.println(removeDuplicateLetters(s));
    }
}
