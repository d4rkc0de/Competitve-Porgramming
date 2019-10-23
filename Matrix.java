public static int[][] down(char[][] map) {
		int n = map.length, m = map[0].length;
		int[][] ret = new int[n][m];
		for(int i = n-1;i >= 0;i--){
			for(int j = 0;j < m;j++){
				ret[i][j] = i == n-1 ? 1 : ret[i+1][j] + 1;
				if(map[i][j] == '.')ret[i][j] = 0;
			}
		}
		return ret;
}

	public static char[][] rot(char[][] a) {
		int n = a.length, m = a[0].length;
		char[][] b = new char[m][n];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				b[j][n-1-i] = a[i][j];
			}
		}
		return b;
	}
	
	public static int[][] rot(int[][] a) {
		int n = a.length, m = a[0].length;
		int[][] b = new int[m][n];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				b[j][n-1-i] = a[i][j];
			}
		}
		return b;
	}