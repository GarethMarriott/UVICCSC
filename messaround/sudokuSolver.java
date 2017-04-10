



public class sudokuSolver{
	

	int[][] b = new int[9][9];


	public sudokuSolver(){

	}

	public void importSudoku(String s){
		for (int i = 0; i<b.length; i++) {
			for (int j = 0; j < b.length; j++) {

				int temp = Integer.parseInt(s.substring(0,1));
				s = s.substring(1);
				b[i][j] = temp;
			}
			
		}
		
	}

	public void solve(){

	}

	public boolean isSolved(){
		int[][] corners = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};

		for (int i = 0; i<b.length; i++) {
			boolean rowb = checkRow(i);
			boolean colb = checkCol(i);
			boolean sqrb = checkSquare(corners[i][0],corners[i][1]);
			if (!(rowb||colb||sqrb)) {
				return false;
			}
			
		}
		

		return true;
	}

	private boolean checkRow(int row){
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		boolean seven = false;
		boolean eight = false;
		boolean nine = false;
		for (int i = 0; i<b.length; i++) {
			int n = b[row][i];

			if (n==0) return false;
			if (n==1){
				if (one == true) {
					return false;
				}else {
					one = true;
				}
			}
			if (n==2){
				if (two == true) {
					return false;
				}else {
					two = true;
				}
			}
			if (n==3){
				if (three == true) {
					return false;
				}else {
					three = true;
				}
			}
			if (n==4){
				if (four == true) {
					return false;
				}else {
					four = true;
				}
			}
			if (n==5){
				if (five == true) {
					return false;
				}else {
					five = true;
				}
			}
			if (n==6){
				if (six == true) {
					return false;
				}else {
					six = true;
				}
			}
			if (n==7){
				if (seven == true) {
					return false;
				}else {
					seven = true;
				}
			}
			if (n==8){
				if (eight == true) {
					return false;
				}else {
					eight = true;
				}
			}
			if (n==9){
				if (nine == true) {
					return false;
				}else {
					nine = true;
				}
			}
		}
		return true;
	}

	private boolean checkCol(int col){
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		boolean seven = false;
		boolean eight = false;
		boolean nine = false;
		for (int i = 0; i<b.length; i++) {
			int n = b[i][col];

			if (n==0) return false;
			if (n==1){
				if (one == true) {
					return false;
				}else {
					one = true;
				}
			}
			if (n==2){
				if (two == true) {
					return false;
				}else {
					two = true;
				}
			}
			if (n==3){
				if (three == true) {
					return false;
				}else {
					three = true;
				}
			}
			if (n==4){
				if (four == true) {
					return false;
				}else {
					four = true;
				}
			}
			if (n==5){
				if (five == true) {
					return false;
				}else {
					five = true;
				}
			}
			if (n==6){
				if (six == true) {
					return false;
				}else {
					six = true;
				}
			}
			if (n==7){
				if (seven == true) {
					return false;
				}else {
					seven = true;
				}
			}
			if (n==8){
				if (eight == true) {
					return false;
				}else {
					eight = true;
				}
			}
			if (n==9){
				if (nine == true) {
					return false;
				}else {
					nine = true;
				}
			}
		}
		return true;
	}

	private boolean checkSquare(int topLeftCol , int topLeftRow){
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		boolean seven = false;
		boolean eight = false;
		boolean nine = false;
		for (int i = 0; i<9; i++) {
			int n;
			if (i==0) {
				n = b[topLeftRow][topLeftCol];
			}else if (i == 1) {
				n = b[topLeftRow+1][topLeftCol];
			}else if (i == 2) {
				n = b[topLeftRow+2][topLeftCol];
			}else if (i == 3) {
				n = b[topLeftRow][topLeftCol+1];
			}else if (i == 4) {
				n = b[topLeftRow+1][topLeftCol+1];
			}else if (i == 5) {
				n = b[topLeftRow+2][topLeftCol+1];
			}else if (i == 6) {
				n = b[topLeftRow][topLeftCol+2];
			}else if (i == 7) {
				n = b[topLeftRow+1][topLeftCol+2];
			}else{
				n = b[topLeftRow+2][topLeftCol+2];
			}
			

			if (n==0) return false;
			if (n==1){
				if (one == true) {
					return false;
				}else {
					one = true;
				}
			}
			if (n==2){
				if (two == true) {
					return false;
				}else {
					two = true;
				}
			}
			if (n==3){
				if (three == true) {
					return false;
				}else {
					three = true;
				}
			}
			if (n==4){
				if (four == true) {
					return false;
				}else {
					four = true;
				}
			}
			if (n==5){
				if (five == true) {
					return false;
				}else {
					five = true;
				}
			}
			if (n==6){
				if (six == true) {
					return false;
				}else {
					six = true;
				}
			}
			if (n==7){
				if (seven == true) {
					return false;
				}else {
					seven = true;
				}
			}
			if (n==8){
				if (eight == true) {
					return false;
				}else {
					eight = true;
				}
			}
			if (n==9){
				if (nine == true) {
					return false;
				}else {
					nine = true;
				}
			}
		}
		return true;
	}

	public void show(){
		for (int i = 0; i<b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String s = "534678912672195348198342567859761423426853791713924856961537284287419635435286179";
		sudokuSolver ss = new sudokuSolver();
		ss.importSudoku(s);
		System.out.println(ss.isSolved());
		ss.show();
	}
}