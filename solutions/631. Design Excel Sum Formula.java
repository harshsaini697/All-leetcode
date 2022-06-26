class Excel {
    Cell[][] sheet;
    public Excel(int height, char width) {
        sheet = new Cell[height + 1][parseColumn(width) + 1];
        for (int i = 0; i < sheet.length; i++)
            for (int j = 0; j < sheet[0].length; j++)
                sheet[i][j] = new Cell(0);
    }
    
    public void set(int row, char column, int val) {
        sheet[row][parseColumn(column)].set(val);
    }
    
    public int get(int row, char column) {
        return sheet[row][parseColumn(column)].val();
    }
    
    public int sum(int row, char column, String[] numbers) {
        Cell cell = sheet[row][parseColumn(column)];
        cell.set(0);
        for (String s : numbers) {
            int k = s.indexOf(':');
            if(k < 0) {
                int[] p = getPosition(s);
                cell.add(sheet[p[0]][p[1]]);
            } else {
                int[] start = getPosition(s.substring(0, k));
                int[] end = getPosition(s.substring(k + 1));
                
                for(int i = start[0]; i <= end[0]; i++) {
                    for(int j = start[1]; j <= end[1]; j++) {
                        cell.add(sheet[i][j]);
                    }
                }
            }
        }
        return cell.val();
    }
    
