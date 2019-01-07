package vo;

public class BoardBean {
	private int board_num;
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int re_ref;
	private int re_lev;
	private int re_step;
	private int board_readcount;
	private String board_date;
	public int getBoard_num() {
		return board_num;
	}
	public String getBoard_name() {
		return board_name == null ? "" : board_name.trim();
	}
	public String getBoard_pass() {
		return board_pass == null ? "" : board_pass.trim();
	}
	public String getBoard_subject() {
		return board_subject == null ? "" : board_subject.trim();
	}
	public String getBoard_content() {
		return board_content == null ? "" : board_content.trim();
	}
	public String getBoard_file() {
		return board_file == null ? "" : board_file.trim();
	}
	public int getre_ref() {
		return re_ref;
	}
	public int getre_lev() {
		return re_lev;
	}
	public int getre_step() {
		return re_step;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public void setre_ref(int board_re_ref) {
		this.re_ref = board_re_ref;
	}
	public void setre_lev(int board_re_lev) {
		this.re_lev = board_re_lev;
	}
	public void setre_step(int board_re_step) {
		this.re_step = board_re_step;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	
}
