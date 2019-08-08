package data;

public class project {


	/**
	 * 分析間隔
	 * @author h-honda
	 */
	private int interval= 0;
	private int num_of_random = 0;
	private String inputfile = null;
	private String subject_fol = null;
	private String resultfile = null;


	/**
	 * 分析間隔の取得
	 * @author h-honda
	 * @return 分析間隔
	 */
	public int getNum_of_random() {
		return num_of_random;
	}

	/**
	 * 分析間隔の設定
	 * @author h-honda
	 * @param 分析間隔
	 */
	public void setNum_of_random(int num_of_random) {
		this.num_of_random = num_of_random;
	}
	/**
	 * 分析間隔の取得
	 * @author h-honda
	 * @return 分析間隔
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * 分析間隔の設定
	 * @author h-honda
	 * @param 分析間隔
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * <p>user情報の取得</p>
	 * @return UserID
	 */
	public String getInputfile() {
		return inputfile;
	}
	/**
	 * <p>UserID情報の設定</p>
	 * @param userid
	 */
	public void setInputfile(String inputfile) {
		this.inputfile = inputfile;
	}

	/**
	 * <p>user情報の取得</p>
	 * @return UserID
	 */
	public String getSubject_fol() {
		return subject_fol;
	}
	/**
	 * <p>UserID情報の設定</p>
	 * @param userid
	 */
	public void setSubject_fol(String subject_fol) {
		this.subject_fol = subject_fol;
	}


	/**
	 * <p>user情報の取得</p>
	 * @return UserID
	 */
	public String getResultfile() {
		return resultfile;
	}
	/**
	 * <p>UserID情報の設定</p>
	 * @param userid
	 */
	public void setResultfile(String resultfile) {
		this.resultfile= resultfile;
	}

}

