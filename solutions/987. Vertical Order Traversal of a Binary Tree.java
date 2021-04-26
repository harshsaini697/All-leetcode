        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            HashMap<Integer, List<Integer>> row = new HashMap<>();
            for(int i = 0; i < size; i++){
               TreeNode curr = q.poll();
                int col = cols.poll();
                map.putIfAbsent(col, new ArrayList());
                //map.get(col).add(curr.val);
                row.putIfAbsent(col, new ArrayList());
                row.get(col).add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                    cols.add(col - 1);
                    min = Math.min(min, col - 1);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    cols.add(col + 1);
                    max = Math.max(max, col + 1);
                }
            }
            for(int col: row.keySet()){
                List<Integer> r = row.get(col);
                Collections.sort(r);
                map.get(col).addAll(r);
            }
            //System.out.println(row);
        }
        
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
