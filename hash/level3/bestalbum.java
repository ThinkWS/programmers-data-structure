import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        // 1. 장르별 총 재생수 + 노래 저장
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            
            genreSongs.putIfAbsent(g, new ArrayList<>());
            genreSongs.get(g).add(new int[]{i, p}); 
        }
        
        // 2. 장르 정렬 (총 재생수 기준)
        List<String> genreList = new ArrayList<>(genreTotal.keySet());
        genreList.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        // 3. 장르별 노래 정렬 후 2개 선택
        for(String g : genreList){
            List<int[]> songs = genreSongs.get(g);
            
            songs.sort((a, b) -> {
                if(b[1] == a[1]) return a[0] - b[0]; 
                return b[1] - a[1]; 
            });
            
            for(int i = 0; i < songs.size() && i < 2; i++){
                result.add(songs.get(i)[0]);
            }
        }
        
        // 4. 배열 변환
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
